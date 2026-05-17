import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JourneyManager journeyManager = new JourneyManager();
        FareCalculator fareCalculator = new FareCalculator();
        InputValidator inputValidator = new InputValidator();
        int menuChoice = 0;

        while (menuChoice != 6) {
            System.out.println(" Welcome to CityRide Lite! Please enter a choice from below: ");
            System.out.println("1. Add Journey");
            System.out.println("2. List Journeys");
            System.out.println("3. View Daily Summary");
            System.out.println("4. Remove Journey");
            System.out.println("5. Reset Day");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            menuChoice = input.nextInt();
            input.nextLine();

            if (menuChoice == 1) {
                System.out.println("N/A");
            } else if (menuChoice == 2) {
                System.out.println("N/A");
            } else if (menuChoice == 3) {
                System.out.println("N/A");
            } else if (menuChoice == 4) {
                System.out.println("N/A");
            } else if (menuChoice == 5) {
                System.out.println("N/A");
            } else if (menuChoice == 6) {
                System.out.println("Thanks for using CityRide Lite! Until next time!");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}