package org.ominidi.facebook.repository;

import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.ominidi.facebook.container.ClientFactory;

import java.util.HashMap;
import java.util.Map;

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
    }

    @Test
    public void shouldReturnAListOfPostFromTheFeed() {
        when(config.getPage()).thenReturn(page);
        PageFeed repository = new PageFeed(clientFactory, config);
        repository.getConnection();

        verify(clientFactory).getClient();
        verify(client).fetchConnection( page.get("id") + page.get("feed_url"), Post.class, Parameter.with("fields", Field.getForFeed()));
    }

    @Test
    public void shouldReturnASinglePostFromTheFeed() {
        Long id = 221946658231380L;
        PageFeed repository = new PageFeed(clientFactory, config);
        repository.getObject(id);

        verify(clientFactory).getClient();
        verify(client).fetchObject(id.toString(), Post.class, Parameter.with("fields", Field.getForPost()));
    }
}
