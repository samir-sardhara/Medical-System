package com.example.Medical_System.models;

import jakarta.persistence.*;

@Entity
public class MedicalBillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int quantity;
    private double rate;
    private double tax;
    @Transient
    private double amount;
    public  MedicalBillItem(){}
    public MedicalBillItem(String title, int quantity, double rate,double tax){
        this.title = title;
        this.quantity = quantity;
        this.rate = rate;
        this.tax = tax;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getAmount() {
        double value = quantity * rate;
        double roundValue = Math.round(value * 100.0) / 100.0;
        return roundValue;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
