package com.java.laba;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable {

   private String username;

   private List<Income> incomes = new ArrayList<Income>();

    public Person() {
    }

    public Person(String username, List<Income> incomes) {
        this.username = username;
        this.incomes = incomes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", incomes=" + incomes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(username, person.username) && Objects.equals(incomes, person.incomes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, incomes);
    }
}
