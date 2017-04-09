package org.ominidi.web.viewmodel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SeoViewModelTest {
    private String path = "fixtures/seo.yml";

    private Map<String, SeoViewModel.Page> pages;

    @Before
    public void setUp() throws IOException {
        Resource resource = new ClassPathResource(path);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        pages = mapper.readValue(resource.getFile(), new TypeReference<Map<String, SeoViewModel.Page>>() {});
    }

    @Test
    public void itShouldFillPageViewModelFromAYamlFile() throws IOException {
        SeoViewModel seoViewModel = new SeoViewModel(pages);

        assertEquals(pages.size(), seoViewModel.getPages().size());
        SeoViewModel.Page testA = seoViewModel.getPages().get("test_a");

        assertEquals(pages.get("test_a").getTitle(), testA.getTitle());
        assertEquals(pages.get("test_a").getDescription(), testA.getDescription());
        assertEquals(pages.get("test_a").getOgUrl(), testA.getOgUrl());
        assertEquals(pages.get("test_a").getOgImage(), testA.getOgImage());
    }
}


