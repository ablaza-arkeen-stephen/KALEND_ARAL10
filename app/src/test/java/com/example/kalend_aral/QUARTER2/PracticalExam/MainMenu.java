package com.example.kalend_aral.QUARTER2.PracticalExam;
import java.util.Scanner;

public class MainMenu {

    public void menu(Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("--- CALENDAR UPDATER ---");
            System.out.println("1. Updated events");
            System.out.println("2. Staff Password, Staff Username, Staff Login");
            System.out.println("3. Keywords");
            System.out.println("4. Delete");
            System.out.println("Enter your options: ");

            int option = scanner.nextInt();
            System.out.println(option);

            if (option == 1) {
                updatedEvents.updateFeature(scanner);

            } else if (option == 2) {
                staffPassstaffUserstaffLog.staffFeature(scanner);
            } else if (option == 3) {
                keywordsFeature.keyFeature(scanner);
            } else if (option == 4) {
                deletionFeature.deletionFeature(scanner);
            } else if (option == 5 ) {
                System.out.println("Exiting menu");
                isRunning = false;
            } else {
                System.out.println("Incorrect choice of option");
            }
        }
    }
}
