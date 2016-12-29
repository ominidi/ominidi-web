package org.ominidi.facebook.mapper;

import com.restfb.Connection;
import com.restfb.DefaultJsonMapper;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.json.JsonObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ominidi.domain.model.Feed;
import org.ominidi.domain.model.Post;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FeedMapperTest {

    @Mock
    private FacebookClient facebookClient;

    private JsonMapper jsonMapper;

    private String json;

    @Before
    public void setUp() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get("src/test/resources/fixtures/feed.json"));
        json = new String(encoded);

        jsonMapper = new DefaultJsonMapper();
        when(facebookClient.getJsonMapper()).thenReturn(jsonMapper);
    }

    @Test
    public void shouldMapAConnectionObjectToAListOfPosts() {
        Connection<JsonObject> connection = new Connection<>(facebookClient, json, JsonObject.class);
        FeedMapper mapper = new FeedMapper(new PostMapper());

        Feed<Post> feed = mapper.fromType(connection);

        assertEquals(connection.getData().size(), feed.size().intValue());
    }
}
