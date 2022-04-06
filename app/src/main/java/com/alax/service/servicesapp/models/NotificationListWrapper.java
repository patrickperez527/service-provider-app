
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationListWrapper {

    @SerializedName("response")
    @Expose
    private NotificationListResponse response;

    public NotificationListResponse getResponse() {
        return response;
    }

    public void setResponse(NotificationListResponse response) {
        this.response = response;
    }

}
