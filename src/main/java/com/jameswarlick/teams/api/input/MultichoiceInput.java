package com.jameswarlick.teams.api.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.jameswarlick.teams.api.Choice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonTypeName("MultichoiceInput")
public class MultichoiceInput implements Input {
    private String id;

    @JsonProperty("isRequired")
    private Boolean required;
    private String title;
    private String value;
    private List<Choice> choices;
    @JsonProperty("isMultiSelect")
    private Boolean multiSelect;
    private Style style;

    public MultichoiceInput() {
    }

    public MultichoiceInput(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public MultichoiceInput(String id, Boolean required, String title, String value, List<Choice> choices, Boolean multiSelect, Style style) {
        this.id = id;
        this.required = required;
        this.title = title;
        this.value = value;
        this.choices = choices;
        this.multiSelect = multiSelect;
        this.style = style;
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

    public List<Choice> getChoices() {
        return this.choices;
    }

    public Boolean getMultiSelect() {
        return this.multiSelect;
    }

    public Style getStyle() {
        return this.style;
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

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public void addChoice(Choice... choices) {
        if (null == this.choices) this.choices = new ArrayList<>();
        for (Choice choice : choices) this.choices.add(choice);
    }

    public void setMultiSelect(Boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    public void setStyle(Style style) {
        this.style = style;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultichoiceInput that = (MultichoiceInput) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(required, that.required) &&
                Objects.equals(title, that.title) &&
                Objects.equals(value, that.value) &&
                Objects.equals(choices, that.choices) &&
                Objects.equals(multiSelect, that.multiSelect) &&
                style == that.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, required, title, value, choices, multiSelect, style);
    }

    public String toString() {
        return "MultichoiceInput(id=" + this.getId() + ", required=" + this.isRequired() + ", title=" + this.getTitle() + ", value=" + this.getValue() + ", choices=" + this.getChoices() + ", multiSelect=" + this.getMultiSelect() + ", style=" + this.getStyle() + ")";
    }


    // Builder (delombok'd from lombok.Builder)
    public static MultichoiceInputBuilder builder() {
        return new MultichoiceInputBuilder();
    }

    public static class MultichoiceInputBuilder {
        private String id;
        private Boolean required;
        private String title;
        private String value;
        private List<Choice> choices;
        private Boolean multiSelect;
        private Style style;

        MultichoiceInputBuilder() {
        }

        public MultichoiceInputBuilder id(String id) {
            this.id = id;
            return this;
        }

        public MultichoiceInputBuilder required(Boolean required) {
            this.required = required;
            return this;
        }

        public MultichoiceInputBuilder title(String title) {
            this.title = title;
            return this;
        }

        public MultichoiceInputBuilder value(String value) {
            this.value = value;
            return this;
        }

        public MultichoiceInputBuilder choices(List<Choice> choices) {
            this.choices = choices;
            return this;
        }

        public MultichoiceInputBuilder addChoice(Choice... choices) {
            if (null == this.choices) this.choices = new ArrayList<>();
            for (Choice choice : choices) this.choices.add(choice);
            return this;
        }

        public MultichoiceInputBuilder multiSelect(Boolean multiSelect) {
            this.multiSelect = multiSelect;
            return this;
        }

        public MultichoiceInputBuilder style(Style style) {
            this.style = style;
            return this;
        }

        public MultichoiceInput build() {
            return new MultichoiceInput(id, required, title, value, choices, multiSelect, style);
        }

        public String toString() {
            return "MultichoiceInput.MultichoiceInputBuilder(id=" + this.id + ", required=" + this.required + ", title=" + this.title + ", value=" + this.value + ", choices=" + this.choices + ", multiSelect=" + this.multiSelect + ", style=" + this.style + ")";
        }
    }
}
