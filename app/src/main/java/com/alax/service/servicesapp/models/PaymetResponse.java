
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymetResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("amount")
    @Expose
    private String amount;

    @SerializedName("service_amount")
    @Expose
    private String service_amount;



    @SerializedName("eid")
    @Expose
    private String eid;



    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;

    public String getService_amount() {
        return service_amount;
    }

    public void setService_amount(String service_amount) {
        this.service_amount = service_amount;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}
