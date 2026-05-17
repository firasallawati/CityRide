import java.util.ArrayList;
import java.util.Scanner;

class Journey { // Gathers one Journey's details and stores it

    // Attributes
    private int journeyId;
    private String journeyDate;
    private int fromZone;
    private int toZone;
    private String timeBand;
    private String passengerType;

    // Constructor
    public Journey(int journeyId, String journeyDate, int fromZone, int toZone, String timeBand, String passengerType) {
        this.journeyId = journeyId;
        this.journeyDate = journeyDate;
        this.fromZone = fromZone;
        this.toZone = toZone;
        this.timeBand = timeBand;
        this.passengerType = passengerType;
    }

    // Get Methods
    public int getJourneyId() {
        return journeyId;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public int getFromZone() {
        return fromZone;
    }

    public int getToZone() {
        return toZone;
    }

    public String getTimeBand() {
        return timeBand;
    }

    public String getPassengerType() {
        return passengerType;
    }

    // Set Methods
    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public void setFromZone(int fromZone) {
        this.fromZone = fromZone;
    }

    public void setToZone(int toZone) {
        this.toZone = toZone;
    }

    public void setTimeBand(String timeBand) {
        this.timeBand = timeBand;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }
}

class JourneyManager { // In charge of the whole list of Journeys stored

    // Attributes
    private ArrayList<Journey> journeys;

    // Constructor
    public JourneyManager() {
        journeys = new ArrayList<>();
    }

    public void addJourney(Journey journey) { // Adds new journey to the array
        System.out.println("Add Journey"); // Not Finished
    }

    public void displayAllJourneys() { // Display stored journeys
        System.out.println("List Journeys"); // Not Finished
    }

    public void removeJourneyById(int journeyId) { // Delete Journey using unique ID
        System.out.println("Remove Journey"); // Not Finished
    }

    public void resetJourneys() { // Delete all stored journeys
        System.out.println("Reset Day"); // Not Finished
    }
}
class FareCalculator { // Calculates fares for journeys (Calculations not done yet)

    // Constructor
    public FareCalculator() {
    }

    public int calculateZonesCrossed(int fromZone, int toZone) {
        int zonesCrossed = 0;
        return zonesCrossed;
    }

    public double calculateBaseFare(int zonesCrossed, String timeBand) {
        double baseFare = 0.0;
        return baseFare;
    }

    public double calculateDiscountedFare(double baseFare, String passengerType) {
        double discountedFare = 0.0;
        return discountedFare;
    }
}

class InputValidator { // Checks if user input is valid

    // Constructor
    public InputValidator() {
    }

    public boolean isValidZone(int zone) {
        boolean isValid = false;

        if (zone >= 1 && zone <= 5) {
            isValid = true;
        }
        return isValid;
    }

    public boolean isValidTimeBand(String timeBand) {
        boolean isValid = false;

        if ("Peak".equalsIgnoreCase(timeBand)) {
            isValid = true;
        } else if ("Off-Peak".equalsIgnoreCase(timeBand)) {
            isValid = true;
        }
        return isValid;
    }

    public boolean isValidPassengerType(String passengerType) {
        boolean isValid = false;

        if (passengerType.equalsIgnoreCase("Adult")) {
            isValid = true;
        } else if (passengerType.equalsIgnoreCase("Student")) {
            isValid = true;
        } else if (passengerType.equalsIgnoreCase("Child")) {
            isValid = true;
        } else if (passengerType.equalsIgnoreCase("Senior Citizen")) {
            isValid = true;
        }
        return isValid;
    }
}

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