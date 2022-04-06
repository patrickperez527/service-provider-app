
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendingCompleteJobResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("pendingJob")
    @Expose
    private String pendingJob;
    @SerializedName("completeJob")
    @Expose
    private String completeJob;

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

    public String getPendingJob() {
        return pendingJob;
    }

    public void setPendingJob(String pendingJob) {
        this.pendingJob = pendingJob;
    }

    public String getCompleteJob() {
        return completeJob;
    }

    public void setCompleteJob(String completeJob) {
        this.completeJob = completeJob;
    }

}
