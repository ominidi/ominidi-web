package org.ominidi.facebook.repository;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
import org.ominidi.facebook.config.Page;

// 221685698257476/feed?fields=created_time,type,message,object_id,link,name,picture,permalink_url,full_picture,id

public class Feed implements PostRepository {
    protected FacebookClient client;

    public Feed(FacebookClient client) {
        this.client = client;
    }

    @Override
    public Connection<Post> getConnection() {
        return client.fetchConnection(
                Page.PAGE_ID + Page.FEED_URL, Post.class, Parameter.with("fields", Field.getForFeed())
        );
    }

    @Override
    public com.restfb.types.Post getObject(Long id) {
        return client.fetchObject(
                id.toString(), Post.class, Parameter.with("fields", Field.getForPost())
        );
    }
}

