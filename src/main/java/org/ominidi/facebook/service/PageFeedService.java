package org.ominidi.facebook.service;

import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;
import org.ominidi.facebook.mapper.FeedMapper;
import org.ominidi.facebook.mapper.PostMapper;
import org.ominidi.facebook.repository.ConnectionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageFeedService implements FeedAware {
    private ConnectionAware pageFeed;

    private FeedMapper feedMapper;

    private PostMapper postMapper;

    @Autowired
    public PageFeedService(ConnectionAware pageFeed, FeedMapper feedMapper, PostMapper postMapper) {
        this.pageFeed = pageFeed;
        this.feedMapper = feedMapper;
        this.postMapper = postMapper;
    }

    @Override
    public Feed<Post> getFeed() {
        return feedMapper.fromType(pageFeed.getConnection());
    }

    @Override
    public Feed<Post> getFeed(String feedUrl) {
        return feedMapper.fromType(pageFeed.getConnection(feedUrl));
    }

    @Override
    public Post getPostById(String id) {
        return postMapper.fromType(pageFeed.getObject(id));
    }
}
