package com.example.kalend_aral.QUARTER2.PracticalExam;
import java.util.Scanner;

public class staffPassstaffUserstaffLog {
    public static void staffFeature(Scanner scanner) {
        String correctUser = "ArvinandFriendlyNeighborhoodSpiderman";
        String correctPass = "67676767";

        System.out.println("--- STAFF LOG IN MENU ---");

        System.out.print("Enter Staff User: ");
        String user = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();


        if (user.equals(correctUser) && password.equals(correctPass)) {
            System.out.println("\nWelcome, " + user);

            System.out.println("\n=== STAFF LOG ENTRY ===");
            System.out.print("Enter activity/log to record: ");
            String logEntry = scanner.nextLine();

            if (!logEntry.trim().isEmpty()) {
                System.out.println("\n[LOG SAVED]: " + logEntry);
            } else {
                System.out.println("\nEmpty log entry was not saved.");
            }

        } else {
            System.out.println("\nInvalid username or password. Access denied.");
        }
    }
}

