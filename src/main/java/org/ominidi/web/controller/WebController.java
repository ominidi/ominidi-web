package org.ominidi.web.controller;

import org.ominidi.web.factory.SeoViewModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    private SeoViewModelFactory seoViewModelFactory;

    @Autowired
    public WebController(SeoViewModelFactory seoViewModelFactory) {
        this.seoViewModelFactory = seoViewModelFactory;
    }

    @GetMapping({"/", "/manifesto"})
    public ModelAndView index()  {
        ModelAndView modelAndView = new ModelAndView("manifest");
        modelAndView.addObject("current", "manifest");
        return modelAndView;
    }

    @GetMapping("/foto")
    public ModelAndView photos()  {
        ModelAndView modelAndView = new ModelAndView("photos");
        modelAndView.addObject("current", "photos");
        return modelAndView;
    }

    @GetMapping("/attributions")
    public ModelAndView attributions()  {
        ModelAndView modelAndView = new ModelAndView("attributions");
        modelAndView.addObject("current", "attributions");
        return modelAndView;
    }

    @GetMapping("/downloads")
    public ModelAndView downloads()  {
        ModelAndView modelAndView = new ModelAndView("downloads");
        modelAndView.addObject("current", "downloads");
        return modelAndView;
    }
}
