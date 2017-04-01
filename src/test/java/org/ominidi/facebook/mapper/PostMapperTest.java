package org.ominidi.facebook.mapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.restfb.json.Json;
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
        jsonObject = Json.parse(str).asObject();
    }

    @Test
    public void shouldMapJsonValueToAPostObject()  {
        PostMapper mapper = new PostMapper();
        Post post = mapper.fromType(jsonObject);

        assertEquals(jsonObject.getString("id", null), post.getId());
//        assertEquals(jsonObject.getLong("object_id", 0), post.getObjectId().longValue());
        assertEquals(jsonObject.getString("type", null), post.getType());
        assertEquals(jsonObject.getString("created_time", null), post.getCreatedTime());
        assertEquals(jsonObject.getString("link", null), post.getLink());
        assertEquals(jsonObject.getString("permalink_url", null), post.getPermalinkUrl());
        assertEquals(jsonObject.getString("picture", null), post.getPicture());
        assertEquals(jsonObject.getString("full_picture", null), post.getFullPicture());
        assertEquals(jsonObject.getString("message", null), post.getMessage());
    }
}
