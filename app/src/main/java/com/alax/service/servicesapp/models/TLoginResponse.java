
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TLoginResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("t_id")
    @Expose
    private String tId;
    @SerializedName("b_id")
    @Expose
    private String bId;
    @SerializedName("professional_area")
    @Expose
    private String professionalArea;
    @SerializedName("tech_name")
    @Expose
    private String techName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("t_address")
    @Expose
    private String tAddress;
    @SerializedName("t_phone")
    @Expose
    private String tPhone;
    @SerializedName("t_email")
    @Expose
    private String tEmail;
    @SerializedName("t_created")
    @Expose
    private String tCreated;

    @SerializedName("t_pass")
    @Expose
    private String tpass;

    public String getTpass() {
        return tpass;
    }

    public void setTpass(String tpass) {
        this.tpass = tpass;
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

    public String getTId() {
        return tId;
    }

    public void setTId(String tId) {
        this.tId = tId;
    }

    public String getBId() {
        return bId;
    }

    public void setBId(String bId) {
        this.bId = bId;
    }

    public String getProfessionalArea() {
        return professionalArea;
    }

    public void setProfessionalArea(String professionalArea) {
        this.professionalArea = professionalArea;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTAddress() {
        return tAddress;
    }

    public void setTAddress(String tAddress) {
        this.tAddress = tAddress;
    }

    public String getTPhone() {
        return tPhone;
    }

    public void setTPhone(String tPhone) {
        this.tPhone = tPhone;
    }

    public String getTEmail() {
        return tEmail;
    }

    public void setTEmail(String tEmail) {
        this.tEmail = tEmail;
    }

    public String getTCreated() {
        return tCreated;
    }

    public void setTCreated(String tCreated) {
        this.tCreated = tCreated;
    }

}
