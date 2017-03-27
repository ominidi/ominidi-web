package org.ominidi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    @GetMapping({"/", "/manifesto"})
    public ModelAndView index()  {
        ModelAndView modelAndView = new ModelAndView("manifest");
        return modelAndView;
    }

    @GetMapping("/foto")
    public ModelAndView photos()  {
        ModelAndView modelAndView = new ModelAndView("photos");
        return modelAndView;
    }

    @GetMapping("/attributions")
    public ModelAndView attributions()  {
        ModelAndView modelAndView = new ModelAndView("attributions");
        return modelAndView;
    }

    @GetMapping("/downloads")
    public ModelAndView downloads()  {
        ModelAndView modelAndView = new ModelAndView("downloads");
        return modelAndView;
    }
}
