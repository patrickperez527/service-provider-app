
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FeedBackWrapper {

    @SerializedName("response")
    @Expose
    private FeedbackResponse response;

    public FeedbackResponse getResponse() {
        return response;
    }

    public void setResponse(FeedbackResponse response) {
        this.response = response;
    }

}
