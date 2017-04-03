package org.ominidi.domain.model;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import lombok.Getter;

@Getter
public class Feed<Post> implements Iterable<Post> {
    private final List<Post> posts;
    private final String nextUrl;
    private final String prevUrl;
    private final Integer size;

    public Feed(List<Post> posts, String nextUrl, String prevUrl) {
        this.posts = posts;
        this.size = posts.size();
        this.nextUrl = nextUrl;
        this.prevUrl = prevUrl;
    }

    @Override
    public Iterator<Post> iterator() {
        return posts.iterator();
    }

    public Integer size() {
        return posts.size();
    }
}