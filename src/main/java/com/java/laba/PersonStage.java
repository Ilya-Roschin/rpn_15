package com.java.laba;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonStage {

    private static final List<Person> PERSON_LIST = new ArrayList<>();

    public void addPerson(Person person) {
        PERSON_LIST.add(person);
    }

    public List<Person> findAll() {
        return PERSON_LIST;
    }

    public Person findByName(String username) {
        for (Person element : PERSON_LIST) {
            if (Objects.equals(element.getUsername(), username)) {
                return element;
            }
        }
        return new Person();
    }

}
