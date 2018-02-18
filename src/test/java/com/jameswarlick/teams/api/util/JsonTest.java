package com.jameswarlick.teams.api.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import com.google.common.base.CaseFormat;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

/**
 * Helper class used to test JSON serialization, comparing the provided mock
 * object against the JSON contained in the "filename" property.
 * <p>
 * Modified from original version to "guess" the json filename.
 *
 * @param <T> the generic type
 * @author james
 */
public abstract class JsonTest<T> {

    private static final Logger log = LoggerFactory.getLogger(JsonTest.class);

    private final Class<T> type;
    private final String path;
    private final T mock;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.findAndRegisterModules();
    }

    /**
     * Instantiates a new json test
     *
     * @param type Class that we're serializing to/from
     * @param mock POJO equivalent of the JSON file.
     */
    protected JsonTest(Class<T> type, T mock) {
        this(type, null, mock);
    }

    /**
     * Instantiates a new json test
     *
     * @param type     Class that we're serializing to/from
     * @param filename File in the fixtures folder, minus ".json"
     * @param mock     POJO equivalent of the JSON file.
     */
    protected JsonTest(Class<T> type, String filename, T mock) {
        this.type = type;
        this.path = determinePath(type, filename);
        this.mock = mock;
        MAPPER.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
    }

    /**
     * Let's be a bit more helpful with the filename.
     *
     * @param filename If provided, just use that (add .json)
     * @return A path to try.
     */
    private String determinePath(Class<T> type, String filename) {

        if (null != filename) {
            return "src/test/resources/fixtures/" + filename + ".json";
        } else {
            return "src/test/resources/fixtures/" + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, type.getSimpleName()) + ".json";
        }

    }

    /**
     * Flatten the POJO and compare it to the contents of the JSON file.
     *
     * @throws Exception Typically an IOException
     */
    @Test
    public void producesTheExpectedJSON() throws Exception {
        log.debug(MAPPER.writeValueAsString(this.mock));
        String mockToString = MAPPER.writeValueAsString(this.mock);

        T objectFromFile = MAPPER.readValue(new File(this.path), this.type);
        String objectFromFileBackToString = MAPPER.writeValueAsString(objectFromFile);

        assertThat(mockToString).isEqualTo(objectFromFileBackToString);
    }

    /**
     * Deserialize the JSON file and compare to the provided mock object.
     *
     * @throws Exception Typically an IOException
     */
    @Test
    public void consumesTheExpectedJSON() throws Exception {
        T objectFromFile = MAPPER.readValue(new File(this.path), this.type);
        assertThat(objectFromFile).isEqualTo(mock);
    }

    /**
     * Deserialize the JSON file and return the object.
     *
     * @param <T>      The class of the deserialized file/JSON
     * @param filename File in the fixtures folder, minus ".json"
     * @param klass    The class of the deserialized file/JSON
     * @return Deserialized object, ready to go.
     */
    public static <T> T getObject(String filename, Class<T> klass) {
        try {
            return MAPPER.readValue(new File("fixtures/" + filename + ".json"), klass);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

}