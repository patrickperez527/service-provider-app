
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfessionalAreaWrapper {

    @SerializedName("response")
    @Expose
    private ProfessionalResponse response;

    public ProfessionalResponse getResponse() {
        return response;
    }

    public void setResponse(ProfessionalResponse response) {
        this.response = response;
    }

}
