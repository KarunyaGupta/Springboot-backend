package com.expensetracker.model;

public class Expense {
    private String id;
    private String description;
    private Double amount;

    public Expense() {}

    public Expense(String id, String description, Double amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}