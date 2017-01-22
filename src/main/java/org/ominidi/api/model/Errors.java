package org.ominidi.api.model;

public final class Errors {
    public static final String CONNECTION_PROBLEM = "Problem connecting to the feed";

    public static final String postNotFound(String id) {
        return "Post with id " + id + " not found";
    }
}
