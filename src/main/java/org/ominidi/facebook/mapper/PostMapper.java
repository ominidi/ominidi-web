package org.ominidi.facebook.mapper;

import com.restfb.json.JsonObject;
import org.ominidi.domain.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper implements FromType<JsonObject, Post> {

    @Override
    public Post fromType(JsonObject jsonObject) {
        return new Post(
                jsonObject.getString("id", null),
                jsonObject.getString("object_id", null),
                jsonObject.getString("created_time", null),
                jsonObject.getString("type", null),
                jsonObject.getString("link", null),
                jsonObject.getString("permalink_url", null),
                jsonObject.getString("picture", null),
                jsonObject.getString("full_picture", null),
                jsonObject.getString("message", null)
        );
    }
}
