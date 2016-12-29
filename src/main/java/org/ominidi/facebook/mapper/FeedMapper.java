package org.ominidi.facebook.mapper;

import com.restfb.Connection;
import com.restfb.json.JsonObject;
import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class FeedMapper implements FromType<Connection<JsonObject>, Feed<Post>> {
    private PostMapper postMapper;

    @Autowired
    public FeedMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public Feed<Post> fromType(Connection<JsonObject> toMap) {
        List<Post> posts = toMap.getData().stream().map(jsonObject -> new Post(
                jsonObject.getString("id"),
                jsonObject.getLong("object_id"),
                jsonObject.getString("type"),
                jsonObject.getString("created_time"),
                jsonObject.getString("link"),
                jsonObject.getString("permalink_url"),
                jsonObject.getString("picture"),
                jsonObject.getString("full_picture"),
                jsonObject.getString("message")
        )).collect(Collectors.toList());

        try {
            return new Feed<>(posts, new URL(toMap.getNextPageUrl()), new URL(toMap.getPreviousPageUrl()));
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
