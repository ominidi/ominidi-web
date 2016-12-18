package org.ominidi.facebook.service;

import com.restfb.FacebookClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ominidi.facebook.configuration.FacebookConfig;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientFactoryTest {

    @Mock
    private FacebookConfig config;

    @Test
    public void shouldCreateAFacebookClient() throws IOException {
        ClientFactory factory = new ClientFactory(config);

        FacebookClient client = factory.getClient();
        assertNotNull(client);
    }
}
