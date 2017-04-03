package org.ominidi.api.model;

import lombok.Getter;

@Getter
public final class Message {
    private final Integer code;

    private String message;

    public Message(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
