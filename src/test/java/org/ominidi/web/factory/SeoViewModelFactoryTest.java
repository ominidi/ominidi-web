package org.ominidi.web.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ominidi.Application;
import org.ominidi.web.viewmodel.SeoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(value = "test")
public class SeoViewModelFactoryTest {
    private String path = "fixtures/seo.yml";

    @Autowired
    protected SeoViewModelFactory seoViewModelFactory;

    @Test
    public void itShouldCreateASeoViewModel() throws IOException {
        SeoViewModel seoViewModel = seoViewModelFactory.getViewModel(path);

        assertNotNull(seoViewModel);
        assertEquals(2, seoViewModel.getPages().size());
    }

    @Test()
    public void itShouldThrowAnIOExceptionIfTheFileIsNotFound() {
        String message = "File xyx not found";

        try {
            seoViewModelFactory.getViewModel("xyx");
        } catch (FileNotFoundException e) {
            assertEquals(message, e.getMessage());
        }
    }
}
