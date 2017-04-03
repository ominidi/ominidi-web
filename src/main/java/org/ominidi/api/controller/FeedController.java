package org.ominidi.api.controller;

import org.ominidi.api.exception.ConnectionException;
import org.ominidi.api.exception.NotFoundException;
import org.ominidi.api.model.Errors;
import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;
import org.ominidi.facebook.service.PageFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class FeedController {

    private PageFeedService pageFeedService;

    @Autowired
    public FeedController(PageFeedService pageFeedService) {
        this.pageFeedService = pageFeedService;
    }

    @GetMapping(value = "/feed", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Feed<Post> getFeed(@RequestParam(value = "u", required = false) Optional<String> feedUrl) {
        Optional<Feed<Post>> result = feedUrl.isPresent()
                ? pageFeedService.getFeed(feedUrl.get())
                : pageFeedService.getFeed();

        return result.orElseThrow(() -> new ConnectionException(Errors.CONNECTION_PROBLEM));
    }

    @GetMapping(value = "/post/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Post getPost(@PathVariable(value = "id") String id) {
        return pageFeedService.getPostById(id).orElseThrow(() -> new NotFoundException(Errors.postNotFound(id)));
    }
}
