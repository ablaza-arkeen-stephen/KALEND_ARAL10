package com.example.kalend_aral.QUARTER2.PracticalExam;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class updatedEvents {
    public static void updateFeature(Scanner scanner) {
        // REMOVED: scanner = new Scanner(System.in);
        // Reason: Use the passed scanner parameter instead of overriding it.

        // Admin login
        String adminUsername = "admin";
        String adminPassword = "1234";

        System.out.println("===== CALENDAR SYSTEM =====");

        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();

        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {

            System.out.println("\nLogin successful!");
            System.out.println("===== ADD EVENT =====");

            // Event details stored as String
            System.out.print("Enter event name: ");
            String eventName = scanner.nextLine();

            System.out.print("Enter event date: ");
            String eventDate = scanner.nextLine();

            System.out.print("Enter event time: ");
            String eventTime = scanner.nextLine();

            System.out.print("Enter event location: ");
            String eventLocation = scanner.nextLine();

            System.out.print("Enter event description: ");
            String eventDescription = scanner.nextLine();

            // Store event in a file using try-with-resources
            try (FileWriter file = new FileWriter("calendar.txt", true)) {
                file.write("===== EVENT =====\n");
                file.write("Event Name: " + eventName + "\n");
                file.write("Date: " + eventDate + "\n");
                file.write("Time: " + eventTime + "\n");
                file.write("Location: " + eventLocation + "\n");
                file.write("Description: " + eventDescription + "\n");
                file.write("=================\n\n");

                System.out.println("\nEvent successfully saved!");
                System.out.println("The event was stored in calendar.txt");

            } catch (IOException e) {
                System.out.println("An error occurred while saving the event.");
            }

        } else {
            System.out.println("\nInvalid admin username or password.");
        }

        // REMOVED: scanner.close();
        // Reason: Closing a scanner wrapping System.in kills console input for the entire app.
    }
}