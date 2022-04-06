
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceDropDownWrapper {

    @SerializedName("response")
    @Expose
    private ServiceDropDownResponse response;

    public ServiceDropDownResponse getResponse() {
        return response;
    }

    public void setResponse(ServiceDropDownResponse response) {
        this.response = response;
    }

}
