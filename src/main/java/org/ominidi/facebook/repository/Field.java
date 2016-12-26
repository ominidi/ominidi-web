package org.ominidi.facebook.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Field {
    ID,
    OBJECT_ID,
    CREATED_TIME,
    TYPE,
    LINK,
    PERMALINK_URL,
    PICTURE,
    FULL_PICTURE,
    MESSAGE;

    public static final String getForPost() {
        List<String> fields = Arrays
                .asList(ID, OBJECT_ID, CREATED_TIME, TYPE, LINK, PERMALINK_URL, PICTURE, FULL_PICTURE, MESSAGE)
                .stream()
                .map((Field field) -> field.toString())
                .collect(Collectors.toList());

        return String.join(",", fields);
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
