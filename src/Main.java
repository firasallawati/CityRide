import java.util.Scanner;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JourneyManager journeyManager = new JourneyManager();
        FareCalculator fareCalculator = new FareCalculator();
        InputValidator inputValidator = new InputValidator();

        int menuChoice = 0;
        int nextJourneyId = 1;

        while (menuChoice != 8) {
            System.out.println(" Welcome to CityRide Lite! Please enter a choice from below: ");
            System.out.println("1. Add Journey");
            System.out.println("2. List Journeys");
            System.out.println("3. Display Category Counts");
            System.out.println("4. View Daily Summary");
            System.out.println("5. View Totals By Passenger Type");
            System.out.println("6. Remove Journey");
            System.out.println("7. Reset Day");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid choice.");
                input.nextLine();
                System.out.print("Choose an option: ");
            }

            menuChoice = input.nextInt();
            input.nextLine();

            if (menuChoice == 1) {
                String journeyDate;
                String timeBand;
                String passengerType;
                String fromZoneText;
                String toZoneText;
                int fromZone;
                int toZone;
                int zonesCrossed;
                BigDecimal baseFare;
                BigDecimal discountedFare;
                BigDecimal currentTotal;
                BigDecimal chargedFare;

                System.out.print("Enter date: ");
                journeyDate = input.nextLine();

                while (inputValidator.isBlank(journeyDate)) {
                    System.out.println("Date cannot be blank. Please try again.");
                    System.out.print("Enter date: ");
                    journeyDate = input.nextLine();
                }

                System.out.print("Enter time band (Peak or Off-Peak): ");
                timeBand = input.nextLine();

                while (!inputValidator.isValidTimeBand(timeBand)) {
                    System.out.println("Invalid time band. Please try again.");
                    System.out.print("Enter time band (Peak or Off-Peak): ");
                    timeBand = input.nextLine();
                }

                System.out.print("Enter passenger type (Adult, Student, Child, Senior Citizen): ");
                passengerType = input.nextLine();

                while (!inputValidator.isValidPassengerType(passengerType)) {
                    System.out.println("Invalid passenger type. Please try again.");
                    System.out.print("Enter passenger type (Adult, Student, Child, Senior Citizen): ");
                    passengerType = input.nextLine();
                }

                System.out.print("Enter from zone (1-5) : ");
                fromZoneText = input.nextLine();

                while (!inputValidator.isNumeric(fromZoneText) ||
                        !inputValidator.isValidZone(Integer.parseInt(fromZoneText))) {
                    System.out.println("Invalid zone. Please enter a zone from 1-5 and Try Again.");
                    System.out.print("Enter from zone (1-5): ");
                    fromZoneText = input.nextLine();
                }

                fromZone = Integer.parseInt(fromZoneText);

                System.out.print("Enter to zone (1-5): ");
                toZoneText = input.nextLine();

                while (!inputValidator.isNumeric(toZoneText) ||
                        !inputValidator.isValidZone(Integer.parseInt(toZoneText))) {
                    System.out.println("Invalid zone. Please enter a zone from 1-5 and Try Again.");
                    System.out.print("Enter to zone (1-5): ");
                    toZoneText = input.nextLine();
                }

                toZone = Integer.parseInt(toZoneText);

                zonesCrossed = fareCalculator.calculateZonesCrossed(fromZone, toZone);
                baseFare = fareCalculator.calculateBaseFare(fromZone, toZone, timeBand);
                discountedFare = fareCalculator.calculateDiscountedFare(baseFare, passengerType);
                currentTotal = journeyManager.getPassengerChargedTotal(passengerType);
                chargedFare = fareCalculator.calculateChargedFare(discountedFare, passengerType, currentTotal);

                Journey newJourney = new Journey(nextJourneyId, journeyDate, fromZone, toZone, timeBand,
                        passengerType, zonesCrossed, baseFare, discountedFare, chargedFare);

                journeyManager.addJourney(newJourney);

                System.out.println("Journey added successfully.");
                nextJourneyId++;
            } else if (menuChoice == 2) {
                journeyManager.displayAllJourneys();
            } else if (menuChoice == 3) {
                journeyManager.displayCategoryCounts();
            } else if (menuChoice == 4) {
                journeyManager.displayDailySummary();
            } else if (menuChoice == 5) {
                journeyManager.displayTotalsByPassengerType();
            } else if (menuChoice == 6) {
                String journeyIdText;
                int journeyId;
                String confirmRemove;

                System.out.print("Enter journey ID to remove: ");
                journeyIdText = input.nextLine();

                while (!inputValidator.isNumeric(journeyIdText)) {
                    System.out.println("Invalid ID.");
                    System.out.print("Enter journey ID to remove: ");
                    journeyIdText = input.nextLine();
                }

                journeyId = Integer.parseInt(journeyIdText);

                if (journeyManager.findJourneyById(journeyId) == null) {
                    System.out.println("Journey ID not found.");
                }
                else {
                    System.out.print("Are you sure? (yes/no): ");
                    confirmRemove = input.nextLine();

                    if (confirmRemove.equalsIgnoreCase("yes")) {
                        journeyManager.removeJourneyById(journeyId);
                        System.out.println("Journey removed successfully.");
                    }
                    else {
                        System.out.println("Remove cancelled.");
                    }
                }
            }
            else if (menuChoice == 7) {
                String confirmReset;

                System.out.print("Are you sure you want to reset all journeys? (yes/no): ");
                confirmReset = input.nextLine();

                if (confirmReset.equalsIgnoreCase("yes")) {
                    journeyManager.resetJourneys();
                    System.out.println("All journeys have been removed.");
                }
                else {
                    System.out.println("Reset cancelled.");
                }
            }
            else if (menuChoice == 8) {
                System.out.print("Thanks for using the CityRide Lite Program until next time! See you soon!");
            }
            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}