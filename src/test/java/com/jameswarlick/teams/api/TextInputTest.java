package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.input.TextInput;
import com.jameswarlick.teams.api.util.JsonTest;

public class TextInputTest extends JsonTest<TextInput> {

    public TextInputTest() {
        super(TextInput.class, buildMock());
    }

    private static TextInput buildMock() {
        return new TextInput("comment", true, "Input's title property");
    }
}