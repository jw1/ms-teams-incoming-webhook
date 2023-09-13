package com.jameswarlick.teams;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jameswarlick.teams.api.Card;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Reference implementation of an HTTP client for delivering Cards to Teams.
 * Uses the Jersey HTTP client.
 *
 * @author james
 */
public class TeamsClient {

    private static final ObjectMapper JSON = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final String url;

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
                .post(ClientResponse.class, toJson(payload));

        System.out.println("Request:  " + toJson(payload));
        String output = response.getEntity(String.class);
        System.out.println("Response:" + output);

        return response.getStatus() == 200;
    }

    /**
     * Serialize the given object as JSON content.
     *
     * @param pojo The Java object to serialize.
     * @return Serialized JSON string.
     */
    private static String toJson(final Object pojo) {
        try {
            return JSON.writeValueAsString(pojo);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
