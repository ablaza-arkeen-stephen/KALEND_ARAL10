package com.example.kalend_aral.QUARTER2.PracticalExam;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class keywordsFeature {
    public static void keyFeature(Scanner scanner) {
        boolean keyWording = false;
        List<String> listedEvents = new ArrayList<>();

        listedEvents.add("Foundation Day");
        listedEvents.add("Intramurals");
        listedEvents.add("Recognition Day");
        listedEvents.add("Foundation Week Opening");

        System.out.println("--- KEY WORD SEARCH ---");

        while (!keyWording) {
            System.out.println("\nPlease enter a keyword to search: ");
            String keyword = scanner.nextLine().trim();

            if (keyword.isEmpty()) {
                System.out.println("Invalid Keyword input. Try again");
                continue;
            }

            System.out.println("\n--- Search Results ---");
            boolean keywordFound = false;

            for (String event : listedEvents) {
                if (event.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println("- " + event);
                    keywordFound = true;
                }
            }

            if (keywordFound) {
                keyWording = true;
            } else {
                System.out.println("No matching current events found. Try again.");
            }
        }
    }
}
