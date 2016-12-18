package org.ominidi.web.controller;

import org.ominidi.facebook.configuration.FacebookConfig;
import org.ominidi.facebook.repository.Feed;
import org.ominidi.facebook.service.ClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
public class HomeController {
    @Autowired
    private FacebookConfig facebookConfig;

    @Autowired
    private ClientFactory clientFactory;

    @GetMapping(value = "/home", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView index() throws IOException {
        Feed feed = new Feed(clientFactory.getClient(), facebookConfig);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("feed", feed.getConnection());

        return modelAndView;
    }
}
