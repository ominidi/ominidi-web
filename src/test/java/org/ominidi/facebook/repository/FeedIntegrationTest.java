package org.ominidi.facebook.repository;

import java.io.IOException;

import com.restfb.*;
import com.restfb.types.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ominidi.Application;
import org.ominidi.facebook.configuration.FacebookConfig;
import org.ominidi.facebook.service.ClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(value = "test")
public class FeedIntegrationTest {

    private FacebookClient client;

    @Autowired
    private FacebookConfig facebookConfig;

    @Autowired
    private ClientFactory clientFactory;

    @Before
    public void setUp() throws IOException {
        client = clientFactory.getClient();
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
