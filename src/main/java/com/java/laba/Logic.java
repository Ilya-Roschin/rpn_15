package com.java.laba;

import java.util.Comparator;
import java.util.List;

public class Logic {

    private static final PersonStage PERSON_STAGE = new PersonStage();

    public void findSumOfTaxes(String username) {
        Person person = PERSON_STAGE.findByName(username);
        System.out.println(person.getUsername());
        long sum = 0;
        for (Income income : person.getIncomes()) {
            System.out.println(income);
            sum += income.getMoney() * income.getTax() / 100;
        }
        System.out.println("Сумма налогов: " + sum);
    }

    public void printAllPersons() {
        PERSON_STAGE.findAll().forEach(System.out::println);
    }

    public void sortTaxesByIncrease(String username) {
        List<Income> incomes = PERSON_STAGE.findByName(username).getIncomes();
        Comparator<Income> comparator = Comparator.comparing(Income::getMoneyToTax);
        incomes.sort(comparator);
    }

    public void addPerson(Person person) {
        PERSON_STAGE.addPerson(person);
    }

    public void addIncomesToPerson(Income income, String username) {
        final List<Income> incomes = PERSON_STAGE.findByName(username).getIncomes();
        incomes.add(income);
    }

}
