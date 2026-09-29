package com.example.kalend_aral.QUARTER2.PracticalExam;

import java.io.*;
import java.util.Scanner;

public class deletionFeature {

    public static void deletionFeature(Scanner scanner) {

        System.out.println("===== DELETE EVENT =====");

        System.out.print("Enter Event Name to delete: ");
        String deleteInput = scanner.nextLine().trim();

        if (deleteInput.isEmpty()) {
            System.out.println("No input entered.");
            return;
        }

        File inputFile = new File("calendar.txt");
        File tempFile = new File("calendar_temp.txt");

        boolean eventDeleted = false;
        StringBuilder currentEvent = new StringBuilder();

        try (
                BufferedReader reader =
                        new BufferedReader(new FileReader(inputFile));

                BufferedWriter writer =
                        new BufferedWriter(new FileWriter(tempFile))
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.equals("===== EVENT =====")) {
                    currentEvent.setLength(0);
                }

                currentEvent.append(line).append("\n");

                if (line.equals("=================")) {

                    String eventText = currentEvent.toString();

                    if (eventText.toLowerCase().contains(
                            ("Event Name: " + deleteInput).toLowerCase())) {

                        eventDeleted = true;

                    } else {

                        writer.write(eventText);
                    }

                    currentEvent.setLength(0);
                }
            }

            if (eventDeleted) {
                System.out.println(
                        "Event '" + deleteInput +
                                "' deleted successfully."
                );
            } else {
                System.out.println(
                        "Event '" + deleteInput +
                                "' was not found."
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "An error occurred while deleting the event."
            );
        }

        if (eventDeleted) {
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } else {
            tempFile.delete();
        }
    }
}
