package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.action.OpenUri;
import com.jameswarlick.teams.api.util.JsonTest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class OpenUriTest extends JsonTest<OpenUri> {

    public OpenUriTest() throws URISyntaxException {
        super(OpenUri.class, buildMock());
    }

    private static OpenUri buildMock() throws URISyntaxException {
        OpenUri mock = new OpenUri();
        mock.setName("View in Trello");
        mock.addTarget(
                new Target("https://yammer.com/something/123"),
                new Target(OperatingSystem.IOS, "yammer://u/123"),
                new Target(OperatingSystem.ANDROID, "yammer://u/123"),
                new Target(OperatingSystem.WINDOWS, "yammer://u/123"));
        return mock;
    }
}