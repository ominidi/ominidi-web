package org.ominidi.domain.model;

import lombok.Getter;

@Getter
public class Post {
    private final String id;
    private final Long objectId;
    private final String createdTime;
    private final String type;
    private final String link;
    private final String permalinkUrl;
    private final String picture;
    private final String fullPicture;
    private final String message;

    public Post(
            String id,
            Long objectId,
            String createdTime,
            String type,
            String link,
            String permalinkUrl,
            String picture,
            String fullPicture,
            String message
    ) {
        this.id = id;
        this.objectId = objectId;
        this.createdTime = createdTime;
        this.type = type;
        this.link = link;
        this.permalinkUrl = permalinkUrl;
        this.picture = picture;
        this.fullPicture = fullPicture;
        this.message = message;
    }
}
