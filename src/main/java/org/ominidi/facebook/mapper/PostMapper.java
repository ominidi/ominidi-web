package org.ominidi.facebook.mapper;

import com.restfb.json.JsonObject;
import org.ominidi.domain.model.Post;

public class PostMapper implements FromType<JsonObject, Post> {

    @Override
    public Post fromType(JsonObject jsonObject) {
        return new Post(
                jsonObject.getString("id"),
                jsonObject.getLong("object_id"),
                jsonObject.getString("created_time"),
                jsonObject.getString("type"),
                jsonObject.getString("link"),
                jsonObject.getString("permalink_url"),
                jsonObject.getString("picture"),
                jsonObject.getString("full_picture"),
                jsonObject.getString("message")
        );
    }
}
