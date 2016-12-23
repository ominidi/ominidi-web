package org.ominidi.facebook.service;

import com.restfb.Connection;
import com.restfb.types.Post;
import org.ominidi.Application;
import org.ominidi.facebook.repository.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageFeedService implements FeedAware {
    private Feed pageFeed;

    @Autowired
    public PageFeedService(Feed pageFeed) {
        this.pageFeed = pageFeed;
    }

    @Override
    public Connection<Post> getFeedPosts() {
        return pageFeed.getConnection();
    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }
}
