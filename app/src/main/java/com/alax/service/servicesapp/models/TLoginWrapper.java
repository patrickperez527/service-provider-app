
package com.np.onei.servicesapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TLoginWrapper {

    @SerializedName("response")
    @Expose
    private List<TLoginResponse> response = null;

    public List<TLoginResponse> getResponse() {
        return response;
    }

    public void setResponse(List<TLoginResponse> response) {
        this.response = response;
    }

}
