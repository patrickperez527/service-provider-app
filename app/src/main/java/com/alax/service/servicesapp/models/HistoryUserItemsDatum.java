
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryUserItemsDatum {

    @SerializedName("e_id")
    @Expose
    private String eId;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("b_name")
    @Expose
    private Object bName;
    @SerializedName("pro_name")
    @Expose
    private Object proName;
    @SerializedName("c_first_name")
    @Expose
    private String cFirstName;
    @SerializedName("c_phone")
    @Expose
    private String cPhone;
    @SerializedName("c_address")
    @Expose
    private String cAddress;
    @SerializedName("amount_paid")
    @Expose
    private String amountPaid;

    @SerializedName("s_name")
    @Expose
    private String s_name;


    @SerializedName("tech_name")
    @Expose
    private String tech_name;

    @SerializedName("work_status")
    @Expose
    private String workStatus;
    @SerializedName("workFlgStatus")
    @Expose
    private String workFlgStatus;

    public String getTech_name() {
        return tech_name;
    }

    public void setTech_name(String tech_name) {
        this.tech_name = tech_name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getEId() {
        return eId;
    }

    public void setEId(String eId) {
        this.eId = eId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Object getBName() {
        return bName;
    }

    public void setBName(Object bName) {
        this.bName = bName;
    }

    public Object getProName() {
        return proName;
    }

    public void setProName(Object proName) {
        this.proName = proName;
    }

    public String getCFirstName() {
        return cFirstName;
    }

    public void setCFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
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

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getWorkFlgStatus() {
        return workFlgStatus;
    }

    public void setWorkFlgStatus(String workFlgStatus) {
        this.workFlgStatus = workFlgStatus;
    }

}
