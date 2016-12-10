package org.ominidi.facebook.repository;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.ominidi.facebook.config.Page;


@RunWith(MockitoJUnitRunner.class)
public class FeedTest {

    @Mock
    private FacebookClient client;

    @Test
    public void shouldReturnAListOfPostFromTheFeed() {
        Feed repository = new Feed(client);
        Connection<Post> posts = repository.getConnection();

        verify(client).fetchConnection(Page.PAGE_ID + Page.PAGE_FEED_URL, Post.class, Parameter.with("fields", Field.getForFeed()));
    }

    @Test
    public void shouldReturnASinglePostFromTheFeed() {
        Long id = 221946658231380L;
        Feed repository = new Feed(client);
        Post post = repository.getObject(id);

        verify(client).fetchObject(id.toString(), Post.class, Parameter.with("fields", Field.getForPost()));
    }
}
