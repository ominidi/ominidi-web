package org.ominidi.domain.model;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FeedTest {
    private Post post;
    private URL next;
    private URL prev;

    @Before
    public void setUp() throws MalformedURLException {
        post = new Post(
                "221946658231380_221946658231380",
                "221946658231380",
                "2016-12-07T18:56:42+0000",
                "photo",
                "https://www.facebook.com/ominidi.org/link",
                "https://www.facebook.com/ominidi.org/perma_link",
                "https://www.facebook.com/ominidi.org/photos/image",
                "https://www.facebook.com/ominidi.org/photos/full",
                "this is a message"
        );
        next = new URL("http://next");
        prev = new URL("http://prev");
    }

    @Test
    public void isAFeedOfPostsWithANextAndPrevUrl() {
        List<Post> posts = Arrays.asList(post);
        Feed<Post> feed = new Feed<>(posts, next, prev);

        assertEquals(Integer.valueOf(posts.size()), Integer.valueOf(feed.getSize()));
        assertEquals(next, feed.getNextUrl());
        assertEquals(prev, feed.getPrevUrl());
    }

    @Test
    public void itCanBeIterated() {
        List<Post> posts = Arrays.asList(post, post, post);
        Feed<Post> feed = new Feed<>(posts, next, prev);

        for (Post p : feed) {
            assertEquals(post.getId(), p.getId());
        }
    }
}
