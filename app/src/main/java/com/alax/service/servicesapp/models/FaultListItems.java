
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FaultListItems {

    @SerializedName("f_id")
    @Expose
    private String fId;

    @SerializedName("pay_approve")
    @Expose
    private String pay_approve;

    @SerializedName("f_details")
    @Expose
    private String fDetails;

    public String getPay_approve() {
        return pay_approve;
    }

    public void setPay_approve(String pay_approve) {
        this.pay_approve = pay_approve;
    }

    public String getFId() {
        return fId;
    }

    public void setFId(String fId) {
        this.fId = fId;
    }

    public String getFDetails() {
        return fDetails;
    }

    public void setFDetails(String fDetails) {
        this.fDetails = fDetails;
    }

}
