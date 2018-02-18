package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.util.JsonTest;

public class ChoiceTest extends JsonTest<Choice> {

    public ChoiceTest() {
        super(Choice.class, buildMock());
    }

    private static Choice buildMock() {
        return new Choice("List 1", "l1");
    }
}
