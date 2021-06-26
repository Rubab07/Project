package com.example.personalassistant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Balance {
    @SerializedName("totalInc")
    @Expose
    private float totalInc;
    @SerializedName("totalExp")
    @Expose
    private float totalExp;
    @SerializedName("totalBlnc")
    @Expose
    private float totalBlnc;
    @SerializedName("p1Inco")
    @Expose
    private float p1Inco;
    @SerializedName("p1Exp")
    @Expose
    private float p1Exp;
    @SerializedName("p1Blnc")
    @Expose
    private float p1Blnc;
    @SerializedName("p2Inc")
    @Expose
    private float p2Inc;
    @SerializedName("p2Exp")
    @Expose
    private float p2Exp;
    @SerializedName("p2Blnc")
    @Expose
    private float p2Blnc;
    @SerializedName("p3Inc")
    @Expose
    private float p3Inc;
    @SerializedName("p3Exp")
    @Expose
    private float p3Exp;
    @SerializedName("p3Blnc")
    @Expose
    private float p3Blnc;

    public float getTotalInc() {
        return totalInc;
    }

    public void setTotalInc(float totalInc) {
        this.totalInc = totalInc;
    }

    public float getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(float totalExp) {
        this.totalExp = totalExp;
    }

    public float getTotalBlnc() {
        return totalBlnc;
    }

    public void setTotalBlnc(float totalBlnc) {
        this.totalBlnc = totalBlnc;
    }

    public float getP1Inco() {
        return p1Inco;
    }

    public void setP1Inco(float p1Inco) {
        this.p1Inco = p1Inco;
    }

    public float getP1Exp() {
        return p1Exp;
    }

    public void setP1Exp(float p1Exp) {
        this.p1Exp = p1Exp;
    }

    public float getP1Blnc() {
        return p1Blnc;
    }

    public void setP1Blnc(float p1Blnc) {
        this.p1Blnc = p1Blnc;
    }

    public float getP2Inc() {
        return p2Inc;
    }

    public void setP2Inc(float p2Inc) {
        this.p2Inc = p2Inc;
    }

    public float getP2Exp() {
        return p2Exp;
    }

    public void setP2Exp(float p2Exp) {
        this.p2Exp = p2Exp;
    }

    public float getP2Blnc() {
        return p2Blnc;
    }

    public void setP2Blnc(float p2Blnc) {
        this.p2Blnc = p2Blnc;
    }

    public float getP3Inc() {
        return p3Inc;
    }

    public void setP3Inc(float p3Inc) {
        this.p3Inc = p3Inc;
    }

    public float getP3Exp() {
        return p3Exp;
    }

    public void setP3Exp(float p3Exp) {
        this.p3Exp = p3Exp;
    }

    public float getP3Blnc() {
        return p3Blnc;
    }

    public void setP3Blnc(float p3Blnc) {
        this.p3Blnc = p3Blnc;
    }

}
