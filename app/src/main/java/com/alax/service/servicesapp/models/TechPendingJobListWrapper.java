
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechPendingJobListWrapper {

    @SerializedName("response")
    @Expose
    private TechPedingListResponse response;

    public TechPedingListResponse getResponse() {
        return response;
    }

    public void setResponse(TechPedingListResponse response) {
        this.response = response;
    }

}
