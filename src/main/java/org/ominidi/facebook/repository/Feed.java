package org.ominidi.facebook.repository;

import java.util.Map;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
import org.ominidi.facebook.configuration.FacebookConfig;

public class Feed implements PostRepository {
    protected FacebookClient client;

    protected FacebookConfig config;

    public Feed(FacebookClient client, FacebookConfig config) {
        this.client = client;
        this.config = config;
    }

    @Override
    public Connection<Post> getConnection() {
        Map<String, String> page = config.getPage();

        return client.fetchConnection(
                page.get("id") + page.get("feed_url"), Post.class, Parameter.with("fields", Field.getForFeed())
        );
    }

    @Override
    public com.restfb.types.Post getObject(Long id) {
        return client.fetchObject(
                id.toString(), Post.class, Parameter.with("fields", Field.getForPost())
        );
    }
}

