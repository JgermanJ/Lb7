package org.l7;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarLogicImpl logic = new CarLogicImpl();
        FileProcessor fileProcessor = new FileProcessor();
        logic.setCars(fileProcessor.readFile());
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("""
                    1-add car;
                    2-show all cars;
                    3-remove car;
                    4-remove all;
                    5-getThisModelCars;
                    6-getCarsExploitedMoreThenThisYear;
                    7-getCarsThisYearWhichPriceMoreThen;           
                    8-sortCarsByPrice;
                    9-modelsCarsInProgrammes;
                    10-mapModels;
                    Chose the number of menu:""");

            switch (scanner.nextInt()) {
                case 0 -> System.exit(0);
                case 1 -> {
                    System.out.println("Enter id");
                    int id = scanner.nextInt();
                    System.out.println("Enter model");
                    String model = scanner.next();
                    System.out.println("Enter create year");
                    LocalDate createYear = LocalDate.of(scanner.nextInt(), 1, 1);
                    System.out.println("Enter price");
                    double price = scanner.nextDouble();
                    System.out.println("Enter winCode");
                    String winCode = scanner.next();

                    logic.addCar(id, model, createYear, price, winCode);
                    fileProcessor.writeFile(logic.getCars());
                }
                case 2 -> logic.showAllCars();
                case 3 -> {
                    System.out.println("Enter id");
                    int id = scanner.nextInt();
                    logic.remove(id);
                    fileProcessor.writeFile(logic.getCars());
                }
                case 4 -> {
                    logic.removeAll();
                    fileProcessor.writeFile(logic.getCars());
                }
                case 5 -> {
                    System.out.println("Enter model");
                    String model = scanner.next();
                    System.out.println(logic.getThisModelCars(model));
                }
                case 6 -> {
                    System.out.println("Enter year");
                    int year = scanner.nextInt();
                    System.out.println(logic.getCarsExploitedMoreThenThisYear(year));
                }
                case 7 -> {
                    System.out.println("Enter year");
                    int year = scanner.nextInt();
                    System.out.println("Enter price");
                    double price = scanner.nextDouble();
                    System.out.println(logic.getCarsThisYearWhichPriceMoreThen(year, price));
                }
                case 8 -> System.out.println(logic.sortCarsByPrice());
                case 9 -> System.out.println(logic.modelsCarsInProgrammes());
                case 10 -> System.out.println(logic.mapModels());
            }
            System.out.println("do u want continue: 1-yes 2-no");
        } while (scanner.nextInt() == 1);
    }
}
