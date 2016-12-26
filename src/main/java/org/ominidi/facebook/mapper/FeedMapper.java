package org.ominidi.facebook.mapper;

import com.restfb.Connection;
import com.restfb.json.JsonObject;
import org.ominidi.domain.model.Post;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FeedMapper implements FromType<Connection<JsonObject>, List<Post>> {
    private PostMapper postMapper;

    @Autowired
    public FeedMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public List<Post> fromType(Connection<JsonObject> toMap) {
        return null;
    }
}
