package org.ominidi.web.controller;

import org.ominidi.facebook.configuration.FacebookConfig;
import org.ominidi.facebook.container.ClientFactory;
import org.ominidi.facebook.repository.PageFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
public class HomeController {
    private FacebookConfig facebookConfig;

    private ClientFactory clientFactory;

    @Autowired
    public HomeController(ClientFactory clientFactory, FacebookConfig facebookConfig) {
        this.clientFactory = clientFactory;
        this.facebookConfig = facebookConfig;
    }

    @GetMapping(value = "/home", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView index()  {
        PageFeed feed = new PageFeed(clientFactory, facebookConfig);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("feed", feed.getConnection());

        return modelAndView;
    }
}
