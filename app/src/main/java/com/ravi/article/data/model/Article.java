
package com.ravi.article.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "total_count",
        "page_size",
        "total_pages",
        "next",
        "previous",
        "current_page",
        "metadata",
        "message",
        "data"
})
public class Article implements Parcelable {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("page_size")
    private Integer pageSize;
    @JsonProperty("total_pages")
    private Double totalPages;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("current_page")
    private Integer currentPage;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private List<Datum> data = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("total_count")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("total_count")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("page_size")
    public Integer getPageSize() {
        return pageSize;
    }

    @JsonProperty("page_size")
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @JsonProperty("total_pages")
    public Double getTotalPages() {
        return totalPages;
    }

    @JsonProperty("total_pages")
    public void setTotalPages(Double totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
    }

    @JsonProperty("previous")
    public String getPrevious() {
        return previous;
    }

    @JsonProperty("previous")
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    @JsonProperty("current_page")
    public Integer getCurrentPage() {
        return currentPage;
    }

    @JsonProperty("current_page")
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
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
        return "Article{" +
                "count=" + count +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", next='" + next + '\'' +
                ", previous=" + previous +
                ", currentPage=" + currentPage +
                ", metadata=" + metadata +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.count);
        dest.writeValue(this.totalCount);
        dest.writeValue(this.pageSize);
        dest.writeValue(this.totalPages);
        dest.writeString(this.next);
        dest.writeString(this.previous);
        dest.writeValue(this.currentPage);
        dest.writeParcelable(this.metadata, flags);
        dest.writeString(this.message);
        dest.writeList(this.data);
        dest.writeInt(this.additionalProperties.size());
        for (Map.Entry<String, Object> entry : this.additionalProperties.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeParcelable((Parcelable) entry.getValue(), flags);
        }
    }

    public Article() {
    }

    protected Article(Parcel in) {
        this.count = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.pageSize = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalPages = (Double) in.readValue(Double.class.getClassLoader());
        this.next = in.readString();
        this.previous = in.readParcelable(String.class.getClassLoader());
        this.currentPage = (Integer) in.readValue(Integer.class.getClassLoader());
        this.metadata = in.readParcelable(Metadata.class.getClassLoader());
        this.message = in.readString();
        this.data = new ArrayList<Datum>();
        in.readList(this.data, Datum.class.getClassLoader());
        int additionalPropertiesSize = in.readInt();
        this.additionalProperties = new HashMap<String, Object>(additionalPropertiesSize);
        for (int i = 0; i < additionalPropertiesSize; i++) {
            String key = in.readString();
            Object value = in.readParcelable(Object.class.getClassLoader());
            this.additionalProperties.put(key, value);
        }
    }

    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
