
        package com.example.kalend_aral.QUARTER2.PracticalExam;

import java.util.Scanner;

public class MainMenu {

    public void menu(Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("--- KALEND_ARAL ---");
            System.out.println("1. Upcoming Events");
            System.out.println("2. Update Events");
            System.out.println("3. Staff Login");
            System.out.println("4. Keywords");
            System.out.println("5. Delete");
            System.out.println("6. Exit");
            System.out.println("Enter your option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println(option);

            if (option == 1) {
                upcomingEvents.upcomingFeature(scanner);

            } else if (option == 2) {
                updatedEvents.updateFeature(scanner);

            } else if (option == 3) {
                staffPassstaffUserstaffLog.staffFeature(scanner);

            } else if (option == 4) {
                keywordsFeature.keyFeature(scanner);

            } else if (option == 5) {
                deletionFeature.deletionFeature(scanner);

            } else if (option == 6) {
                System.out.println("Exiting menu");
                isRunning = false;

            } else {
                System.out.println("Incorrect choice of option");
            }
        }
    }
}

