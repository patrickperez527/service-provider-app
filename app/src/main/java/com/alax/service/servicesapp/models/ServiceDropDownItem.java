
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceDropDownItem {

    @SerializedName("s_id")
    @Expose
    private String sId;
    @SerializedName("s_name")
    @Expose
    private String sName;
    @SerializedName("pro_id")
    @Expose
    private String proId;

    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

}
