package org.ominidi.facebook.repository;

import com.restfb.*;
import com.restfb.json.JsonObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ominidi.Application;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.ominidi.facebook.client.ClientFactory;
import org.ominidi.facebook.exception.ConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(value = "test")
public class PageFeedIntegrationTest {

    @Autowired
    private FacebookConfig facebookConfig;

    @Autowired
    private ClientFactory clientFactory;

    @Test
    public void shouldReturnAConnectionWithAFeedJsonObject() throws ConnectionException {
        PageFeed repository = new PageFeed(clientFactory, facebookConfig);
        Connection<JsonObject> connection = repository.getConnection();

        assertNotNull(connection);
        assertFalse(connection.getData().isEmpty());
    }

    @Test
    public void shouldReturnTheNextConnectionGivenAValidUrl() throws ConnectionException {
        String url = "https://graph.facebook.com/v2.8/221685698257476/feed?fields=id,object_id,created_time,type,link,permalink_url,picture,full_picture,message&limit=1&format=json&__paging_token=enc_AdAqTbjEyED3mQ71o6WewovlvxzEcTLx7MkZBKC4HxZANFcoXaxNsonvZBOxkyv1kBLkVHPPgh5wUVEZCl4SVmkgXHNCzbHn1KALCIQdoKLjdiqBwAZDZD&access_token=253231091758727|I3y2JqlMVz1eTEneDhFZ8FS6VcE&until=1481137002";
        PageFeed repository = new PageFeed(clientFactory, facebookConfig);
        Connection<JsonObject> connection = repository.getConnection(url);

        assertNotNull(connection);
    }

    @Test(expected = ConnectionException.class)
    public void shouldThrowAConnectionExceptionWithAnInvalidConnectionUrl() throws ConnectionException {
        String url = "http://invalid";
        PageFeed repository = new PageFeed(clientFactory, facebookConfig);
        Connection<JsonObject> connection = repository.getConnection(url);

        assertNotNull(connection);
    }

    @Test
    public void shouldReturnAPostJsonObject() throws ConnectionException {
        String id = "221685698257476_221946658231380";
        PageFeed repository = new PageFeed(clientFactory, facebookConfig);
        JsonObject json = repository.getObject(id);

        assertNotNull(json);
        assertEquals(id, json.getString("id", null));
    }

    @Test(expected = ConnectionException.class)
    public void shouldThrowAConnectionException() throws ConnectionException {
        String id = "1234123123xyz";
        PageFeed repository = new PageFeed(clientFactory, facebookConfig);
        repository.getObject(id);
    }
}
