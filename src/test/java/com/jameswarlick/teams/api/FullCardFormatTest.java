package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.action.ActionCard;
import com.jameswarlick.teams.api.action.HttpPost;
import com.jameswarlick.teams.api.action.OpenUri;
import com.jameswarlick.teams.api.input.Choice;
import com.jameswarlick.teams.api.input.DateInput;
import com.jameswarlick.teams.api.input.MultichoiceInput;
import com.jameswarlick.teams.api.input.TextInput;
import com.jameswarlick.teams.api.util.JsonTest;

import java.net.URISyntaxException;

/**
 * From https://messagecardplayground.azurewebsites.net/
 * <p>
 * Build the "full card format" example with the Java API, make sure it matches
 * the sample.
 *
 * @author james
 */
public class FullCardFormatTest extends JsonTest<Card> {

    public FullCardFormatTest() {
        super(Card.class, "full-card-format", buildMock());
    }

    public static Card buildMock() {

        Card mock = Card.builder()
                .summary("This is the summary property")
                .themeColor("E81123")
                .title("This is the **card's title** property")
                .text("This is the **card's text** property. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .addSection(
                        Section.builder()
                                .title("This is the **section's title** property")
                                .activityImage("http://connectorsdemo.azurewebsites.net/images/MSC12_Oscar_002.jpg")
                                .activityTitle("This is the section's **activityTitle** property")
                                .activitySubtitle("This is the section's **activitySubtitle** property")
                                .activityText("This is the section's **activityText** property.")
                                .heroImage(new Image("http://connectorsdemo.azurewebsites.net/images/WIN12_Scene_01.jpg", "This is the image's alternate text"))
                                .text("This is the section's text property. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                                .addFact("This is a fact name", "This is a fact value")
                                .addFact("This is a fact name", "This is a fact value")
                                .addFact("This is a fact name", "This is a fact value")
                                .addImage(new Image("http://connectorsdemo.azurewebsites.net/images/MicrosoftSurface_024_Cafe_OH-06315_VS_R1c.jpg", "This is the image's alternate text"))
                                .addImage(new Image("http://connectorsdemo.azurewebsites.net/images/WIN12_Scene_01.jpg", "This is the image's alternate text"))
                                .addImage(new Image("http://connectorsdemo.azurewebsites.net/images/WIN12_Anthony_02.jpg", "This is the image's alternate text"))
                                .addPotentialAction(
                                        ActionCard.builder()
                                                .name("Comment")
                                                .addInput(new TextInput("comment", true, "Input's title property"))
                                                .addAction(new HttpPost("Save", "http://..."))
                                                .build())
                                .addPotentialAction(
                                        ActionCard.builder()
                                                .name("Due Date")
                                                .addInput(new DateInput("dueDate", "Input's title property"))
                                                .addAction(new HttpPost("Save", "http://..."))
                                                .build())
                                .addPotentialAction(new HttpPost("Action's name prop.", "http://..."))
                                .addPotentialAction(new OpenUri("Action's name prop", "http://..."))
                                .build())
                .addSection(
                        Section.builder()
                                .startGroup(true)
                                .title("This is the title of a **second section**")
                                .text("This second section is visually separated from the first one by setting its **startGroup** property to true.")
                                .build())
                .build();

        return mock;
    }
}