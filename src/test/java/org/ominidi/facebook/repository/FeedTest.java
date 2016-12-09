package org.ominidi.facebook.repository;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.types.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.ominidi.facebook.config.Page;
import org.ominidi.facebook.repository.Feed;

import java.util.Collection;

@RunWith(MockitoJUnitRunner.class)
public class FeedTest {

    @Mock
    private FacebookClient client;

    @Test
    public void itShouldReturnAListOfPost() {
        Feed repository = new Feed(client);
        Connection<Post> posts = repository.getConnection();

        verify(client).fetchConnection(Page.PAGE_ID + Page.FEED_URL, Post.class);
    }
}
