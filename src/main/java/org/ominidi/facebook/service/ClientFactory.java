package org.ominidi.facebook.service;

import com.restfb.*;

public class ClientFactory {
    public static final FacebookClient create() {
        return new DefaultFacebookClient();
    }
}
