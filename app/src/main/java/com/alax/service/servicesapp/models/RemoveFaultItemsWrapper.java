
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RemoveFaultItemsWrapper {

    @SerializedName("response")
    @Expose
    private RemoveFaultIremResponse response;

    public RemoveFaultIremResponse getResponse() {
        return response;
    }

    public void setResponse(RemoveFaultIremResponse response) {
        this.response = response;
    }

}
