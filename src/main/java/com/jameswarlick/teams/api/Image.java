package com.jameswarlick.teams.api;

import java.util.Objects;

/**
 * Defines an image used by the heroImage and image objects.
 * See https://docs.microsoft.com/en-us/outlook/actionable-messages/card-reference#image-object
 *
 * @author james
 */
public class Image {

    private String image;
    private String title;


    public Image() {
    }

    public Image(String image, String title) {
        this.image = image;
        this.title = title;
    }


    public String getImage() {
        return this.image;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image1 = (Image) o;

        return Objects.equals(image, image1.image) &&
                Objects.equals(title, image1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, title);
    }

    @Override
    public String toString() {
        return "Image{image='" + image + "', title='" + title + "' + }";
    }
}
