package org.ominidi.api.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ominidi.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
public class FeedControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testItShouldReturnAFeedJsonRepresentation() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/v1/feed/", String.class);
        String body = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertThat(body, containsString("posts"));
        assertThat(body, containsString("nextUrl"));
        assertThat(body, containsString("prevUrl"));
        assertThat(body, containsString("size"));
    }

    @Test
    public void testItShouldReturnAPostJsonRepresentation() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/v1/post/221685698257476_263132530779459", String.class);
        String body = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertThat(body, containsString("id"));
        assertThat(JsonPath.read(body, "$.id"), equalTo("221685698257476_263132530779459"));
    }

    @Test
    public void testItShouldReturnANotFoundResponse() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/v1/post/xyz", String.class);
        String body = responseEntity.getBody();

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        assertThat(body, containsString("code"));
        assertThat(body, containsString("message"));
        assertThat(JsonPath.read(body, "$.code"), equalTo(HttpStatus.NOT_FOUND.value()));
        assertThat(JsonPath.read(body, "$.message"), equalTo("Post with id xyz not found"));
    }
}
