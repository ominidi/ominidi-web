package org.ominidi.facebook.repository;

import java.util.Map;
import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookException;
import com.restfb.json.JsonObject;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.ominidi.facebook.client.ClientFactory;
import org.ominidi.facebook.exception.ConnectionException;
import org.springframework.stereotype.Repository;

@Repository
public class PageFeed implements ConnectionAware {
    private FacebookClient client;

    private FacebookConfig config;

    public PageFeed(ClientFactory clientFactory, FacebookConfig config) {
        this.config = config;
        this.client = clientFactory.getClient();
    }

    @Override
    public Connection<JsonObject> getConnection() throws ConnectionException {
        Map<String, String> page = config.getPage();

        try {
            return client.fetchConnection(
                    page.get("id") + page.get("feed_url"), JsonObject.class, Parameter.with("fields", Field.getForPost()));
        } catch(FacebookException e) {
            throw new ConnectionException(e.getMessage(), e);
        }
    }

    @Override
    public Connection<JsonObject> getConnection(String connectionPageUrl) throws ConnectionException {
        try {
            return client.fetchConnectionPage(connectionPageUrl, JsonObject.class);
        } catch(FacebookException e) {
            throw new ConnectionException(e.getMessage(), e);
        }
    }

    @Override
    public JsonObject getObject(String id) throws ConnectionException {
        try {
            return client.fetchObject(id, JsonObject.class, Parameter.with("fields", Field.getForPost()));
        } catch (FacebookException e) {
           throw new ConnectionException(e.getMessage(), e);
        }
    }
}
