package com.jameswarlick.teams.api.action;

import java.util.Objects;

/**
 * Represents and HTTP header when making an HttpPOST action / call.
 *
 * @author james
 */
public class Header {

    private String name;
    private String value;

    public Header() {
    }

    public Header(String name, String value) {
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
        Header header = (Header) o;
        return Objects.equals(name, header.name) &&
                Objects.equals(value, header.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "Header{name='" + name + "', value='" + value + "'}";
    }
}
