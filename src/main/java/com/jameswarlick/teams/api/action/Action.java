package com.jameswarlick.teams.api.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ActionCard.class, name = "ActionCard"),
        @JsonSubTypes.Type(value = HttpPost.class, name = "HttpPOST"),
        @JsonSubTypes.Type(value = OpenUri.class, name = "OpenUri")
})
public interface Action {
    String getName();
}
