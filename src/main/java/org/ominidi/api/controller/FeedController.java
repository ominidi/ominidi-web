package org.ominidi.api.controller;

import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;
import org.ominidi.facebook.service.PageFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
        return pageFeedService.getFeed().orElseThrow(() -> new RuntimeException("404"));
    }

    @GetMapping(value = "/feed/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Post getPost(@PathVariable(value = "id") String id) {
        System.out.println(id);
        return pageFeedService.getPostById(id).orElseThrow(() -> new RuntimeException("404"));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public void handle() {

    }
}
