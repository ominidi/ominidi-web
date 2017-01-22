package org.ominidi.facebook.repository;

import com.restfb.Connection;
import com.restfb.json.JsonObject;
import org.ominidi.facebook.exception.ConnectionException;

public interface ConnectionAware {
    Connection<JsonObject> getConnection() throws ConnectionException;
    Connection<JsonObject> getConnection(String connectionPageUrl) throws ConnectionException;
    JsonObject getObject(String id) throws ConnectionException;
}
