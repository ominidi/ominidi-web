package org.ominidi.facebook.service;

import com.restfb.FacebookClient;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClientFactoryTest {

    @Test
    public void shouldCreateAFacebookClient() {
        FacebookClient client = ClientFactory.create();
        assertNotNull(client);
    }
}
