
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerSignupWrapper {

    @SerializedName("response")
    @Expose
    private CustomerSignupResponse response;

    public CustomerSignupResponse getResponse() {
        return response;
    }

    public void setResponse(CustomerSignupResponse response) {
        this.response = response;
    }

}
