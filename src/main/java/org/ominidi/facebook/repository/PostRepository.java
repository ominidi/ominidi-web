package org.ominidi.facebook.repository;

import com.restfb.Connection;
import com.restfb.types.Post;

public interface PostRepository {
    Post getObject(Long id);

    Connection<Post> getConnection();
}
