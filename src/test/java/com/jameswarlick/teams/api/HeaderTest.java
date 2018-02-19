package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.action.Header;
import com.jameswarlick.teams.api.util.JsonTest;

public class HeaderTest extends JsonTest<Header> {

    public HeaderTest() {
        super(Header.class, buildMock());
    }

    private static Header buildMock() {
        return new Header("Name", "Value");
    }
}
