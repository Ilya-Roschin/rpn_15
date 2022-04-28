package com.java.laba;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logic LOGIC = new Logic();

    public static void main(String[] args) {

        while (true) {
            try {
                readPersonMenu();
                userController();
            } catch (CustomFileException fileException) {
                System.out.println("File exception");
                SCANNER.nextLine();
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

    public static void userController() throws PersonNotFoundedException, CustomFileException {
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
}
