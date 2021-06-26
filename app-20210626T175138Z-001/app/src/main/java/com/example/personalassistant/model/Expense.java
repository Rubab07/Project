package com.example.personalassistant.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Expense {
    @SerializedName("transId")
    @Expose
    private String transId;
    @SerializedName("totalExp")
    @Expose
    private float totalExp;
    @SerializedName("p1")
    @Expose
    private float p1;
    @SerializedName("p2")
    @Expose
    private float p2;
    @SerializedName("p3")
    @Expose
    private float p3;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("narration")
    @Expose
    private String narration;

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public float getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(float totalExp) {
        this.totalExp = totalExp;
    }

    public float getP1() {
        return p1;
    }

    public void setP1(float p1) {
        this.p1 = p1;
    }

    public float getP2() {
        return p2;
    }

    public void setP2(float p2) {
        this.p2 = p2;
    }

    public float getP3() {
        return p3;
    }

    public void setP3(float p3) {
        this.p3 = p3;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }
}
