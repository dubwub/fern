/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.oauthClientCredentials;

import com.seed.oauthClientCredentials.core.ClientOptions;
import com.seed.oauthClientCredentials.core.Environment;

public final class SeedOauthClientCredentialsClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String token = null;

    private Environment environment;

    /**
     * Sets token
     */
    public SeedOauthClientCredentialsClientBuilder token(String token) {
        this.token = token;
        return this;
    }

    public SeedOauthClientCredentialsClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public SeedOauthClientCredentialsClient build() {
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + this.token);
        clientOptionsBuilder.environment(this.environment);
        return new SeedOauthClientCredentialsClient(clientOptionsBuilder.build());
    }
}
