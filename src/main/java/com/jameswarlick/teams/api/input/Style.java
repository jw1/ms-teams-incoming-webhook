package com.jameswarlick.teams.api.input;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From <a href="https://docs.microsoft.com/en-us/outlook/actionable-messages/card-reference#openuri-action">...</a>
 * <p>
 * When isMultiSelect is false, setting the style property to expanded will
 * instruct the host application to try and display all choices on the screen,
 * typically using a set of radio buttons.
 *
 * @author james
 */
public enum Style {

    @JsonProperty("normal")
    NORMAL,
    @JsonProperty("expanded")
    EXPANDED;
}
