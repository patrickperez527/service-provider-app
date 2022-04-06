
package com.np.onei.servicesapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EnqryWapper {

    @SerializedName("response")
    @Expose
    private List<EnqryResponse> response = null;

    public List<EnqryResponse> getResponse() {
        return response;
    }

    public void setResponse(List<EnqryResponse> response) {
        this.response = response;
    }

}
