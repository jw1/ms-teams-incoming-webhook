package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.util.JsonTest;

public class ImageTest extends JsonTest<Image> {

    public ImageTest() {
        super(Image.class, buildMock());
    }

    private static Image buildMock() {
        return new Image("http://via.placeholder.com/350x150", "Title");
    }
}
