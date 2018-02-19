package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.input.Choice;
import com.jameswarlick.teams.api.input.MultichoiceInput;
import com.jameswarlick.teams.api.util.JsonTest;

public class MultichoiceInputCompactTest extends JsonTest<MultichoiceInput> {

    public MultichoiceInputCompactTest() {
        super(MultichoiceInput.class, "multichoice-input-compact", buildMock());
    }

    private static MultichoiceInput buildMock() {
        MultichoiceInput mock = new MultichoiceInput("list", "Pick an option");
        mock.addChoice(new Choice("Choice 1", "1"));
        mock.addChoice(new Choice("Choice 2", "2"));
        mock.addChoice(new Choice("Choice 3", "3"));
        return mock;
    }
}