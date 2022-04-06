
package com.np.onei.servicesapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CLoginWrapper {

    @SerializedName("response")
    @Expose
    private List<CLoginResponse> response = null;

    public List<CLoginResponse> getResponse() {
        return response;
    }

    public void setResponse(List<CLoginResponse> response) {
        this.response = response;
    }

}
