package com.example.personalassistant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



    public class ExpenseBody {

        @SerializedName("P1")
        @Expose
        private int p1;
        @SerializedName("P2")
        @Expose
        private int p2;
        @SerializedName("P3")
        @Expose
        private int p3;
        @SerializedName("Narration")
        @Expose
        private String narration;
        @SerializedName("UserId")
        @Expose
        private String userId;

        public int getP1() {
            return p1;
        }

        public void setP1(int p1) {
            this.p1 = p1;
        }

        public int getP2() {
            return p2;
        }

        public void setP2(int p2) {
            this.p2 = p2;
        }

        public int getP3() {
            return p3;
        }

        public void setP3(int p3) {
            this.p3 = p3;
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
