package org.ominidi.facebook.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ominidi.facebook.repository.Feed;

import static org.mockito.Mockito.*;

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
}
