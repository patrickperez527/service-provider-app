
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationListItems {

    @SerializedName("n_id")
    @Expose
    private String nId;
    @SerializedName("n_title")
    @Expose
    private String nTitle;
    @SerializedName("n_message")
    @Expose
    private String nMessage;
    @SerializedName("n_created")
    @Expose
    private String nCreated;

    public String getNId() {
        return nId;
    }

    public void setNId(String nId) {
        this.nId = nId;
    }

    public String getNTitle() {
        return nTitle;
    }

    public void setNTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getNMessage() {
        return nMessage;
    }

    public void setNMessage(String nMessage) {
        this.nMessage = nMessage;
    }

    public String getNCreated() {
        return nCreated;
    }

    public void setNCreated(String nCreated) {
        this.nCreated = nCreated;
    }

}
