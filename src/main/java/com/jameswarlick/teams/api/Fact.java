package com.jameswarlick.teams.api;

import java.util.Objects;

/**
 * A fact is just a name and a value.  Sections may have a series of facts,
 * which provide a neat way of displaying information.
 *
 * @author james
 */
public class Fact {

    private String name;
    private String value;

    public Fact() {
    }

    public Fact(String name, String value) {
        this.name = name;
        this.value = value;
    }


    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fact fact = (Fact) o;
        return Objects.equals(name, fact.name) &&
                Objects.equals(value, fact.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "Fact{name='" + name + "', value='" + value + "'}";
    }
}
