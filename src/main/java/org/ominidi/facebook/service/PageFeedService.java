package org.ominidi.facebook.service;

import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;
import org.ominidi.facebook.exception.ConnectionException;
import org.ominidi.facebook.mapper.FeedMapper;
import org.ominidi.facebook.mapper.PostMapper;
import org.ominidi.facebook.repository.ConnectionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<Feed<Post>> getFeed() {
        try {
            return Optional.of(feedMapper.fromType(pageFeed.getConnection()));
        } catch (ConnectionException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Feed<Post>> getFeed(String feedUrl) {
        try {
            return Optional.of(feedMapper.fromType(pageFeed.getConnection(feedUrl)));
        } catch (ConnectionException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Post> getPostById(String id) {
        try {
            return Optional.of(postMapper.fromType(pageFeed.getObject(id)));
        } catch (ConnectionException e) {
            return Optional.empty();
        }
    }
}
