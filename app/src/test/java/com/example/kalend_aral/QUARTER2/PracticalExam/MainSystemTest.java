package com.example.kalend_aral.QUARTER2.PracticalExam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MainSystemTest {

    @Test
    public void testCompleteSystemFlow() {

        /*
         * 1. THE VIRTUAL KEYBOARD
         *
         * StringBuilder stores the inputs that a user
         * would normally type into the program.
         */

        StringBuilder simulatedUserInput = new StringBuilder();

        System.out.println("--- GENERATING SIMULATED USER INPUTS ---");


        /*
         * ==========================================
         * INTERACTION #1: ADD EVENT
         * ==========================================
         */

        System.out.println("Generating inputs for Add Event...");

        simulatedUserInput.append("2\n");
        // Main Menu option 2 = Updated Events

        simulatedUserInput.append("admin\n");
        // Admin username

        simulatedUserInput.append("1234\n");
        // Admin password

        simulatedUserInput.append("Foundation Day\n");
        // Event name

        simulatedUserInput.append("January 26, 2026\n");
        // Event date

        simulatedUserInput.append("10:00 AM\n");
        // Event time

        simulatedUserInput.append("MCS School Grounds\n");
        // Event location

        simulatedUserInput.append("Foundation Week Opening\n");
        // Event description


        /*
         * ==========================================
         * INTERACTION #2: UPCOMING EVENTS
         * ==========================================
         */

        System.out.println("Generating inputs for Upcoming Events...");

        simulatedUserInput.append("1\n");
        // Main Menu option 1 = Upcoming Events


        /*
         * ==========================================
         * INTERACTION #3: STAFF LOGIN
         * ==========================================
         */

        System.out.println("Generating inputs for Staff Login...");

        simulatedUserInput.append("3\n");
        // Main Menu option 3 = Staff Login

        simulatedUserInput.append(
                "ArvinandFriendlyNeighborhoodSpiderman\n"
        );
        // Staff username

        simulatedUserInput.append("67676767\n");
        // Staff password

        simulatedUserInput.append(
                "Checked and updated the school calendar.\n"
        );
        // Staff activity/log


        /*
         * ==========================================
         * INTERACTION #4: KEYWORD SEARCH
         * ==========================================
         */

        System.out.println("Generating inputs for Keyword Search...");

        simulatedUserInput.append("4\n");
        // Main Menu option 4 = Keywords

        simulatedUserInput.append("Foundation\n");
        // Keyword to search


        /*
         * ==========================================
         * EXIT COMMAND
         * ==========================================
         *
         * Your updated MainMenu uses option 6 to exit.
         */

        System.out.println("Generating input to Exit the system...");

        simulatedUserInput.append("6\n");
        // Main Menu option 6 = Exit


        System.out.println("--- INPUT GENERATION COMPLETE ---\n");


        /*
         * 2. THE MAGIC CONVERSION
         *
         * Converts the simulated keyboard input
         * into an InputStream.
         */

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        simulatedUserInput.toString().getBytes()
                );


        /*
         * 3. THE AUTOMATED SCANNER
         *
         * Scanner reads the simulated inputs.
         */

        Scanner scanner = new Scanner(inputStream);


        /*
         * 4. RUNNING THE ACTUAL PROGRAM
         *
         * Creates the MainMenu object and runs
         * the actual menu system.
         */

        MainMenu mainSystem = new MainMenu();

        mainSystem.menu(scanner);
    }
}



