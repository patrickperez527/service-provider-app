
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupWrapper {

    @SerializedName("response")
    @Expose
    private SignupResponse response;

    public SignupResponse getResponse() {
        return response;
    }

    public void setResponse(SignupResponse response) {
        this.response = response;
    }

}
