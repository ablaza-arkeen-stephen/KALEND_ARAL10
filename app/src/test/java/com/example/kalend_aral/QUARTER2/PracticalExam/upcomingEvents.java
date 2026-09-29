package com.example.kalend_aral.QUARTER2.PracticalExam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class upcomingEvents {

    public static void upcomingFeature(Scanner scanner) {

        System.out.println("===== UPCOMING EVENTS =====");

        boolean eventFoundAny = false;
        boolean readingEvent = false;

        try (BufferedReader reader = new BufferedReader(
                new FileReader("calendar.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.equals("===== EVENT =====")) {
                    eventFoundAny = true;
                    readingEvent = true;
                    System.out.println();
                }

                if (readingEvent) {
                    System.out.println(line);
                }

                if (line.equals("=================")) {
                    readingEvent = false;
                }
            }

            if (!eventFoundAny) {
                System.out.println("No upcoming events found.");
            }

        } catch (IOException e) {
            System.out.println("No events available yet.");
        }
    }
}



