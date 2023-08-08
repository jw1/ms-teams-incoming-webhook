package com.jameswarlick.teams.api.input;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Common fields to all Input components.
 *
 * @author james
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DateInput.class, name = "DateInput"),
        @JsonSubTypes.Type(value = MultichoiceInput.class, name = "MultichoiceInput"),
        @JsonSubTypes.Type(value = TextInput.class, name = "TextInput")
})
public interface Input {
    String getId();
    Boolean isRequired();
    String getTitle();
    String getValue();
}
