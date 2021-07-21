package view;

import controller.Controller;

import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);
    private final controller.Controller Controller = new Controller();

    public void menu() {
        while (true) {
            System.out.println("Monitor the eating situation of the teachers.");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Add information to file.");
            System.out.println("2. Read file for information. ");
            System.out.println("3. Find the 3 teachers who eat the most cakes. ");
            System.out.println("0. Exit. ");
            System.out.println("----------------------------------------------------");
            System.out.print("Please enter your choice (0-3): ");
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    Controller.saveToFile();
                    break;
                case "2":
                    Controller.readFile();
                    break;
                case "3":
                    Controller.findTop3();
                    break;
                case "0":
                    System.out.println("You have exited the program.");
                    break;
                default:
                    System.out.println("Incorrect choice. Please try again!");
                    break;
            }
            if (choice.equals("0")) {
                break;
            }
            System.out.println();
            input.nextLine();
        }
    }
}