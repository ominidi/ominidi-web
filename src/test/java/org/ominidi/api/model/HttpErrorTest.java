package org.ominidi.api.model;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;

public class HttpErrorTest {
    @Test
    public void shouldHaveAStatusCodeAndAMessage() {
        String message = "Error";
        HttpError error =  new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);

        assertEquals(message, error.getMessage());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), error.getCode().intValue());
    }
}
