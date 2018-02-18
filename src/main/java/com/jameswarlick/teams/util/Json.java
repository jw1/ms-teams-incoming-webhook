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
     * Return the underlying Jackson object mapper class.
     *
     * @return Jackson object mapper (static instance)
     */
    public static ObjectMapper getObjectMapper() {
        return JSON;
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

    /**
     * Deserialize the JSON content as a given object.
     *
     * @param <T>   The class the JSON is being converted to.
     * @param json  Actual String to deserialize.
     * @param klass The class the JSON is being converted to.
     * @return Instance of the class represented by the JSON
     */
    public static <T> T fromJson(final String json, final Class<T> klass) {
        try {
            return JSON.readValue(json, klass);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
