package com.jameswarlick.teams.api.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

/**
 * From https://docs.microsoft.com/en-us/outlook/actionable-messages/card-reference#textinput
 * <p>
 * Use this input type when you need users to provide free text, such as the
 * response to a survey question.  The input from the user is typically
 * attached to an HttpPOST component.
 *
 * @author james
 */
@JsonTypeName("TextInput")
public class TextInput implements Input {

    private String id;
    @JsonProperty("isRequired")
    private Boolean required;
    private String title;
    private String value;
    @JsonProperty("isMultiline")
    private Boolean multiline = true;
    private Integer maxLength;

    public TextInput() {
    }

    public TextInput(String title) {
        this.title = title;
    }

    public TextInput(String id, boolean multiline, String title) {
        this.id = id;
        this.multiline = multiline;
        this.title = title;
    }

    public TextInput(String id, boolean multiline, String title, int maxLength) {
        this.id = id;
        this.multiline = multiline;
        this.title = title;
        this.maxLength = maxLength;
    }


    public String getId() {
        return this.id;
    }

    public Boolean isRequired() {
        return this.required;
    }

    public String getTitle() {
        return this.title;
    }

    public String getValue() {
        return this.value;
    }

    public Boolean getMultiline() {
        return this.multiline;
    }

    public Integer getMaxLength() {
        return this.maxLength;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setMultiline(Boolean multiline) {
        this.multiline = multiline;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextInput textInput = (TextInput) o;
        return Objects.equals(id, textInput.id) &&
                Objects.equals(required, textInput.required) &&
                Objects.equals(title, textInput.title) &&
                Objects.equals(value, textInput.value) &&
                Objects.equals(multiline, textInput.multiline) &&
                Objects.equals(maxLength, textInput.maxLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, required, title, value, multiline, maxLength);
    }

    public String toString() {
        return "TextInput(id=" + this.getId() + ", required=" + this.isRequired() + ", title=" + this.getTitle() + ", value=" + this.getValue() + ", multiline=" + this.getMultiline() + ", maxLength=" + this.getMaxLength() + ")";
    }
}
