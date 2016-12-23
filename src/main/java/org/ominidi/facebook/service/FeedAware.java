package org.ominidi.facebook.service;

import com.restfb.Connection;
import com.restfb.types.Post;

public interface FeedAware {
    public Connection<Post> getFeedPosts();
    public Post getPostById(Long id);
}
