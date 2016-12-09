package org.ominidi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/home")
    public String paolo() {
        System.out.println("AUA---------");
        return "Hello";
    }
}
