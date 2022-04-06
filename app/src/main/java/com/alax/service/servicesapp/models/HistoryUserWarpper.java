
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryUserWarpper {

    @SerializedName("response")
    @Expose
    private HistoryUserResponse response;

    public HistoryUserResponse getResponse() {
        return response;
    }

    public void setResponse(HistoryUserResponse response) {
        this.response = response;
    }

}
