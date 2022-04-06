
package com.np.onei.servicesapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendingJobCompleteJobWrapper {

    @SerializedName("response")
    @Expose
    private List<PendingCompleteJobResponse> response = null;

    public List<PendingCompleteJobResponse> getResponse() {
        return response;
    }

    public void setResponse(List<PendingCompleteJobResponse> response) {
        this.response = response;
    }

}
