package org.ominidi.web.viewmodel;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SeoViewModelTest {
    private Map<String, SeoViewModel.Page> pages;

    @Before
    public void setUp() throws IOException {
        pages = new HashMap<>();
        pages.put("test_a", new SeoViewModel.Page("A title", "A description", "//og.url.a", "//og.img.a.png"));
    }

    @Test
    public void itShouldFillPageViewModelFromAYamlFile() {
        SeoViewModel seoViewModel = new SeoViewModel(pages);
        assertEquals(pages.size(), seoViewModel.getPages().size());

        SeoViewModel.Page testA = seoViewModel.getPages().get("test_a");

        assertEquals(pages.get("test_a").getTitle(), testA.getTitle());
        assertEquals(pages.get("test_a").getDescription(), testA.getDescription());
        assertEquals(pages.get("test_a").getOgUrl(), testA.getOgUrl());
        assertEquals(pages.get("test_a").getOgImage(), testA.getOgImage());
    }

    @Test
    public void itShouldReturnAnEmptyMap() {
        SeoViewModel seoViewModel = new SeoViewModel();
        assertEquals(0, seoViewModel.getPages().size());
    }

    @Test(expected = NullPointerException.class)
    public void itShouldThrowAnExceptionIfPagesArgumentIsNull() {
        new SeoViewModel(null);
    }
}


