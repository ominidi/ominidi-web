package org.ominidi.facebook.repository;

import java.io.IOException;

import com.restfb.*;
import com.restfb.types.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ominidi.Application;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(value = "test")
public class FeedIntegrationTest {

    protected FacebookClient.AccessToken token;

    protected FacebookClient client;

    @Autowired
    protected FacebookConfig facebookConfig;

    @Before
    public void setUp() throws IOException {
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
        token = DefaultFacebookClient.AccessToken.fromQueryString(response.getBody());
        client = new DefaultFacebookClient(token.getAccessToken(), appSecret, Version.VERSION_2_8);
    }

    @Test
    public void shouldReturnAListOfPostFromTheFeed() {
        Feed repository = new Feed(client, facebookConfig);
        Connection<Post> connection = repository.getConnection();

        assertNotNull(connection);
    }

    @Test
    public void shouldReturnASinglePostFromTheFeed() {
        Long id = 221946658231380L;
        Feed repository = new Feed(client, facebookConfig);
        Post post = repository.getObject(id);

        assertNotNull(post);
        assertEquals(id.toString(), post.getId());
    }
}
