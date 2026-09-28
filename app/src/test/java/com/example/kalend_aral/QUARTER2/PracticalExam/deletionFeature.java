
        package com.example.kalend_aral.QUARTER2.PracticalExam;

import java.util.ArrayList;
import java.util.Scanner;

public class deletionFeature {

    ArrayList<String> eventList = new ArrayList<>();

    // DELETING FEATURE
    public void DeletingComponent(Scanner scanner) {

        boolean isDeleting = true;

        while (isDeleting) {

            System.out.print("Enter Event ID to delete: ");
            String deleteInput = scanner.nextLine();

            if (deleteInput.isEmpty()) {
                System.out.println("No input entered.\nPlease try again.");

            } else if (eventList.contains(deleteInput)) {

                eventList.remove(deleteInput);

                System.out.println(
                        "Event '" + deleteInput + "' deleted successfully.\n"
                );

                isDeleting = false;

            } else {

                System.out.println(
                        "We do not recognize the Event ID.\nPlease try again."
                );
            }
        }
    }
}

