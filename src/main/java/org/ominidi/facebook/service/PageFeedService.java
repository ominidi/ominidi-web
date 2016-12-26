package org.ominidi.facebook.service;

import com.restfb.Connection;
import com.restfb.types.Post;
import org.ominidi.facebook.repository.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageFeedService {
    private Feed pageFeed;

    @Autowired
    public PageFeedService(Feed pageFeed) {
        this.pageFeed = pageFeed;
    }

    public Connection<Post> getFeedPosts() {
        return null;
    }

    public Post getPostById(Long id) {
        return null;
    }
}
