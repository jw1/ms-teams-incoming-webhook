package com.jameswarlick.teams.api;

import java.util.Objects;

/**
 * Defines a destination, given a particular web browser or operating system.
 */
public class Target {

    private OperatingSystem os = OperatingSystem.DEFAULT;
    private String uri;


    public Target() {
    }

    public Target(String uri) {
        this.uri = uri;
    }

    public Target(OperatingSystem os, String uri) {
        this.os = os;
        this.uri = uri;
    }

    public OperatingSystem getOs() {
        return this.os;
    }

    public String getUri() {
        return this.uri;
    }

    public void setOs(OperatingSystem os) {
        this.os = os;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Target target = (Target) o;
        return os == target.os && Objects.equals(uri, target.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(os, uri);
    }

    @Override
    public String toString() {
        return "Target{" + "os=" + os + ", uri=" + uri + '}';
    }
}
