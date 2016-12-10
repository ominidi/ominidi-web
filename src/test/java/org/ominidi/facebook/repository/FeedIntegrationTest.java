package org.ominidi.facebook.repository;

import com.restfb.*;
import com.restfb.types.Post;
import org.junit.Before;
import org.junit.Test;
import org.ominidi.facebook.config.App;
import java.io.IOException;

import static org.junit.Assert.*;

public class FeedIntegrationTest {

    protected FacebookClient.AccessToken token;

    @Before
    public void setUp() throws IOException {
        WebRequestor webRequestor = new DefaultWebRequestor();
        WebRequestor.Response response = webRequestor.executeGet("https://graph.facebook.com/oauth/access_token" + "?client_id=" + App.APP_ID + "&client_secret=" + App.APP_SECRET + "&grant_type=client_credentials");
        token = DefaultFacebookClient.AccessToken.fromQueryString(response.getBody());
    }

    @Test
    public void shouldReturnAListOfPostFromTheFeed() {
        System.out.println(token);
        FacebookClient client = new DefaultFacebookClient(token.getAccessToken(), App.APP_SECRET, Version.VERSION_2_8);
        Feed repository = new Feed(client);
        Connection<Post> connection = repository.getConnection();

        assertNotNull(connection);
    }

    @Test
    public void shouldReturnASinglePostFromTheFeed() {
        Long id = 221946658231380L;
        FacebookClient client = new DefaultFacebookClient(token.getAccessToken(), App.APP_SECRET, Version.VERSION_2_8);
        Feed repository = new Feed(client);

        Post post = repository.getObject(id);
        assertNotNull(post);
        assertEquals(id.toString(), post.getId());
    }
}
