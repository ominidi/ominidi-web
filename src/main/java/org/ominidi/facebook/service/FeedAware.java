package org.ominidi.facebook.service;

import java.util.Optional;
import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;

public interface FeedAware {
    Optional<Feed<Post>> getFeed();
    Optional<Feed<Post>> getFeed(String feedUrl);
    Optional<Post> getPostById(String id);
}
