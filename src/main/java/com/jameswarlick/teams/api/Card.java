package com.jameswarlick.teams.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jameswarlick.teams.api.action.Action;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * This is the parent class of a Teams Message, and is what's delivered to MS Teams via Webhook.
 * Adapted from https://docs.microsoft.com/en-us/outlook/actionable-messages/card-reference
 *
 * @author james
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card {

    @JsonIgnore
    private String type = "MessageCard";
    @JsonIgnore
    private String context = "http://schema.org/extensions";
    private UUID correlationId;
    private String originator;
    private String summary;
    private String themeColor;
    private String title;
    private String text;
    private List<Section> sections;
    @JsonProperty("potentialAction")
    private List<Action> potentialActions;


    public Card() {
    }

    public Card(String summary, String themeColor, String title) {
        this.summary = summary;
        this.themeColor = themeColor;
        this.title = title;
    }

    public Card(String summary, String themeColor, String title, String text) {
        this.summary = summary;
        this.themeColor = themeColor;
        this.title = title;
        this.text = text;
    }

    public Card(String type, String context, UUID correlationId, String originator, String summary, String themeColor, String title, String text, List<Section> sections, List<Action> potentialActions) {
        this.type = type;
        this.context = context;
        this.correlationId = correlationId;
        this.originator = originator;
        this.summary = summary;
        this.themeColor = themeColor;
        this.title = title;
        this.text = text;
        this.sections = sections;
        this.potentialActions = potentialActions;
    }


    public String getType() {
        return this.type;
    }

    public String getContext() {
        return this.context;
    }

    public UUID getCorrelationId() {
        return this.correlationId;
    }

    public String getOriginator() {
        return this.originator;
    }

    public String getSummary() {
        return this.summary;
    }

    /**
     * Specifies a custom brand color for the card. The color will be displayed in a non-obtrusive manner.
     * <p>
     * Do use themeColor to brand cards to your color.
     * Don't use themeColor to indicate status.
     *
     * @return Hex code indicating color (e.g. 0078D7)
     */
    public String getThemeColor() {
        return this.themeColor;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public List<Action> getPotentialActions() {
        return this.potentialActions;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setCorrelationId(UUID correlationId) {
        this.correlationId = correlationId;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Specifies a custom brand color for the card. The color will be displayed in a non-obtrusive manner.
     * <p>
     * Do use themeColor to brand cards to your color.
     * Don't use themeColor to indicate status.
     *
     * @param themeColor Hex code indicating color (e.g. 0078D7)
     */
    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    /**
     * Specifies a custom brand color for the card. The color will be displayed in a non-obtrusive manner.
     * <p>
     * Do use themeColor to brand cards to your color.
     * Don't use themeColor to indicate status.
     *
     * @param themeColor java.awt.Color object indicating some color or something
     */
    public void setThemeColor(Color themeColor) {
        this.themeColor = String.format("#%02x%02x%02x", themeColor.getRed(), themeColor.getGreen(), themeColor.getBlue()).toUpperCase().substring(1);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void setPotentialActions(List<Action> potentialActions) {
        this.potentialActions = potentialActions;
    }

    public void addPotentialAction(Action... actions) {
        if (null == this.potentialActions) this.potentialActions = new ArrayList<>();
        for (Action action : actions) this.potentialActions.add(action);
    }

    public void addSection(Section... sections) {
        if (null == this.sections) this.sections = new ArrayList<>();
        for (Section section : sections) this.sections.add(section);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(type, card.type) &&
                Objects.equals(context, card.context) &&
                Objects.equals(correlationId, card.correlationId) &&
                Objects.equals(originator, card.originator) &&
                Objects.equals(summary, card.summary) &&
                Objects.equals(themeColor, card.themeColor) &&
                Objects.equals(title, card.title) &&
                Objects.equals(text, card.text) &&
                Objects.equals(sections, card.sections) &&
                Objects.equals(potentialActions, card.potentialActions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, context, correlationId, originator, summary, themeColor, title, text, sections, potentialActions);
    }

    public String toString() {
        return "Card(type=" + this.getType() + ", context=" + this.getContext() + ", correlationId=" + this.getCorrelationId() + ", originator=" + this.getOriginator() + ", summary=" + this.getSummary() + ", themeColor=" + this.getThemeColor() + ", title=" + this.getTitle() + ", text=" + this.getText() + ", sections=" + this.getSections() + ", potentialActions=" + this.getPotentialActions() + ")";
    }


    // Builder (delombok'd from lombok.Builder)
    public static CardBuilder builder() {
        return new CardBuilder();
    }

    public static class CardBuilder {
        private String type = "MessageCard";
        private String context = "http://schema.org/extensions";
        private UUID correlationId;
        private String originator;
        private String summary;
        private String themeColor;
        private String title;
        private String text;
        private List<Section> sections;
        private List<Action> potentialActions;

        CardBuilder() {
        }

        public CardBuilder type(String type) {
            this.type = type;
            return this;
        }

        public CardBuilder context(String context) {
            this.context = context;
            return this;
        }

        public CardBuilder correlationId(UUID correlationId) {
            this.correlationId = correlationId;
            return this;
        }

        public CardBuilder originator(String originator) {
            this.originator = originator;
            return this;
        }

        public CardBuilder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public CardBuilder themeColor(String themeColor) {
            this.themeColor = themeColor;
            return this;
        }

        public CardBuilder themeColor(Color themeColor) {
            this.themeColor = String.format("#%02x%02x%02x", themeColor.getRed(), themeColor.getGreen(), themeColor.getBlue()).toUpperCase().substring(1);
            return this;
        }

        public CardBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CardBuilder text(String text) {
            this.text = text;
            return this;
        }

        public CardBuilder sections(List<Section> sections) {
            this.sections = sections;
            return this;
        }

        public CardBuilder potentialActions(List<Action> potentialActions) {
            this.potentialActions = potentialActions;
            return this;
        }

        public CardBuilder addPotentialAction(Action... actions) {
            if (null == this.potentialActions) this.potentialActions = new ArrayList<>();
            for (Action action : actions) this.potentialActions.add(action);
            return this;
        }

        public CardBuilder addSection(Section... sections) {
            if (null == this.sections) this.sections = new ArrayList<>();
            for (Section section : sections) this.sections.add(section);
            return this;
        }

        public Card build() {
            return new Card(type, context, correlationId, originator, summary, themeColor, title, text, sections, potentialActions);
        }

        public String toString() {
            return "Card.CardBuilder(type=" + this.type + ", context=" + this.context + ", correlationId=" + this.correlationId + ", originator=" + this.originator + ", summary=" + this.summary + ", themeColor=" + this.themeColor + ", title=" + this.title + ", text=" + this.text + ", sections=" + this.sections + ", potentialActions=" + this.potentialActions + ")";
        }
    }
}
