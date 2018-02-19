package com.jameswarlick.teams.api.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

/**
 * From https://docs.microsoft.com/en-us/outlook/actionable-messages/card-reference#textinput
 * <p>
 * Use this input type when you need users to provide a date value.  The input
 * from the user is typically attached to an HttpPOST component.
 *
 * @author james
 */
@JsonTypeName("DateInput")
public class DateInput implements Input {

    private String id;
    @JsonProperty("isRequired")
    private Boolean required;
    private String title;
    private String value;

    public DateInput() {
    }

    public DateInput(String id, String title) {
        this.id = id;
        this.title = title;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateInput dateInput = (DateInput) o;
        return Objects.equals(id, dateInput.id) &&
                Objects.equals(required, dateInput.required) &&
                Objects.equals(title, dateInput.title) &&
                Objects.equals(value, dateInput.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, required, title, value);
    }

    public String toString() {
        return "DateInput(id=" + this.getId() + ", required=" + this.isRequired() + ", title=" + this.getTitle() + ", value=" + this.getValue() + ")";
    }
}
