
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechPendingListItems {

    @SerializedName("e_id")
    @Expose
    private String eId;
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
    @SerializedName("s_name")
    @Expose
    private String sName;
    @SerializedName("pro_name")
    @Expose
    private String proName;
    @SerializedName("contact_person_name")
    @Expose
    private String contactPersonName;
    @SerializedName("contact_person_mail")
    @Expose
    private String contactPersonMail;
    @SerializedName("contact_person_mob")
    @Expose
    private String contactPersonMob;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("work_status")
    @Expose
    private String workStatus;
    @SerializedName("e_created")
    @Expose
    private String eCreated;

    @SerializedName("c_id")
    @Expose
    private String c_id;

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }


    public String getEId() {
        return eId;
    }

    public void setEId(String eId) {
        this.eId = eId;
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

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonMail() {
        return contactPersonMail;
    }

    public void setContactPersonMail(String contactPersonMail) {
        this.contactPersonMail = contactPersonMail;
    }

    public String getContactPersonMob() {
        return contactPersonMob;
    }

    public void setContactPersonMob(String contactPersonMob) {
        this.contactPersonMob = contactPersonMob;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getECreated() {
        return eCreated;
    }

    public void setECreated(String eCreated) {
        this.eCreated = eCreated;
    }

}
