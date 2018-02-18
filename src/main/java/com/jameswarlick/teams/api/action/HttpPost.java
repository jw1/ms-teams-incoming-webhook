package com.jameswarlick.teams.api.action;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.jameswarlick.teams.api.Header;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * From https://docs.microsoft.com/en-us/outlook/actionable-messages/card-reference#httppost-action
 * <p>
 * Makes a call to an external Web service.
 */
@JsonTypeName("HttpPOST")
public class HttpPost implements Action {

    /**
     * If this is added as a header, the value is appended to the already posted card.
     */
    public static final String CARD_ACTION_STATUS_HEADER = "CARD-ACTION-STATUS";

    private String name;
    private String target;
    private List<Header> headers;
    private String body;
    private String bodyContentType = "application/json";


    public HttpPost() {
    }

    public HttpPost(String name, String target) {
        this.name = name;
        this.target = target;
    }

    public HttpPost(String name, String target, String body) {
        this.name = name;
        this.target = target;
        this.body = body;
    }


    public String getName() {
        return this.name;
    }

    public String getTarget() {
        return this.target;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getBody() {
        return this.body;
    }

    public String getBodyContentType() {
        return this.bodyContentType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setBodyContentType(String bodyContentType) {
        this.bodyContentType = bodyContentType;
    }

    public void addHeader(Header... headers) {
        if (null == this.headers) this.headers = new ArrayList<>();
        for (Header header : headers) this.headers.add(header);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpPost httpPost = (HttpPost) o;
        return Objects.equals(name, httpPost.name) &&
                Objects.equals(target, httpPost.target) &&
                Objects.equals(headers, httpPost.headers) &&
                Objects.equals(body, httpPost.body) &&
                Objects.equals(bodyContentType, httpPost.bodyContentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, target, headers, body, bodyContentType);
    }

    public String toString() {
        return "HttpPost(name=" + this.getName() + ", target=" + this.getTarget() + ", headers=" + this.getHeaders() + ", body=" + this.getBody() + ", bodyContentType=" + this.getBodyContentType() + ")";
    }
}
