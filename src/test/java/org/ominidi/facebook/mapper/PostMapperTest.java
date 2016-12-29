package org.ominidi.facebook.mapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.restfb.json.JsonObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ominidi.domain.model.Post;

import static org.junit.Assert.*;

public class PostMapperTest {
    private static JsonObject jsonObject;

    @BeforeClass
    public static void setUp() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get("src/test/resources/fixtures/post.json"));
        String str = new String(encoded);
        jsonObject = new JsonObject(str);
    }

    @Test
    public void shouldMapJsonValueToAPostObject()  {
        PostMapper mapper = new PostMapper();
        Post post = mapper.fromType(jsonObject);

        assertEquals(jsonObject.getString("id"), post.getId());
        assertEquals(jsonObject.getLong("object_id"), post.getObjectId().longValue());
        assertEquals(jsonObject.getString("type"), post.getType());
        assertEquals(jsonObject.getString("created_time"), post.getCreatedTime());
        assertEquals(jsonObject.getString("link"), post.getLink());
        assertEquals(jsonObject.getString("permalink_url"), post.getPermalinkUrl());
        assertEquals(jsonObject.getString("picture"), post.getPicture());
        assertEquals(jsonObject.getString("full_picture"), post.getFullPicture());
    }
}
