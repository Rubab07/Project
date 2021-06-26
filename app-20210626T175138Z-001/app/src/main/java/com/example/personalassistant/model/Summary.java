package com.example.personalassistant.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Summary {

    @SerializedName("balance")
    @Expose
    private Balance balance;
    @SerializedName("incomes")
    @Expose
    private List<Income> incomes = null;
    @SerializedName("expenses")
    @Expose
    private List<Expense> expenses = null;

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

}