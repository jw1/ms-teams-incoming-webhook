package com.jameswarlick.teams.api.action;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.Lists;
import com.jameswarlick.teams.api.Target;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonTypeName("OpenUri")
public class OpenUri implements Action {

    private String name;
    private List<Target> targets;

    public OpenUri() {
    }

    public OpenUri(String name, String defaultTarget) throws URISyntaxException {
        this.name = name;
        this.targets = Lists.newArrayList(new Target(defaultTarget));
    }

    public OpenUri(String name, List<Target> targets) {
        this.name = name;
        this.targets = targets;
    }


    public String getName() {
        return this.name;
    }

    public List<Target> getTargets() {
        return this.targets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public void addTarget(Target... targets) {
        if (null == this.targets) this.targets = new ArrayList<>();
        for (Target target : targets) this.targets.add(target);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenUri openUri = (OpenUri) o;
        return Objects.equals(name, openUri.name) &&
                Objects.equals(targets, openUri.targets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, targets);
    }

    public String toString() {
        return "OpenUri(name=" + this.getName() + ", targets=" + this.getTargets() + ")";
    }
}
