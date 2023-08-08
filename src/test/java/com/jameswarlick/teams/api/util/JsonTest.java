package com.jameswarlick.teams.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

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
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.findAndRegisterModules();
    }

    private final Class<T> type;
    private final String path;
    private final T mock;

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
}