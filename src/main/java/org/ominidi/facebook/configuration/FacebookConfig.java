package org.ominidi.facebook.configuration;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "facebook")
public class FacebookConfig {
    private String graphAccessTokenUri;
    private Map<String, String> page = new HashMap<>();
    private Map<String, String> application = new HashMap<>();
}
