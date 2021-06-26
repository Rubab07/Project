package com.example.personalassistant.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IncomBody {
    @SerializedName("TotalIncome")
    @Expose
    private int totalIncome;
    @SerializedName("Narration")
    @Expose
    private String narration;
    @SerializedName("UserId")
    @Expose
    private String userId;

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
