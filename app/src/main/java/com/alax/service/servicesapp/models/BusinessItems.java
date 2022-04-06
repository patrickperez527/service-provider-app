
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusinessItems {

    @SerializedName("b_id")
    @Expose
    private String bId;
    @SerializedName("b_mail")
    @Expose
    private String bMail;
    @SerializedName("b_reps")
    @Expose
    private String bReps;
    @SerializedName("b_phone")
    @Expose
    private String bPhone;
    @SerializedName("b_address")
    @Expose
    private String bAddress;
    @SerializedName("b_created")
    @Expose
    private String bCreated;
    @SerializedName("b_name")
    @Expose
    private String bName;

    public String getBId() {
        return bId;
    }

    public void setBId(String bId) {
        this.bId = bId;
    }

    public String getBMail() {
        return bMail;
    }

    public void setBMail(String bMail) {
        this.bMail = bMail;
    }

    public String getBReps() {
        return bReps;
    }

    public void setBReps(String bReps) {
        this.bReps = bReps;
    }

    public String getBPhone() {
        return bPhone;
    }

    public void setBPhone(String bPhone) {
        this.bPhone = bPhone;
    }

    public String getBAddress() {
        return bAddress;
    }

    public void setBAddress(String bAddress) {
        this.bAddress = bAddress;
    }

    public String getBCreated() {
        return bCreated;
    }

    public void setBCreated(String bCreated) {
        this.bCreated = bCreated;
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

}
