package org.ominidi.web.factory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.ominidi.web.viewmodel.SeoViewModel;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

@Configuration
public class SeoViewModelFactory {

    public SeoViewModel getViewModel(String path) throws FileNotFoundException {
        Map<String, SeoViewModel.Page> pages;
        Resource resource = new ClassPathResource(path);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            pages = mapper.readValue(resource.getURL(), new TypeReference<Map<String, SeoViewModel.Page>>() {});
            return new SeoViewModel(pages);
        } catch (IOException e) {
            throw new FileNotFoundException("File " + path + " not found");
        }
    }
}
