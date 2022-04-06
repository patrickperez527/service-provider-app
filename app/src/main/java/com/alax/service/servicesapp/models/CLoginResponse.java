
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CLoginResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("c_id")
    @Expose
    private String cId;
    @SerializedName("c_first_name")
    @Expose
    private String cFirstName;
    @SerializedName("c_last_name")
    @Expose
    private String cLastName;
    @SerializedName("c_phone")
    @Expose
    private String cPhone;
    @SerializedName("c_address")
    @Expose
    private String cAddress;
    @SerializedName("c_email")
    @Expose
    private String cEmail;
    @SerializedName("c_pass")
    @Expose
    private String cPass;
    @SerializedName("c_created")
    @Expose
    private String cCreated;

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

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public String getCFirstName() {
        return cFirstName;
    }

    public void setCFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
    }

    public String getCLastName() {
        return cLastName;
    }

    public void setCLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCPass() {
        return cPass;
    }

    public void setCPass(String cPass) {
        this.cPass = cPass;
    }

    public String getCCreated() {
        return cCreated;
    }

    public void setCCreated(String cCreated) {
        this.cCreated = cCreated;
    }

}
