package com.jameswarlick.teams.api;

import java.util.Objects;

/**
 * Defines a value in a multichoice input.
 */
public class Choice {

    private String display;
    private String value;


    public Choice() {}

    public Choice(String display, String value) {
        this.display = display;
        this.value = value;
    }


    public String getDisplay() {
        return this.display;
    }

    public String getValue() {
        return this.value;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Choice choice = (Choice) o;
        return Objects.equals(display, choice.display) &&
                Objects.equals(value, choice.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(display, value);
    }

    public String toString() {
        return "Choice{display=" + this.getDisplay() + ", value=" + this.getValue() + "}";
    }
}
