package org.ominidi.api.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public final class HttpError {
    private final Integer code;

    private String message;

    public HttpError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
