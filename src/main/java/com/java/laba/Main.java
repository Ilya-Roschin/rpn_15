package com.java.laba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logic LOGIC = new Logic();
    private static final PersonStage PERSON_STAGE = new PersonStage();

    public static void main(String[] args) {
        init();
        while (true) {
            try {
                readPersonMenu();
                userController();
            } catch (Exception e) {
                System.out.println("Не стукай!!!");
                SCANNER.nextLine();
            }
        }
    }

    public static void readPersonMenu() {
        System.out.println("Menu \n" +
                "1. найти сумму налогов \n" +
                "2. отсортировать налоги по ворастанию\n" +
                "3. добавить пользователя \n" +
                "4. добавить пользователю налог \n" +
                "5. отобразить всех \n" +
                "6. Выход");
    }

    public static void userController() {
        switch (SCANNER.nextInt()) {
            case 1:
                SCANNER.nextLine();
                System.out.println("введите имя пользователя");
                LOGIC.findSumOfTaxes(SCANNER.nextLine());
                break;
            case 2:
                SCANNER.nextLine();
                System.out.println("введите имя пользователя");
                LOGIC.sortTaxesByIncrease(SCANNER.nextLine());
                break;
            case 3:
                SCANNER.nextLine();
                Person person = new Person();
                System.out.println("введите имя нового пользователя");
                person.setUsername(SCANNER.nextLine());
                LOGIC.addPerson(person);
                System.out.println("пользователь успешно создан");
                break;
            case 4:
                SCANNER.nextLine();
                Income income = new Income();
                System.out.println("Введите название дохода");
                income.setName(SCANNER.nextLine());
                System.out.println("Введщите сумму денег");
                income.setMoney(SCANNER.nextLong());
                System.out.println("введите процент налога");
                income.setTax(SCANNER.nextLong());
                SCANNER.nextLine();
                income.updateMoneyToTax();
                System.out.println("введите имя пользователя");
                LOGIC.addIncomesToPerson(income, SCANNER.nextLine());
                System.out.println("налог успешно добавлен");
                break;
            case 5:
                SCANNER.nextLine();
                LOGIC.printAllPersons();
                break;
            case 6:
                exit(0);
                break;
            default:
                System.out.println("incorrect input!!!");
        }
        readPersonMenu();
        userController();
    }

    public static void init() {
        Income income1 = new Income("на воздух", 3000, 15);
        Income income2 = new Income("на деньги", 50000, 30);
        Income income3 = new Income("на воду", 300, 15);
        List<Income> incomes1 = new ArrayList<>();
        List<Income> incomes2 = new ArrayList<>();
        incomes1.add(income1);
        incomes1.add(income2);
        incomes2.add(income2);
        incomes2.add(income3);
        PERSON_STAGE.addPerson(new Person("андрей", incomes1));
        PERSON_STAGE.addPerson(new Person("вася", incomes2));
    }
}
