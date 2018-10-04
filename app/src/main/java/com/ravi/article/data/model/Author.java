
package com.ravi.article.data.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "picture",
    "full_name",
    "profile_slug"
})
public class Author {

    @JsonProperty("picture")
    private String picture;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("profile_slug")
    private String profileSlug;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("picture")
    public String getPicture() {
        return picture;
    }

    @JsonProperty("picture")
    public void setPicture(String picture) {
        this.picture = picture;
    }

    @JsonProperty("full_name")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("profile_slug")
    public String getProfileSlug() {
        return profileSlug;
    }

    @JsonProperty("profile_slug")
    public void setProfileSlug(String profileSlug) {
        this.profileSlug = profileSlug;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Author{" +
                "picture='" + picture + '\'' +
                ", fullName='" + fullName + '\'' +
                ", profileSlug='" + profileSlug + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
