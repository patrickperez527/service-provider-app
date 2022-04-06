
package com.np.onei.servicesapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MakePayWrapper {

    @SerializedName("response")
    @Expose
    private List<PaymetResponse> response = null;

    public List<PaymetResponse> getResponse() {
        return response;
    }

    public void setResponse(List<PaymetResponse> response) {
        this.response = response;
    }

}
