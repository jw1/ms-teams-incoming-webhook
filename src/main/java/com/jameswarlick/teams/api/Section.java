package com.jameswarlick.teams.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jameswarlick.teams.api.action.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A Card object has some title information, and then contains zero or more
 * sections, where the bulk of the content of the card resides.
 *
 * @author james
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Section {

    private String title;
    private Boolean startGroup;

    private String activityTitle;
    private String activitySubtitle;
    private String activityImage;
    private String activityText;

    private Image heroImage;

    private String text;
    private List<Fact> facts;

    private Image images;
    private List<Action> potentialActions;

    public Section() {
    }

    public Section(String activityTitle, String activitySubtitle, String activityImage) {
        this.activityTitle = activityTitle;
        this.activitySubtitle = activitySubtitle;
        this.activityImage = activityImage;
    }

    public Section(String activityTitle, String activitySubtitle, String activityImage, String activityText) {
        this.activityTitle = activityTitle;
        this.activitySubtitle = activitySubtitle;
        this.activityImage = activityImage;
        this.activityText = activityText;
    }

    public Section(String title, Boolean startGroup, String activityTitle, String activitySubtitle, String activityImage, String activityText, Image heroImage, String text, List<Fact> facts, Image images, List<Action> potentialActions) {
        this.title = title;
        this.startGroup = startGroup;
        this.activityTitle = activityTitle;
        this.activitySubtitle = activitySubtitle;
        this.activityImage = activityImage;
        this.activityText = activityText;
        this.heroImage = heroImage;
        this.text = text;
        this.facts = facts;
        this.images = images;
        this.potentialActions = potentialActions;
    }


    public String getTitle() {
        return this.title;
    }

    public Boolean getStartGroup() {
        return this.startGroup;
    }

    public String getActivityTitle() {
        return this.activityTitle;
    }

    public String getActivitySubtitle() {
        return this.activitySubtitle;
    }

    public String getActivityImage() {
        return this.activityImage;
    }

    public String getActivityText() {
        return this.activityText;
    }

    public Image getHeroImage() {
        return this.heroImage;
    }

    public String getText() {
        return this.text;
    }

    public List<Fact> getFacts() {
        return this.facts;
    }

    public Image getImages() {
        return this.images;
    }

    public List<Action> getPotentialActions() {
        return this.potentialActions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartGroup(Boolean startGroup) {
        this.startGroup = startGroup;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public void setActivitySubtitle(String activitySubtitle) {
        this.activitySubtitle = activitySubtitle;
    }

    public void setActivityImage(String activityImage) {
        this.activityImage = activityImage;
    }

    public void setActivityText(String activityText) {
        this.activityText = activityText;
    }

    public void setHeroImage(Image heroImage) {
        this.heroImage = heroImage;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFacts(List<Fact> facts) {
        this.facts = facts;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    public void setPotentialActions(List<Action> potentialActions) {
        this.potentialActions = potentialActions;
    }

    public void addPotentialAction(Action... actions) {
        if (null == this.potentialActions) this.potentialActions = new ArrayList<>();
        for (Action action : actions) this.potentialActions.add(action);
    }

    public void addFact(String name, String value) {
        addFact(new Fact(name, value));
    }

    public void addFact(Fact... facts) {
        if (null == this.facts) this.facts = new ArrayList<>();
        for (Fact fact : facts) this.facts.add(fact);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(title, section.title) &&
                Objects.equals(startGroup, section.startGroup) &&
                Objects.equals(activityTitle, section.activityTitle) &&
                Objects.equals(activitySubtitle, section.activitySubtitle) &&
                Objects.equals(activityImage, section.activityImage) &&
                Objects.equals(activityText, section.activityText) &&
                Objects.equals(heroImage, section.heroImage) &&
                Objects.equals(text, section.text) &&
                Objects.equals(facts, section.facts) &&
                Objects.equals(images, section.images) &&
                Objects.equals(potentialActions, section.potentialActions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, startGroup, activityTitle, activitySubtitle, activityImage, activityText, heroImage, text, facts, images, potentialActions);
    }

    public String toString() {
        return "Section(title=" + this.getTitle() + ", startGroup=" + this.getStartGroup() + ", activityTitle=" + this.getActivityTitle() + ", activitySubtitle=" + this.getActivitySubtitle() + ", activityImage=" + this.getActivityImage() + ", activityText=" + this.getActivityText() + ", heroImage=" + this.getHeroImage() + ", text=" + this.getText() + ", facts=" + this.getFacts() + ", images=" + this.getImages() + ", potentialActions=" + this.getPotentialActions() + ")";
    }

    // Builder (delombok'd from lombok.Builder)
    public static SectionBuilder builder() {
        return new SectionBuilder();
    }

    public static class SectionBuilder {
        private String title;
        private Boolean startGroup;
        private String activityTitle;
        private String activitySubtitle;
        private String activityImage;
        private String activityText;
        private Image heroImage;
        private String text;
        private List<Fact> facts;
        private Image images;
        private List<Action> potentialActions;

        SectionBuilder() {
        }

        public SectionBuilder title(String title) {
            this.title = title;
            return this;
        }

        public SectionBuilder startGroup(Boolean startGroup) {
            this.startGroup = startGroup;
            return this;
        }

        public SectionBuilder activityTitle(String activityTitle) {
            this.activityTitle = activityTitle;
            return this;
        }

        public SectionBuilder activitySubtitle(String activitySubtitle) {
            this.activitySubtitle = activitySubtitle;
            return this;
        }

        public SectionBuilder activityImage(String activityImage) {
            this.activityImage = activityImage;
            return this;
        }

        public SectionBuilder activityText(String activityText) {
            this.activityText = activityText;
            return this;
        }

        public SectionBuilder heroImage(Image heroImage) {
            this.heroImage = heroImage;
            return this;
        }

        public SectionBuilder text(String text) {
            this.text = text;
            return this;
        }

        public SectionBuilder facts(List<Fact> facts) {
            this.facts = facts;
            return this;
        }

        public SectionBuilder images(Image images) {
            this.images = images;
            return this;
        }

        public SectionBuilder potentialActions(List<Action> potentialActions) {
            this.potentialActions = potentialActions;
            return this;
        }

        public SectionBuilder addPotentialAction(Action... actions) {
            if (null == this.potentialActions) this.potentialActions = new ArrayList<>();
            for (Action action : actions) this.potentialActions.add(action);
            return this;
        }

        public SectionBuilder addFact(String name, String value) {
            addFact(new Fact(name, value));
            return this;
        }

        public SectionBuilder addFact(Fact... facts) {
            if (null == this.facts) this.facts = new ArrayList<>();
            for (Fact fact : facts) this.facts.add(fact);
            return this;
        }

        public Section build() {
            return new Section(title, startGroup, activityTitle, activitySubtitle, activityImage, activityText, heroImage, text, facts, images, potentialActions);
        }

        public String toString() {
            return "Section.SectionBuilder(title=" + this.title + ", startGroup=" + this.startGroup + ", activityTitle=" + this.activityTitle + ", activitySubtitle=" + this.activitySubtitle + ", activityImage=" + this.activityImage + ", activityText=" + this.activityText + ", heroImage=" + this.heroImage + ", text=" + this.text + ", facts=" + this.facts + ", images=" + this.images + ", potentialActions=" + this.potentialActions + ")";
        }
    }
}
