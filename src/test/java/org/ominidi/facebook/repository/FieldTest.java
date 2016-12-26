package org.ominidi.facebook.repository;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void shouldReturnAListOfFieldValidToFetchASinglePost() {
        String fields = "id,object_id,created_time,type,link,permalink_url,picture,full_picture,message";
        assertEquals(fields, Field.getForPost());
    }
}
