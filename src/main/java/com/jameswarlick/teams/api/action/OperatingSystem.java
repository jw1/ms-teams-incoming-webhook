package com.jameswarlick.teams.api.action;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From https://docs.microsoft.com/en-us/outlook/actionable-messages/card-reference#openuri-action
 * <p>
 * Supported operating system values are default, windows, iOS and android. The
 * default operating system will in most cases simply open the URI in a web
 * browser, regardless of the actual operating system.
 *
 * @author james
 */
public enum OperatingSystem {

    @JsonProperty("default")
    DEFAULT,
    @JsonProperty("iOS")
    IOS,
    @JsonProperty("android")
    ANDROID,
    @JsonProperty("windows")
    WINDOWS;
}
