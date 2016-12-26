package org.ominidi.domain.model;

import java.util.Iterator;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;

@Getter
public class Feed<Post> implements Iterable<Post> {

    @Getter(AccessLevel.NONE)
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
        return null;
    }

    public Integer size() {
        return null;
    }
}