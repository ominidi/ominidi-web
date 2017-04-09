package org.ominidi.web.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class SeoViewModel {
    public Map<String, Page> pages;

    public SeoViewModel(Map<String, SeoViewModel.Page> pages) {
       this.pages = pages;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Page {
        private String title;
        private String description;

        @JsonProperty("og_url")
        private String ogUrl;

        @JsonProperty("og_image")
        private String ogImage;
    }
}