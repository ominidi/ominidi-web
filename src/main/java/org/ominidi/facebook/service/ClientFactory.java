package org.ominidi.facebook.service;

import com.restfb.*;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClientFactory {

    private FacebookConfig facebookConfig;

    @Autowired
    public ClientFactory(FacebookConfig facebookConfig) {
        this.facebookConfig = facebookConfig;
    }

    public FacebookClient getClient() throws IOException {
        String appId = facebookConfig.getApplication().get("app_id");
        String appSecret = facebookConfig.getApplication().get("app_secret");

        WebRequestor webRequestor = new DefaultWebRequestor();
        WebRequestor.Response response = webRequestor.executeGet(facebookConfig.getGraphAccessTokenUri()
                + "?client_id="
                + appId
                + "&client_secret="
                + appSecret
                + "&grant_type=client_credentials"
        );
        FacebookClient.AccessToken token = DefaultFacebookClient.AccessToken.fromQueryString(response.getBody());
        return new DefaultFacebookClient(token.getAccessToken(), appSecret, Version.VERSION_2_8);
    }
}
