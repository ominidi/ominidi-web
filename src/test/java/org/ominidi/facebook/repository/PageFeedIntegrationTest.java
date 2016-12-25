package org.ominidi.facebook.repository;

import com.restfb.*;
import com.restfb.json.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ominidi.Application;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.ominidi.facebook.client.ClientFactory;
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
    public void shouldReturnAListOfPostFromTheFeed() {
        PageFeed repository = new PageFeed(clientFactory, facebookConfig);
        Connection<JsonObject> connection = repository.getConnection();

        assertNotNull(connection);
    }

    @Test
    public void shouldReturnASinglePostFromTheFeed() {
        String id = "221685698257476_221946658231380";
        PageFeed repository = new PageFeed(clientFactory, facebookConfig);
        JsonObject json = repository.getObject(id);

        assertNotNull(json);
        assertEquals(id,json.get("id"));
    }
}
