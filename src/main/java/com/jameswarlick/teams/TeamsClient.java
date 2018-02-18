package com.jameswarlick.teams;

import com.jameswarlick.teams.api.Card;
import com.jameswarlick.teams.util.Json;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Reference implementation of an HTTP client for delivering Cards to Teams.
 * Uses the Jersey HTTP client.
 *
 * @author james
 */
public class TeamsClient {

    private String url;

    /**
     * Webhooks in Teams are associated with a URL (and channel).
     *
     * @param url Points to a webhook on a channel
     */
    public TeamsClient(String url) {
        this.url = url;
    }

    /**
     * Send a message payload.
     *
     * @param payload The object to send... we'll flatten it to JSON
     * @return True if it worked, false if not.
     */
    public boolean sendMessage(Card payload) {

        ClientResponse response = Client
                .create()
                .resource(url)
                .accept("application/json")
                .post(ClientResponse.class, Json.asJson(payload));

        System.out.println("Request:  " + Json.asJson(payload));
        String output = response.getEntity(String.class);
        System.out.println("Response:" + output);

        return response.getStatus() == 200;
    }
}
