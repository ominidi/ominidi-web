package org.ominidi.facebook.repository;

import com.restfb.*;
import com.restfb.types.Post;
import org.junit.Test;
import org.ominidi.facebook.config.Page;

import java.io.IOException;

import static org.junit.Assert.*;

public class FeedIntegrationTest {

    public void setUp() {

    }

    @Test
    public void shouldReturnAListOfPostFromTheFeed() throws IOException {
//        FacebookClient.AccessToken token = new DefaultFacebookClient().obtainAppAccessToken("253231091758727", "08b663a226b8b750a07bc50566f3a305");
//        FacebookClient client = new DefaultFacebookClient(token.getAccessToken(), "08b663a226b8b750a07bc50566f3a305", Version.VERSION_2_8);

        WebRequestor webRequestor = new DefaultWebRequestor();
        WebRequestor.Response response = webRequestor.executeGet("https://graph.facebook.com/oauth/access_token?client_id=253231091758727&client_secret=08b663a226b8b750a07bc50566f3a305&grant_type=client_credentials");
        FacebookClient.AccessToken token = DefaultFacebookClient.AccessToken.fromQueryString(response.getBody());

        FacebookClient client = new DefaultFacebookClient(token.getAccessToken(), "08b663a226b8b750a07bc50566f3a305", Version.VERSION_2_8);
        Feed repository = new Feed(client);
        Connection<Post> connection = repository.getConnection();

        assertNotNull(connection);
    }
}
