package org.ominidi.facebook.repository;

import java.util.HashMap;
import java.util.Map;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookException;
import com.restfb.json.JsonObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.ominidi.facebook.client.ClientFactory;
import org.ominidi.facebook.exception.ConnectionException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PageFeedTest {

    @Mock
    private FacebookClient client;

    @Mock
    private FacebookConfig config;

    @Mock
    private ClientFactory clientFactory;

    private Map<String, String> page = new HashMap<>();

    @Before
    public void setUp() {
        page.put("id", "221685698257476");
        page.put("feed_url", "/feed");

        when(clientFactory.getClient()).thenReturn(client);
        when(config.getPage()).thenReturn(page);
    }

    @Test
    public void shouldReturnAConnectionWithAFeedJsonObject() throws ConnectionException {
        PageFeed repository = new PageFeed(clientFactory, config);
        repository.getConnection();

        verify(clientFactory).getClient();
        verify(client).fetchConnection(page.get("id") + page.get("feed_url"), JsonObject.class, Parameter.with("fields", Field.getForPost()));
    }

    @Test
    public void shouldThrowAConnectionExceptionOnClientConnectionError() {
        String message = "Facebook client error";
        when(client.fetchConnection(page.get("id") + page.get("feed_url"), JsonObject.class, Parameter.with("fields", Field.getForPost())))
                .thenThrow(new FacebookException(message) {
                    @Override
                    public String getMessage() {
                        return super.getMessage();
                    }
                });

        PageFeed repository = new PageFeed(clientFactory, config);

        try {
            repository.getConnection();
            fail("PageFeed repository should throw a ConnectionException on facebook client error");
        } catch (ConnectionException e) {
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void shouldReturnAConnectionWithAFeedJsonObjectWithTheSpecifiedUrl() throws ConnectionException {
        String url = "http://next";
        PageFeed repository = new PageFeed(clientFactory, config);
        repository.getConnection(url);

        verify(clientFactory).getClient();
        verify(client).fetchConnectionPage(url, JsonObject.class);
    }

    @Test
    public void shouldReturnAPostJsonObject() throws ConnectionException {
        String id = "221685698257476_221946658231380";
        PageFeed repository = new PageFeed(clientFactory, config);
        repository.getObject(id);

        verify(clientFactory).getClient();
        verify(client).fetchObject(id, JsonObject.class, Parameter.with("fields", Field.getForPost()));
    }

    @Test
    public void shouldThrowAConnectionException() {
        String id = "not.existent.id";
        String message = "Connection exception";
        when(client.fetchObject(id, JsonObject.class, Parameter.with("fields", Field.getForPost())))
                .thenThrow(new FacebookException(message) {
                    @Override
                    public String getMessage() {
                        return super.getMessage();
                    }
                });

        PageFeed repository = new PageFeed(clientFactory, config);

        try {
            repository.getObject(id);
            fail("PageFeed repository should throw a ConnectionException on not valid object id");
        } catch (ConnectionException e) {
            assertEquals(message, e.getMessage());
        }
    }
}
