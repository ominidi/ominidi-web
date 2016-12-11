package org.ominidi.web.controller;

import org.ominidi.facebook.configuration.FacebookConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private FacebookConfig facebookConfig;

    @RequestMapping("/")
    public String index() {
        return facebookConfig.getPage().get("id");
    }
}
