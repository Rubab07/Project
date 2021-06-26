package com.example.personalassistant.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class SummaryBody {

    @SerializedName("Motnh")
    @Expose
    private int motnh;
    @SerializedName("Year")
    @Expose
    private int year;
    @SerializedName("All")
    @Expose
    private String all;

    public int getMotnh() {
        return motnh;
    }

    public void setMotnh(int motnh) {
        this.motnh = motnh;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

}


