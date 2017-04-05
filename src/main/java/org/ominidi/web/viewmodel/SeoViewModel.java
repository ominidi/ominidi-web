package org.ominidi.web.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Getter
@Setter
@Component
public class SeoViewModel {
    public Map<String, Object> pages;

    public SeoViewModel() {
//        Resource resource = new ClassPathResource("config/seo.yml");
//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        pages = mapper.readValue(resource.getFile(), new TypeReference<Map<String, Page>>() {});
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Page {
        private String title;
        private String description;

        @JsonProperty("og_url")
        private String ogUrl;

        @JsonProperty("og_image")
        private String ogImage;
    }
}