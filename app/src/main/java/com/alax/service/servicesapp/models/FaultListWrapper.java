
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FaultListWrapper {

    @SerializedName("response")
    @Expose
    private FaultListResponse response;

    public FaultListResponse getResponse() {
        return response;
    }

    public void setResponse(FaultListResponse response) {
        this.response = response;
    }

}
