package org.ominidi.api.controller;

import org.ominidi.api.exception.ConnectionException;
import org.ominidi.api.exception.PostNotFoundException;
import org.ominidi.api.model.Errors;
import org.ominidi.api.model.HttpError;
import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;
import org.ominidi.facebook.service.PageFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FeedController {

    private PageFeedService pageFeedService;

    @Autowired
    public FeedController(PageFeedService pageFeedService) {
        this.pageFeedService = pageFeedService;
    }

    @GetMapping(value = "/feed", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Feed<Post> getFeed() {
        return pageFeedService.getFeed().orElseThrow(() -> new ConnectionException(Errors.CONNECTION_PROBLEM));
    }

    @GetMapping(value = "/feed/{pageUrl}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Feed<Post> getFeedByPageUrl() {
        return pageFeedService.getFeed().orElseThrow(() -> new ConnectionException(Errors.CONNECTION_PROBLEM));
    }

    @GetMapping(value = "/post/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Post getPost(@PathVariable(value = "id") String id) {
        return pageFeedService.getPostById(id).orElseThrow(() -> new PostNotFoundException(Errors.postNotFound(id)));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HttpError> handle(Exception e) {
        HttpStatus httpStatus = e.getClass().getAnnotation(ResponseStatus.class).value();
        HttpError error = new HttpError(httpStatus.value(), e.getMessage());
        return new ResponseEntity<>(error, httpStatus);
    }
}
