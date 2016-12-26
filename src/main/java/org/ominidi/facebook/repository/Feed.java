package org.ominidi.facebook.repository;

import com.restfb.Connection;
import com.restfb.json.JsonObject;

public interface Feed {
    JsonObject getObject(String id);
    Connection<JsonObject> getConnection();
    Connection<JsonObject> getConnection(String connectionPageUrl);
}
