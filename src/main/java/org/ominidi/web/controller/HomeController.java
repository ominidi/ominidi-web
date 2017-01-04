package org.ominidi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView index()  {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
