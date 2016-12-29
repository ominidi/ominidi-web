package org.ominidi.facebook.mapper;

import com.restfb.Connection;
import com.restfb.json.JsonObject;
import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;
import org.springframework.beans.factory.annotation.Autowired;

public class FeedMapper implements FromType<Connection<JsonObject>, Feed<Post>> {
    private PostMapper postMapper;

    @Autowired
    public FeedMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public Feed<Post> fromType(Connection<JsonObject> toMap) {
        return null;
    }
}
