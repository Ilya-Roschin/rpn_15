package com.java.laba;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonsToSerialization implements Serializable {

    private List<Person> personList = new ArrayList<>();


    public PersonsToSerialization(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
