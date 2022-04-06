
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusinessListDwapper {

    @SerializedName("response")
    @Expose
    private BusinessResponse response;

    public BusinessResponse getResponse() {
        return response;
    }

    public void setResponse(BusinessResponse response) {
        this.response = response;
    }

}
