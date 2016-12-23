package org.ominidi.facebook.container;

import com.restfb.*;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.IOException;

@Configuration
@Import(FacebookConfig.class)
public class ClientFactory {

    @Autowired
    private FacebookConfig facebookConfig;

    public FacebookClient getClient() {
        String appId = facebookConfig.getApplication().get("app_id");
        String appSecret = facebookConfig.getApplication().get("app_secret");
        WebRequestor webRequestor = new DefaultWebRequestor();

        try {
            WebRequestor.Response response = webRequestor.executeGet(facebookConfig.getGraphAccessTokenUri()
                    + "?client_id="
                    + appId
                    + "&client_secret="
                    + appSecret
                    + "&grant_type=client_credentials"
            );
            FacebookClient.AccessToken token = DefaultFacebookClient.AccessToken.fromQueryString(response.getBody());
            return new DefaultFacebookClient(token.getAccessToken(), appSecret, Version.VERSION_2_8);
        } catch (IOException e) {
            // @// TODO: 23/12/2016 to log
        }
        
        return null;
    }
}
