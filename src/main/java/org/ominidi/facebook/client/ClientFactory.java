package org.ominidi.facebook.client;

import com.restfb.*;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(FacebookConfig.class)
public class ClientFactory {

    @Autowired
    private FacebookConfig facebookConfig;

    public FacebookClient getClient() {
        String appId = facebookConfig.getApplication().get("app_id");
        String appSecret = facebookConfig.getApplication().get("app_secret");

        FacebookClient.AccessToken token = new DefaultFacebookClient(Version.VERSION_2_8).obtainAppAccessToken(appId, appSecret);
        return new DefaultFacebookClient(token.getAccessToken(), appSecret, Version.VERSION_2_8);
    }
}
