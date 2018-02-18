package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.action.ActionCard;
import com.jameswarlick.teams.api.action.HttpPost;
import com.jameswarlick.teams.api.action.OpenUri;
import com.jameswarlick.teams.api.input.DateInput;
import com.jameswarlick.teams.api.input.MultichoiceInput;
import com.jameswarlick.teams.api.input.TextInput;
import com.jameswarlick.teams.api.util.JsonTest;

import java.net.URISyntaxException;

public class SampleCardTest extends JsonTest<Card> {

    public SampleCardTest() throws URISyntaxException {
        super(Card.class, "sample-card", buildMock());
    }

    public static Card buildMock() throws URISyntaxException {

        Card mock = Card.builder()
                .summary("Card \"Test card\"")
                .themeColor("0078D7")
                .title("Card created: \"Name of card\"")
                .addSection(
                        Section.builder()
                                .activityTitle("David Claux")
                                .activitySubtitle("9/13/2016, 3:34pm")
                                .activityImage("https://connectorsdemo.azurewebsites.net/images/MSC12_Oscar_002.jpg")
                                .text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")
                                .addFact("Board:", "Name of board")
                                .addFact("List:", "Name of list")
                                .addFact("Assigned to:", "(none)")
                                .addFact("Due date:", "(none)")
                                .build())
                .addPotentialAction(
                        ActionCard.builder()
                                .name("Set due date")
                                .addInput(new DateInput("dueDate", "Select a date"))
                                .addAction(new HttpPost("OK", "https://example.com"))
                                .build())
                .addPotentialAction(
                        ActionCard.builder()
                                .name("Move")
                                .addInput(
                                        MultichoiceInput.builder()
                                                .id("move")
                                                .title("Pick a list")
                                                .addChoice(new Choice("List 1", "l1"))
                                                .addChoice(new Choice("List 2", "l2"))
                                                .build())
                                .addAction(new HttpPost("OK", "https://example.com"))
                                .build())
                .addPotentialAction(
                        ActionCard.builder()
                                .name("Add a comment")
                                .addInput(new TextInput("comment", true, "Enter your comment"))
                                .addAction(new HttpPost("OK", "https://example.com"))
                                .build())
                .addPotentialAction(new OpenUri("View in Trello", "https://example.com"))
                .build();

        return mock;
    }
}