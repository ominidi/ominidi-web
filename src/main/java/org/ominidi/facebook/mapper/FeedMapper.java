package org.ominidi.facebook.mapper;

import com.restfb.Connection;
import com.restfb.json.JsonObject;
import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeedMapper implements FromType<Connection<JsonObject>, Feed<Post>> {
    private PostMapper postMapper;

    @Autowired
    public FeedMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public Feed<Post> fromType(Connection<JsonObject> toMap) {
        List<Post> posts = toMap.getData().stream().map(jsonObject -> new Post(
                jsonObject.getString("id", null),
                jsonObject.getString("object_id", null),
                jsonObject.getString("created_time", null),
                jsonObject.getString("type", null),
                jsonObject.getString("link", null),
                jsonObject.getString("permalink_url", null),
                jsonObject.getString("picture", null),
                jsonObject.getString("full_picture", null),
                jsonObject.getString("message", null)
        )).collect(Collectors.toList());

        return new Feed<>(posts, toMap.getNextPageUrl(), toMap.getPreviousPageUrl());
    }
}
