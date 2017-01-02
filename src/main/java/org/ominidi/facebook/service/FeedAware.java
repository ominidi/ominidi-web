package org.ominidi.facebook.service;

import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;

public interface FeedAware {
    public Feed<Post> getFeed();
    public Feed<Post> getFeed(String feedUrl);
    public Post getPostById(String id);
}
