package org.ominidi.facebook.service;

import com.restfb.types.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ominidi.facebook.repository.Feed;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PageFeedServiceTest {

    @Mock
    private Feed feed;

    @Test
    public void shouldReturnAListOfPosts() {
        FeedAware service = new PageFeedService(feed);
        service.getFeedPosts();

        verify(feed).getConnection();
    }

    @Test
    public void shouldReturnASinglePost() {
        Long id = 221946658231380L;
        Post post = new Post();
        post.setId(id.toString());
        when(feed.getObject(id)).thenReturn(post);

        FeedAware service = new PageFeedService(feed);
        Post result = service.getPostById(id);

        verify(feed).getObject(id);
        assertEquals(id.toString(), result.getId());
    }
}
