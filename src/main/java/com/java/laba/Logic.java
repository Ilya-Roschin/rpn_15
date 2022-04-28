package com.java.laba;

import java.util.Comparator;
import java.util.List;

public class Logic {

    private static final FileReader FILE_READER = new FileReader();

    public void findSumOfTaxes(String username) {
        Person person = new Person();
        for (Person element : FILE_READER.findAll()) {
            if(element.getUsername().equals(username)) {
                person = element;
                break;
            }
        }
        System.out.println(person.getUsername());
        long sum = 0;
        for (Income income : person.getIncomes()) {
            System.out.println(income);
            sum += income.getMoney() * income.getTax() / 100;
        }
        System.out.println("Сумма налогов: " + sum);
    }

    public void printAllPersons() {
        FILE_READER.findAll().forEach(System.out::println);
    }

    public void sortTaxesByIncrease(String username) throws PersonNotFoundedException {
        Person person = new Person();
        for (Person element : FILE_READER.findAll()) {
            if(element.getUsername().equals(username)) {
                person = element;
                break;
            }
        }
        List<Income> incomes = person.getIncomes();
        Comparator<Income> comparator = Comparator.comparing(Income::getMoneyToTax);
        incomes.sort(comparator);
        FILE_READER.updatePerson(person.getUsername(), person);
    }

    public void addPerson(Person person) {
        FILE_READER.addToFile(person);
    }

    public void addIncomesToPerson(Income income, String username) throws PersonNotFoundedException {
        Person person = FILE_READER.findPersonByName(username);
        final List<Income> incomes = person.getIncomes();
        incomes.add(income);
        FILE_READER.updatePerson(person.getUsername(), person);
    }

}
