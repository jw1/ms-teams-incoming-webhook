package com.jameswarlick.teams.api;

import com.jameswarlick.teams.api.action.Action;
import com.jameswarlick.teams.api.action.ActionCard;
import com.jameswarlick.teams.api.action.HttpPost;
import com.jameswarlick.teams.api.input.Input;
import com.jameswarlick.teams.api.input.TextInput;
import com.jameswarlick.teams.api.util.JsonTest;

import java.util.ArrayList;
import java.util.List;

public class ActionCardTest extends JsonTest<ActionCard> {

    public ActionCardTest() {
        super(ActionCard.class, buildMock());
    }

    private static ActionCard buildMock() {
        ActionCard mock = new ActionCard();
        mock.setName("Comment");

        List<Input> inputs = new ArrayList<Input>();
        inputs.add(new TextInput("comment", true, "Input's title property"));
        mock.setInputs(inputs);

        List<Action> actions = new ArrayList<Action>();
        actions.add(new HttpPost("Action's name prop.", "https://yammer.com/comment?postId=123", "comment={{comment.value}}"));
        mock.setActions(actions);

        return mock;
    }
}