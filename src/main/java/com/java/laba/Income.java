package com.java.laba;

import java.io.Serializable;
import java.util.Objects;

public class Income implements Serializable {

    private String name;

    private long money;

    private double tax;

    private double moneyToTax;

    public Income() {
    }

    public Income(String name, long money, double tax) {
        this.name = name;
        this.money = money;
        this.tax = tax;
        moneyToTax = money * tax / 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getMoneyToTax() {
        return moneyToTax;
    }

    public void setMoneyToTax(double moneyToTax) {
        this.moneyToTax = moneyToTax;
    }

    public Income(String name, long money, double tax, double moneyToTax) {
        this.name = name;
        this.money = money;
        this.tax = tax;
        this.moneyToTax = moneyToTax;
    }

    public void updateMoneyToTax() {
        moneyToTax = money * tax / 100;
    }

    @Override
    public String toString() {
        return "Income{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", tax=" + tax +
                ", moneyToTax=" + moneyToTax +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return money == income.money && Double.compare(income.tax, tax) == 0 &&
                Double.compare(income.moneyToTax, moneyToTax) == 0 && Objects.equals(name, income.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, tax, moneyToTax);
    }
}
