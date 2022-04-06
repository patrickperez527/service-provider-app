
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentDoneWrapper {

    @SerializedName("response")
    @Expose
    private PaymentDoneResponse response;

    public PaymentDoneResponse getResponse() {
        return response;
    }

    public void setResponse(PaymentDoneResponse response) {
        this.response = response;
    }

}
