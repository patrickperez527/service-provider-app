
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddFaultWrapper {

    @SerializedName("response")
    @Expose
    private AddFaultResponse response;

    public AddFaultResponse getResponse() {
        return response;
    }

    public void setResponse(AddFaultResponse response) {
        this.response = response;
    }


}
