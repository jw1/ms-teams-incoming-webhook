package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.util.JsonTest;

import java.net.URISyntaxException;

public class SectionTest extends JsonTest<Section> {

    public SectionTest() throws URISyntaxException {
        super(Section.class, buildMock());
    }

    public static Section buildMock() throws URISyntaxException {
        Section mock = new Section(
                "David Claux",
                "9/13/2016, 3:34pm",
                "https://connectorsdemo.azurewebsites.net/images/MSC12_Oscar_002.jpg");
        mock.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        mock.addFact(
                new Fact("Board:", "Name of board"),
                new Fact("List:", "Name of list"),
                new Fact("Assigned to:", "(none)"),
                new Fact("Due date:", "(none)"));
        return mock;
    }
}