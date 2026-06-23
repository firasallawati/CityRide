import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InputValidator inputValidator = new InputValidator();
        JourneyManager journeyManager = new JourneyManager();
        FareCalculator fareCalculator = new FareCalculator();
        ProfileFileManager profileFileManager = new ProfileFileManager();
        ConfigFileManager configFileManager = new ConfigFileManager();
        JourneyCSVHandler journeyCSVHandler = new JourneyCSVHandler();
        ReportGenerator reportGenerator = new ReportGenerator();
        AdminService adminService = new AdminService();

        Config config = configFileManager.loadConfig("config.json");
        RiderProfile riderProfile = null;

        int roleChoice = 0;

        while (roleChoice != 3) {
            System.out.println("Welcome to CityRide Lite");
            System.out.println("1. Rider");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid choice.");
                input.nextLine();
                System.out.print("Choose an option: ");
            }
            roleChoice = input.nextInt();
            input.nextLine();

            if (roleChoice == 1) {
                int riderChoice = 0;

                while (riderChoice != 12) {
                    System.out.println("Rider Menu");
                    System.out.println("1. Create Profile");
                    System.out.println("2. Load Profile");
                    System.out.println("3. Save Profile");
                    System.out.println("4. Add Journey");
                    System.out.println("5. Edit Journey");
                    System.out.println("6. List Journeys");
                    System.out.println("7. Remove Journey");
                    System.out.println("8. Import Journeys CSV");
                    System.out.println("9. Export Journeys CSV");
                    System.out.println("10. Export Reports");
                    System.out.println("11. View Daily Summary");
                    System.out.println("12. Back");
                    System.out.print("Choose an option: ");

                    while (!input.hasNextInt()) {
                        System.out.println("Invalid choice.");
                        input.nextLine();
                        System.out.print("Choose an option: ");
                    }
                    riderChoice = input.nextInt();
                    input.nextLine();

                    if (riderChoice == 1) {
                        String name;
                        String passengerType;
                        String paymentOption;

                        System.out.print("Enter rider name: ");
                        name = input.nextLine();
                        while (inputValidator.isBlank(name)) {
                            System.out.println("Name cannot be blank.");
                            System.out.print("Enter rider name: ");
                            name = input.nextLine();
                        }

                        System.out.print("Enter passenger type exactly as shown (Adult, Student, Child, Senior Citizen): ");
                        passengerType = input.nextLine();
                        while (!inputValidator.isValidPassengerType(passengerType)) {
                            System.out.println("Invalid passenger type. Use exactly: Adult, Student, Child, or Senior Citizen.");
                            System.out.print("Enter passenger type exactly as shown (Adult, Student, Child, Senior Citizen): ");
                            passengerType = input.nextLine();
                        }

                        System.out.print("Enter default payment option exactly as shown (Cash or Card): ");
                        paymentOption = input.nextLine();
                        while (!inputValidator.isValidPaymentOption(paymentOption)) {
                            System.out.println("Invalid payment option. Use exactly: Cash or Card.");
                            System.out.print("Enter default payment option exactly as shown (Cash or Card): ");
                            paymentOption = input.nextLine();
                        }

                        riderProfile = new RiderProfile(name, passengerType, paymentOption);
                        journeyManager.resetJourneys();
                        System.out.println("Profile created successfully.");
                    }
                    else if (riderChoice == 2) {
                        String fileName;

                        System.out.print("Enter profile JSON file name: ");
                        fileName = input.nextLine();
                        riderProfile = profileFileManager.loadProfile(fileName);

                        if (riderProfile != null) {
                            journeyManager.setJourneys(riderProfile.getJourneys());
                            System.out.println("Profile loaded successfully.");
                        }
                    }
                    else if (riderChoice == 3) {
                        String fileName;

                        if (riderProfile == null) {
                            System.out.println("Create or load a profile first.");
                        }
                        else {
                            riderProfile.setJourneys(journeyManager.getJourneys());
                            System.out.print("Enter profile JSON file name: ");
                            fileName = input.nextLine();
                            profileFileManager.saveProfile(riderProfile, fileName);
                        }
                    }
                    else if (riderChoice == 4) {
                        String journeyDate;
                        String timeBand;
                        String fromZoneText;
                        String toZoneText;
                        int fromZone;
                        int toZone;
                        int zonesCrossed;
                        BigDecimal baseFare;
                        BigDecimal discountedFare;
                        BigDecimal currentTotal;
                        BigDecimal chargedFare;
                        int nextJourneyId;

                        if (riderProfile == null) {
                            System.out.println("Create or load a profile first.");
                        }
                        else {
                            nextJourneyId = journeyManager.getJourneys().size() + 1;

                            System.out.print("Enter date/time (example 22/06/2026 18:30): ");
                            journeyDate = input.nextLine();
                            while (inputValidator.isBlank(journeyDate)) {
                                System.out.println("Date/time cannot be blank.");
                                System.out.print("Enter date/time (example 22/06/2026 18:30): ");
                                journeyDate = input.nextLine();
                            }

                            System.out.print("Enter time band (Peak or Off-Peak): ");
                            timeBand = input.nextLine();
                            while (!inputValidator.isValidTimeBand(timeBand)) {
                                System.out.println("Invalid time band.");
                                System.out.print("Enter time band (Peak or Off-Peak): ");
                                timeBand = input.nextLine();
                            }

                            System.out.print("Enter from zone (1 to 5): ");
                            fromZoneText = input.nextLine();
                            while (!inputValidator.isNumeric(fromZoneText) || !inputValidator.isValidZone(Integer.parseInt(fromZoneText))) {
                                System.out.println("Invalid zone.");
                                System.out.print("Enter from zone (1 to 5): ");
                                fromZoneText = input.nextLine();
                            }
                            fromZone = Integer.parseInt(fromZoneText);

                            System.out.print("Enter to zone (1 to 5): ");
                            toZoneText = input.nextLine();
                            while (!inputValidator.isNumeric(toZoneText) || !inputValidator.isValidZone(Integer.parseInt(toZoneText))) {
                                System.out.println("Invalid zone.");
                                System.out.print("Enter to zone (1 to 5): ");
                                toZoneText = input.nextLine();
                            }
                            toZone = Integer.parseInt(toZoneText);

                            zonesCrossed = fareCalculator.calculateZonesCrossed(fromZone, toZone);
                            baseFare = fareCalculator.calculateBaseFare(fromZone, toZone, timeBand, config);
                            discountedFare = fareCalculator.calculateDiscountedFare(baseFare, riderProfile.getPassengerType(), config);
                            currentTotal = journeyManager.getPassengerChargedTotal(riderProfile.getPassengerType());
                            chargedFare = fareCalculator.calculateChargedFare(discountedFare, riderProfile.getPassengerType(), currentTotal, config);

                            Journey newJourney = new Journey(nextJourneyId, journeyDate, fromZone, toZone, timeBand,
                                    riderProfile.getPassengerType(), zonesCrossed, baseFare, discountedFare, chargedFare);

                            journeyManager.addJourney(newJourney);
                            System.out.println("Journey added successfully.");
                        }
                    }
                    else if (riderChoice == 5) {
                        String journeyIdText;
                        int journeyId;
                        Journey oldJourney;
                        String journeyDate;
                        String timeBand;
                        String fromZoneText;
                        String toZoneText;
                        int fromZone;
                        int toZone;
                        int zonesCrossed;
                        BigDecimal baseFare;
                        BigDecimal discountedFare;
                        BigDecimal currentTotalWithoutOld;
                        BigDecimal chargedFare;
                        Journey updatedJourney;

                        if (riderProfile == null) {
                            System.out.println("Create or load a profile first.");
                        }
                        else {
                            System.out.print("Enter journey ID to edit: ");
                            journeyIdText = input.nextLine();
                            while (!inputValidator.isNumeric(journeyIdText)) {
                                System.out.println("Invalid ID.");
                                System.out.print("Enter journey ID to edit: ");
                                journeyIdText = input.nextLine();
                            }
                            journeyId = Integer.parseInt(journeyIdText);

                            oldJourney = journeyManager.findJourneyById(journeyId);

                            if (oldJourney == null) {
                                System.out.println("Journey ID not found.");
                            }
                            else {
                                System.out.print("Enter new date/time (example 22/06/2026 18:30): ");
                                journeyDate = input.nextLine();
                                while (inputValidator.isBlank(journeyDate)) {
                                    System.out.println("Date/time cannot be blank.");
                                    System.out.print("Enter new date/time (example 22/06/2026 18:30): ");
                                    journeyDate = input.nextLine();
                                }

                                System.out.print("Enter new time band (Peak or Off-Peak): ");
                                timeBand = input.nextLine();
                                while (!inputValidator.isValidTimeBand(timeBand)) {
                                    System.out.println("Invalid time band.");
                                    System.out.print("Enter new time band (Peak or Off-Peak): ");
                                    timeBand = input.nextLine();
                                }

                                System.out.print("Enter new from zone (1 to 5): ");
                                fromZoneText = input.nextLine();
                                while (!inputValidator.isNumeric(fromZoneText) || !inputValidator.isValidZone(Integer.parseInt(fromZoneText))) {
                                    System.out.println("Invalid zone.");
                                    System.out.print("Enter new from zone (1 to 5): ");
                                    fromZoneText = input.nextLine();
                                }
                                fromZone = Integer.parseInt(fromZoneText);

                                System.out.print("Enter new to zone (1 to 5): ");
                                toZoneText = input.nextLine();
                                while (!inputValidator.isNumeric(toZoneText) || !inputValidator.isValidZone(Integer.parseInt(toZoneText))) {
                                    System.out.println("Invalid zone.");
                                    System.out.print("Enter new to zone (1 to 5): ");
                                    toZoneText = input.nextLine();
                                }
                                toZone = Integer.parseInt(toZoneText);

                                zonesCrossed = fareCalculator.calculateZonesCrossed(fromZone, toZone);
                                baseFare = fareCalculator.calculateBaseFare(fromZone, toZone, timeBand, config);
                                discountedFare = fareCalculator.calculateDiscountedFare(baseFare, riderProfile.getPassengerType(), config);

                                currentTotalWithoutOld = journeyManager.getPassengerChargedTotal(riderProfile.getPassengerType())
                                        .subtract(oldJourney.getChargedFare());

                                chargedFare = fareCalculator.calculateChargedFare(
                                        discountedFare,
                                        riderProfile.getPassengerType(),
                                        currentTotalWithoutOld,
                                        config
                                );

                                updatedJourney = new Journey(
                                        journeyId,
                                        journeyDate,
                                        fromZone,
                                        toZone,
                                        timeBand,
                                        riderProfile.getPassengerType(),
                                        zonesCrossed,
                                        baseFare,
                                        discountedFare,
                                        chargedFare
                                );

                                if (journeyManager.editJourney(journeyId, updatedJourney)) {
                                    System.out.println("Journey updated successfully.");
                                }
                                else {
                                    System.out.println("Journey update failed.");
                                }
                            }
                        }
                    }
                    else if (riderChoice == 6) {
                        journeyManager.displayAllJourneys();
                    }
                    else if (riderChoice == 7) {
                        String journeyIdText;
                        int journeyId;

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
                            journeyManager.removeJourneyById(journeyId);
                            System.out.println("Journey removed successfully.");
                        }
                    }
                    else if (riderChoice == 8) {
                        String fileName;

                        System.out.print("Enter CSV file name to import: ");
                        fileName = input.nextLine();
                        journeyCSVHandler.importJourneys(fileName, journeyManager);
                    }
                    else if (riderChoice == 9) {
                        String fileName;

                        System.out.print("Enter CSV file name to export: ");
                        fileName = input.nextLine();
                        journeyCSVHandler.exportJourneys(fileName, journeyManager);
                    }
                    else if (riderChoice == 10) {
                        String reportLabel;
                        String reportDate;
                        String riderNameSafe;
                        String csvFileName;
                        String textFileName;

                        if (riderProfile == null) {
                            System.out.println("Create or load a profile first.");
                        }
                        else {
                            System.out.print("Enter report label (example day1): ");
                            reportLabel = input.nextLine();
                            while (inputValidator.isBlank(reportLabel)) {
                                System.out.println("Report label cannot be blank.");
                                System.out.print("Enter report label (example day1): ");
                                reportLabel = input.nextLine();
                            }

                            System.out.print("Enter report date (example 23-06-2026): ");
                            reportDate = input.nextLine();
                            while (inputValidator.isBlank(reportDate)) {
                                System.out.println("Report date cannot be blank.");
                                System.out.print("Enter report date (example 23-06-2026): ");
                                reportDate = input.nextLine();
                            }

                            riderNameSafe = riderProfile.getName().replace(" ", "_");

                            csvFileName = "reports/" + reportLabel + ".csv";
                            textFileName = "reports/" + riderNameSafe + "_" + reportDate + "_" + reportLabel + ".txt";

                            reportGenerator.exportSummaryCsv(csvFileName, riderProfile, journeyManager);
                            reportGenerator.exportSummaryText(textFileName, riderProfile, journeyManager);
                        }
                    }
                    else if (riderChoice == 11) {
                        journeyManager.displayDailySummary();
                        journeyManager.displayTotalsByPassengerType();
                        journeyManager.displayCategoryCounts();
                    }
                    else if (riderChoice == 12) {
                        String saveChoice;

                        if (riderProfile != null) {
                            System.out.print("Save current profile and journeys before leaving rider menu? (yes/no): ");
                            saveChoice = input.nextLine();

                            while (!inputValidator.isYesNo(saveChoice)) {
                                System.out.println("Invalid answer. Enter yes or no.");
                                System.out.print("Save current profile and journeys before leaving rider menu? (yes/no): ");
                                saveChoice = input.nextLine();
                            }

                            if (saveChoice.equalsIgnoreCase("yes")) {
                                riderProfile.setJourneys(journeyManager.getJourneys());
                                profileFileManager.saveProfile(riderProfile, riderProfile.getName() + ".json");
                            }
                        }
                    }
                    else {
                        System.out.println("Invalid choice.");
                    }
                }
            }
            else if (roleChoice == 2) {
                String password;
                int adminChoice = 0;

                System.out.print("Enter admin password (admin123) : ");
                password = input.nextLine();

                if (adminService.login(password, config)) {
                    while (adminChoice != 7) {
                        System.out.println("Admin Menu");
                        System.out.println("1. View Config");
                        System.out.println("2. Update Passenger Discount");
                        System.out.println("3. Update Daily Cap");
                        System.out.println("4. Update Base Fare");
                        System.out.println("5. Add Peak Window");
                        System.out.println("6. Save Config");
                        System.out.println("7. Back");
                        System.out.print("Choose an option: ");

                        while (!input.hasNextInt()) {
                            System.out.println("Invalid choice.");
                            input.nextLine();
                            System.out.print("Choose an option: ");
                        }
                        adminChoice = input.nextInt();
                        input.nextLine();

                        if (adminChoice == 1) {
                            adminService.displayConfig(config);
                        }
                        else if (adminChoice == 2) {
                            String passengerType;
                            String discountText;

                            System.out.print("Enter passenger type exactly as shown (Adult, Student, Child, Senior Citizen): ");
                            passengerType = input.nextLine();
                            while (!inputValidator.isValidPassengerType(passengerType)) {
                                System.out.println("Invalid passenger type. Use exactly: Adult, Student, Child, or Senior Citizen.");
                                System.out.print("Enter passenger type exactly as shown (Adult, Student, Child, Senior Citizen): ");
                                passengerType = input.nextLine();
                            }

                            System.out.print("Enter discount as decimal (example 0.25): ");
                            discountText = input.nextLine();
                            while (!inputValidator.isValidDiscountDecimal(discountText)) {
                                System.out.println("Invalid discount value. Enter a number from 0 to 1.");
                                System.out.print("Enter discount as decimal (example 0.25): ");
                                discountText = input.nextLine();
                            }

                            adminService.updatePassengerDiscount(config, passengerType, new BigDecimal(discountText));
                        }
                        else if (adminChoice == 3) {
                            String passengerType;
                            String capText;

                            System.out.print("Enter passenger type exactly as shown (Adult, Student, Child, Senior Citizen): ");
                            passengerType = input.nextLine();
                            while (!inputValidator.isValidPassengerType(passengerType)) {
                                System.out.println("Invalid passenger type. Use exactly: Adult, Student, Child, or Senior Citizen.");
                                System.out.print("Enter passenger type exactly as shown (Adult, Student, Child, Senior Citizen): ");
                                passengerType = input.nextLine();
                            }

                            System.out.print("Enter daily cap (example 8.00): ");
                            capText = input.nextLine();
                            while (!inputValidator.isPositiveDecimal(capText)) {
                                System.out.println("Invalid daily cap.");
                                System.out.print("Enter daily cap (example 8.00): ");
                                capText = input.nextLine();
                            }

                            adminService.updateDailyCap(config, passengerType, new BigDecimal(capText));
                        }
                        else if (adminChoice == 4) {
                            String fareKey;
                            String fareText;

                            System.out.print("Enter fare key (example 1-2-Peak or 1-2-Off-Peak): ");
                            fareKey = input.nextLine();
                            while (!inputValidator.isValidFareKey(fareKey)) {
                                System.out.println("Invalid fare key.");
                                System.out.print("Enter fare key (example 1-2-Peak or 1-2-Off-Peak): ");
                                fareKey = input.nextLine();
                            }

                            System.out.print("Enter fare amount (example 3.20): ");
                            fareText = input.nextLine();
                            while (!inputValidator.isPositiveDecimal(fareText)) {
                                System.out.println("Invalid fare.");
                                System.out.print("Enter fare amount (example 3.20): ");
                                fareText = input.nextLine();
                            }

                            adminService.updateBaseFare(config, fareKey, new BigDecimal(fareText));
                        }
                        else if (adminChoice == 5) {
                            String peakWindow;

                            System.out.print("Enter peak window (example 06:30-09:30): ");
                            peakWindow = input.nextLine();
                            while (!inputValidator.isValidPeakWindow(peakWindow)) {
                                System.out.println("Invalid peak window.");
                                System.out.print("Enter peak window (example 06:30-09:30): ");
                                peakWindow = input.nextLine();
                            }

                            adminService.addPeakWindow(config, peakWindow);
                        }
                        else if (adminChoice == 6) {
                            configFileManager.saveConfig(config, "config.json");
                        }
                        else if (adminChoice == 7) {
                            System.out.println("Leaving admin menu.");
                        }
                        else {
                            System.out.println("Invalid choice.");
                        }
                    }
                }
                else {
                    System.out.println("Incorrect password.");
                }
            }
            else if (roleChoice == 3) {
                if (riderProfile != null) {
                    String saveChoice;
                    System.out.print("Save current day state before exit? (yes/no): ");
                    saveChoice = input.nextLine();

                    while (!inputValidator.isYesNo(saveChoice)) {
                        System.out.println("Invalid answer. Enter yes or no.");
                        System.out.print("Save current day state before exit? (yes/no): ");
                        saveChoice = input.nextLine();
                    }

                    if (saveChoice.equalsIgnoreCase("yes")) {
                        riderProfile.setJourneys(journeyManager.getJourneys());
                        profileFileManager.saveProfile(riderProfile, riderProfile.getName() + ".json");
                    }
                }

                System.out.println("Thanks for using CityRide Lite! Until next time!");
            }
            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}