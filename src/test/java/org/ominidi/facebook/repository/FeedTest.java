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

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FeedTest {

    @Mock
    private FacebookClient client;

    @Mock
    private FacebookConfig config;

    private Map<String, String> page = new HashMap<>();

    @Before
    public void setUp() {
        page.put("id", "221685698257476");
        page.put("feed_url", "/feed");
    }

    @Test
    public void shouldReturnAListOfPostFromTheFeed() {
        when(config.getPage()).thenReturn(page);
        Feed repository = new Feed(client, config);
        repository.getConnection();

        verify(client).fetchConnection( page.get("id") + page.get("feed_url"), Post.class, Parameter.with("fields", Field.getForFeed()));
    }

    @Test
    public void shouldReturnASinglePostFromTheFeed() {
        Long id = 221946658231380L;
        Feed repository = new Feed(client, config);
        repository.getObject(id);

        verify(client).fetchObject(id.toString(), Post.class, Parameter.with("fields", Field.getForPost()));
    }
}
