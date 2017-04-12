package org.ominidi.web.controller;

import org.ominidi.web.factory.SeoViewModelFactory;
import org.ominidi.web.viewmodel.SeoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class WebController {
    private SeoViewModelFactory seoViewModelFactory;

    private SeoViewModel seoViewModel;

    @Autowired
    public WebController(SeoViewModelFactory seoViewModelFactory) throws IOException {
        this.seoViewModelFactory = seoViewModelFactory;
        this.seoViewModel = seoViewModelFactory.getViewModel("config/seo.yml");
    }

    @GetMapping({"/", "/manifesto"})
    public ModelAndView index(HttpServletRequest request) {
        String page = request.getRequestURI().equals("/") ? "index" : "manifest";
        ModelAndView modelAndView = new ModelAndView("manifest");
        modelAndView.addObject("current", "manifest")
                .addObject("seo", seoViewModel.getPages().get(page));
        return modelAndView;
    }

    @GetMapping("/foto")
    public ModelAndView photos() {
        ModelAndView modelAndView = new ModelAndView("photos");
        modelAndView.addObject("current", "photos")
                .addObject("seo", seoViewModel.getPages().get("photos"));

        return modelAndView;
    }

    @GetMapping("/attributions")
    public ModelAndView attributions() {
        ModelAndView modelAndView = new ModelAndView("attributions");
        modelAndView.addObject("current", "attributions")
                .addObject("seo", seoViewModel.getPages().get("attributions"));

        return modelAndView;
    }

    @GetMapping("/downloads")
    public ModelAndView downloads() {
        ModelAndView modelAndView = new ModelAndView("downloads");
        modelAndView.addObject("current", "downloads")
                .addObject("seo", seoViewModel.getPages().get("downloads"));

        return modelAndView;
    }
}
