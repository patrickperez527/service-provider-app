
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechSignupWrapper {

    @SerializedName("response")
    @Expose
    private TechSignupResponse response;

    public TechSignupResponse getResponse() {
        return response;
    }

    public void setResponse(TechSignupResponse response) {
        this.response = response;
    }

}
