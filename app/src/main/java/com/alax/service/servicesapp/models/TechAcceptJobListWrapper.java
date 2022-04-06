
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechAcceptJobListWrapper {

    @SerializedName("response")
    @Expose
    private TechAcceptListResponse response;

    public TechAcceptListResponse getResponse() {
        return response;
    }

    public void setResponse(TechAcceptListResponse response) {
        this.response = response;
    }

}
