package org.ominidi.api.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorsTest {
    @Test
    public void shouldMapVariousErrorMessage() {
        assertEquals("Problem connecting to the feed", Errors.CONNECTION_PROBLEM);
    }

    @Test
    public void shouldReturnAPostNotFoundMessageWithTheDesiredId() {
        assertEquals("Post with id 12 not found", Errors.postNotFound("12"));
        assertEquals("Post with id 221685698257476_221946658231380 not found", Errors.postNotFound("221685698257476_221946658231380"));
    }
}
