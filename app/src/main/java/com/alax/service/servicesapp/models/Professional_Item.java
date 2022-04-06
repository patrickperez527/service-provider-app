
package com.np.onei.servicesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Professional_Item {

    @SerializedName("pro_id")
    @Expose
    private String proId;
    @SerializedName("pro_name")
    @Expose
    private String proName;
    @SerializedName("pro_dis")
    @Expose
    private String proDis;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDis() {
        return proDis;
    }

    public void setProDis(String proDis) {
        this.proDis = proDis;
    }

}
