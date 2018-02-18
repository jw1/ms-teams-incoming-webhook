package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.input.Choice;
import com.jameswarlick.teams.api.input.MultichoiceInput;
import com.jameswarlick.teams.api.util.JsonTest;

public class MultichoiceInputMultiTest extends JsonTest<MultichoiceInput> {

    public MultichoiceInputMultiTest() {
        super(MultichoiceInput.class, "multichoice-input-multi", buildMock());
    }

    private static MultichoiceInput buildMock() {
        MultichoiceInput mock = new MultichoiceInput("list", "Pick an option");
        mock.setMultiSelect(true);
        mock.addChoice(
                new Choice("Choice 1", "1"),
                new Choice("Choice 2", "2"),
                new Choice("Choice 3", "3"));
        return mock;
    }
}