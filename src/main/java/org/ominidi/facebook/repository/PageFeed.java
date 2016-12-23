package org.ominidi.facebook.repository;

import java.io.IOException;
import java.util.Map;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.ominidi.facebook.container.ClientFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PageFeed implements Feed {
    private FacebookClient client;

    private FacebookConfig config;

    public PageFeed(ClientFactory clientFactory, FacebookConfig config) {
        this.config = config;
        this.client = clientFactory.getClient();
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

