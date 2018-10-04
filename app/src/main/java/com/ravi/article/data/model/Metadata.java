
package com.ravi.article.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
public class Metadata implements Parcelable {

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
        return "Metadata{" +
                "additionalProperties=" + additionalProperties +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.additionalProperties.size());
        for (Map.Entry<String, Object> entry : this.additionalProperties.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeParcelable((Parcelable) entry.getValue(), flags);
        }
    }

    public Metadata() {
    }

    protected Metadata(Parcel in) {
        int additionalPropertiesSize = in.readInt();
        this.additionalProperties = new HashMap<String, Object>(additionalPropertiesSize);
        for (int i = 0; i < additionalPropertiesSize; i++) {
            String key = in.readString();
            Object value = in.readParcelable(Object.class.getClassLoader());
            this.additionalProperties.put(key, value);
        }
    }

    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        @Override
        public Metadata createFromParcel(Parcel source) {
            return new Metadata(source);
        }

        @Override
        public Metadata[] newArray(int size) {
            return new Metadata[size];
        }
    };
}
