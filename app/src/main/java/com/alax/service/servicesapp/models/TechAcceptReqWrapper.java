
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechAcceptReqWrapper {

    @SerializedName("response")
    @Expose
    private TechAcceptReqResponse response;

    public TechAcceptReqResponse getResponse() {
        return response;
    }

    public void setResponse(TechAcceptReqResponse response) {
        this.response = response;
    }

}
