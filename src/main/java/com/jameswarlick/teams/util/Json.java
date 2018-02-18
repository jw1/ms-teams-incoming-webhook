package com.jameswarlick.teams.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class which enables callers to serialize and deserialize POJOs to
 * JSON representations, and vice-versa.
 *
 * @author james
 */
public class Json {

    private static final ObjectMapper JSON = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private Json() {
    }

    /**
     * Serialize the given object as JSON content.
     *
     * @param pojo The Java object to serialize.
     * @return Serialized JSON string.
     */
    public static String asJson(final Object pojo) {
        try {
            return JSON.writeValueAsString(pojo);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
