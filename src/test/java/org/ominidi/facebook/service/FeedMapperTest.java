package org.ominidi.facebook.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.restfb.json.JsonObject;
import org.junit.Before;
import org.junit.Test;
import org.ominidi.domain.model.Post;

import static org.junit.Assert.*;

public class FeedMapperTest {
    private JsonObject jsonObject;

    @Before
    public void setUp() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get("src/test/resources/fixtures/post.json"));
        String str = new String(encoded);
        jsonObject = new JsonObject(str);
    }

    @Test
    public void shouldMapJsonValueToAPostObject()  {
        FeedMapper mapper = new FeedMapper();
        Post post = mapper.fromJSON(jsonObject);

        assertEquals(jsonObject.get("id"), post.getId());
    }
}
