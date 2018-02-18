package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.action.OperatingSystem;
import com.jameswarlick.teams.api.action.Target;
import com.jameswarlick.teams.api.util.JsonTest;

import java.net.URISyntaxException;

public class TargetTest extends JsonTest<Target> {

    public TargetTest() throws URISyntaxException {
        super(Target.class, buildMock());
    }

    private static Target buildMock() throws URISyntaxException {
        return new Target(OperatingSystem.WINDOWS, "yammer://u/123");
    }
}
