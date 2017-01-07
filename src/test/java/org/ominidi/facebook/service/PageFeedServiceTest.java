package org.ominidi.facebook.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.restfb.Connection;
import com.restfb.json.JsonObject;
import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;
import org.ominidi.facebook.mapper.FeedMapper;
import org.ominidi.facebook.mapper.PostMapper;
import org.ominidi.facebook.repository.ConnectionAware;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PageFeedServiceTest {
    @Mock
    private Connection<JsonObject> connection;

    @Mock
    private ConnectionAware pageFeed;

    @Mock
    private FeedMapper feedMapper;

    @Mock
    private PostMapper postMapper;

    @Mock
    private JsonObject jsonObject;

    @Mock
    private Feed<Post> feed;

    @Mock
    private Post post;

    @Test
    public void shouldReturnAnOptionalListOfPosts() throws Exception {
        when(pageFeed.getConnection()).thenReturn(connection);
        when(feedMapper.fromType(connection)).thenReturn(feed);

        FeedAware service = new PageFeedService(pageFeed, feedMapper, postMapper);
        Optional<Feed<Post>> result = service.getFeed();

        verify(pageFeed).getConnection();
        verify(feedMapper).fromType(connection);

        assertTrue(result.isPresent());
        assertNotNull(result.get());
    }

    @Test
    public void shouldReturnAListOfPostsGivenAFeedUrl() throws Exception {
        String feedUrl = "http://www.feed.it";
        when(pageFeed.getConnection(feedUrl)).thenReturn(connection);
        when(feedMapper.fromType(connection)).thenReturn(feed);

        FeedAware service = new PageFeedService(pageFeed, feedMapper, postMapper);
        Optional<Feed<Post>> result = service.getFeed(feedUrl);

        verify(pageFeed).getConnection(feedUrl);
        verify(feedMapper).fromType(connection);

        assertTrue(result.isPresent());
        assertNotNull(result.get());
    }

    @Test
    public void shouldReturnASinglePost() throws Exception{
        String id = "221685698257476_221946658231380";
        when(pageFeed.getObject(id)).thenReturn(jsonObject);
        when(postMapper.fromType(jsonObject)).thenReturn(post);

        FeedAware service = new PageFeedService(pageFeed, feedMapper, postMapper);
        Optional<Post> result = service.getPostById(id);

        verify(pageFeed).getObject(id);
        verify(postMapper).fromType(jsonObject);

        assertTrue(result.isPresent());
        assertNotNull(result.get());
    }
}
