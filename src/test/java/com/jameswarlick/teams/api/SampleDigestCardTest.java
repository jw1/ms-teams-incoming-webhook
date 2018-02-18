package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.util.JsonTest;

public class SampleDigestCardTest extends JsonTest<Card> {

    public SampleDigestCardTest() {
        super(Card.class, "sample-digest-card", buildMock());
    }

    public static Card buildMock() {
        Card mock = new Card();
        mock.setThemeColor("0078D7");

        mock.addSection(
                new Section(
                        "**Elon Musk**",
                        "@elonmusk - 9/12/2016 at 5:33pm",
                        "https://pbs.twimg.com/profile_images/782474226020200448/zDo-gAo0.jpg",
                        "Climate change explained in comic book form by xkcd xkcd.com/1732"),
                new Section(
                        "**Mark Knopfler**",
                        "@MarkKnopfler - 9/12/2016 at 1:12pm",
                        "https://pbs.twimg.com/profile_images/378800000221985528/b2ebfafca6fd7b565fdf3bf4ccdb4dc9.jpeg",
                        "Mark Knopfler features on B.B King's all-star album of Blues greats, released on this day in 2005..."));
        return mock;
    }
}