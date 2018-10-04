
package com.ravi.article.data.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "slug",
    "status",
    "content_code",
    "authors",
    "approvers",
    "description",
    "video_content",
    "article_type_fk",
    "featured_article",
    "featured_image",
    "publish_date",
    "publish_date_readable",
    "created_readable",
    "region_list",
    "tag_list",
    "report_slug",
    "get_article_type_display",
    "get_status_display",
    "subscription_package"
})
public class Datum {

    @JsonProperty("title")
    private String title;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("content_code")
    private Object contentCode;
    @JsonProperty("authors")
    private List<Author> authors = null;
    @JsonProperty("approvers")
    private List<Integer> approvers = null;
    @JsonProperty("description")
    private String description;
    @JsonProperty("video_content")
    private Object videoContent;
    @JsonProperty("article_type_fk")
    private String articleTypeFk;
    @JsonProperty("featured_article")
    private Boolean featuredArticle;
    @JsonProperty("featured_image")
    private List<FeaturedImage> featuredImage = null;
    @JsonProperty("publish_date")
    private String publishDate;
    @JsonProperty("publish_date_readable")
    private String publishDateReadable;
    @JsonProperty("created_readable")
    private String createdReadable;
    @JsonProperty("region_list")
    private List<RegionList> regionList = null;
    @JsonProperty("tag_list")
    private List<TagList> tagList = null;
    @JsonProperty("report_slug")
    private Object reportSlug;
    @JsonProperty("get_article_type_display")
    private String getArticleTypeDisplay;
    @JsonProperty("get_status_display")
    private String getStatusDisplay;
    @JsonProperty("subscription_package")
    private List<SubscriptionPackage> subscriptionPackage = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("content_code")
    public Object getContentCode() {
        return contentCode;
    }

    @JsonProperty("content_code")
    public void setContentCode(Object contentCode) {
        this.contentCode = contentCode;
    }

    @JsonProperty("authors")
    public List<Author> getAuthors() {
        return authors;
    }

    @JsonProperty("authors")
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @JsonProperty("approvers")
    public List<Integer> getApprovers() {
        return approvers;
    }

    @JsonProperty("approvers")
    public void setApprovers(List<Integer> approvers) {
        this.approvers = approvers;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("video_content")
    public Object getVideoContent() {
        return videoContent;
    }

    @JsonProperty("video_content")
    public void setVideoContent(Object videoContent) {
        this.videoContent = videoContent;
    }

    @JsonProperty("article_type_fk")
    public String getArticleTypeFk() {
        return articleTypeFk;
    }

    @JsonProperty("article_type_fk")
    public void setArticleTypeFk(String articleTypeFk) {
        this.articleTypeFk = articleTypeFk;
    }

    @JsonProperty("featured_article")
    public Boolean getFeaturedArticle() {
        return featuredArticle;
    }

    @JsonProperty("featured_article")
    public void setFeaturedArticle(Boolean featuredArticle) {
        this.featuredArticle = featuredArticle;
    }

    @JsonProperty("featured_image")
    public List<FeaturedImage> getFeaturedImage() {
        return featuredImage;
    }

    @JsonProperty("featured_image")
    public void setFeaturedImage(List<FeaturedImage> featuredImage) {
        this.featuredImage = featuredImage;
    }

    @JsonProperty("publish_date")
    public String getPublishDate() {
        return publishDate;
    }

    @JsonProperty("publish_date")
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @JsonProperty("publish_date_readable")
    public String getPublishDateReadable() {
        return publishDateReadable;
    }

    @JsonProperty("publish_date_readable")
    public void setPublishDateReadable(String publishDateReadable) {
        this.publishDateReadable = publishDateReadable;
    }

    @JsonProperty("created_readable")
    public String getCreatedReadable() {
        return createdReadable;
    }

    @JsonProperty("created_readable")
    public void setCreatedReadable(String createdReadable) {
        this.createdReadable = createdReadable;
    }

    @JsonProperty("region_list")
    public List<RegionList> getRegionList() {
        return regionList;
    }

    @JsonProperty("region_list")
    public void setRegionList(List<RegionList> regionList) {
        this.regionList = regionList;
    }

    @JsonProperty("tag_list")
    public List<TagList> getTagList() {
        return tagList;
    }

    @JsonProperty("tag_list")
    public void setTagList(List<TagList> tagList) {
        this.tagList = tagList;
    }

    @JsonProperty("report_slug")
    public Object getReportSlug() {
        return reportSlug;
    }

    @JsonProperty("report_slug")
    public void setReportSlug(Object reportSlug) {
        this.reportSlug = reportSlug;
    }

    @JsonProperty("get_article_type_display")
    public String getGetArticleTypeDisplay() {
        return getArticleTypeDisplay;
    }

    @JsonProperty("get_article_type_display")
    public void setGetArticleTypeDisplay(String getArticleTypeDisplay) {
        this.getArticleTypeDisplay = getArticleTypeDisplay;
    }

    @JsonProperty("get_status_display")
    public String getGetStatusDisplay() {
        return getStatusDisplay;
    }

    @JsonProperty("get_status_display")
    public void setGetStatusDisplay(String getStatusDisplay) {
        this.getStatusDisplay = getStatusDisplay;
    }

    @JsonProperty("subscription_package")
    public List<SubscriptionPackage> getSubscriptionPackage() {
        return subscriptionPackage;
    }

    @JsonProperty("subscription_package")
    public void setSubscriptionPackage(List<SubscriptionPackage> subscriptionPackage) {
        this.subscriptionPackage = subscriptionPackage;
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
        return "Datum{" +
                "title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", status=" + status +
                ", contentCode=" + contentCode +
                ", authors=" + authors +
                ", approvers=" + approvers +
                ", description='" + description + '\'' +
                ", videoContent=" + videoContent +
                ", articleTypeFk='" + articleTypeFk + '\'' +
                ", featuredArticle=" + featuredArticle +
                ", featuredImage=" + featuredImage +
                ", publishDate='" + publishDate + '\'' +
                ", publishDateReadable='" + publishDateReadable + '\'' +
                ", createdReadable='" + createdReadable + '\'' +
                ", regionList=" + regionList +
                ", tagList=" + tagList +
                ", reportSlug=" + reportSlug +
                ", getArticleTypeDisplay='" + getArticleTypeDisplay + '\'' +
                ", getStatusDisplay='" + getStatusDisplay + '\'' +
                ", subscriptionPackage=" + subscriptionPackage +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
