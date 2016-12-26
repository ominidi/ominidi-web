package org.ominidi.facebook.repository;

import java.util.Map;
import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.json.JsonObject;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.ominidi.facebook.client.ClientFactory;
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
    public Connection<JsonObject> getConnection() {
        Map<String, String> page = config.getPage();

        return client.fetchConnection(
                page.get("id") + page.get("feed_url"), JsonObject.class, Parameter.with("fields", Field.getForPost()));
    }

    @Override
    public JsonObject getObject(String id) {
        return client.fetchObject(id, JsonObject.class, Parameter.with("fields", Field.getForPost()));
    }
}

