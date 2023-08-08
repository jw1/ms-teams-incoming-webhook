package com.jameswarlick.teams.api;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Simple test to verify the theme color parsers do expected things.
 */
public class ThemeColorTest {

    /**
     * The sample theme color provided in the documentation is 0078D7.  Convert it and return it.
     */
    @Test
    public void thereAndBackAgain() {
        String original = "0078D7";
        Color toColor = toColor(original);
        String andBackAgain = toHexString(toColor);

        assertThat(original).isEqualTo(andBackAgain);
    }

    private Color toColor(String str) {
        return Color.decode("#" + str);
    }

    public String toHexString(Color themeColor) {
        return String.format("#%02x%02x%02x", themeColor.getRed(), themeColor.getGreen(), themeColor.getBlue()).toUpperCase().substring(1);
    }
}
