# IY4113 - Part 1 Final Submission

| Assessment Details | Please Complete All Details                                           |
| ------------------ | --------------------------------------------------------------------- |
| Group              | A                                                                     |
| Module Title       | IY4113 Applied Software Engineering using Object-Oriented Programming |
| Assessment Type    | Java Fundamentals Part 1 Final Submission                             |
| Module Tutor Name  | Jonathan Shore                                                        |
| Student ID Number  | P466146                                                               |
| Date of Submission | 31/05/2026                                                            |
| Word Count         | 860                                                                   |
| GItHub Link        | https://github.com/firasallawati/T0466146_Firas_4113                  |

- [x] *I confirm that this assignment is my own work. Where I have referred to academic sources, I have provided in-text citations and included the sources in  
    the final reference list.*

- [x] *Where I have used AI, I have cited and referenced appropriately.*

---

## Introduction

The task requires developing a console application that helps a user in keeping track of their public transportation trips during one day. In this regard, the application should provide users with an ability to input journey data such as starting zone, destination zone, peak or off-peak time band, and type of passenger. Based off of the info inputted by the user, the application will determine the number of zones passed, find the base fare rate using a provided dataset, and apply discounts based on passengers' discounts. The application should also impose daily spending caps for different types of passengers, and charge as necessary.

All trip data should only be held in memory and not stored anywhere else such as on a file. Users will navigate the application through a numbered menu system that will run repeatedly until a user decides to close it. The application should have capabilities of adding, listing, searching, deleting, resetting and summarizing journeys as well as determining total and category counts within a day. Input validation is very important since the application should only accept valid input otherwise the process should be repeated without exiting the application.

By the end of this assignment, the aim is to have produced a fully working travel companion software that accurately computes fare prices, applies discounts and caps, stores the journey data in its memory, and generates useful data for the user which is all done within a single day's session. The software should be a good demonstration of the principles of object-oriented programming in the Java language, which will make use of many classes.

---

## Analysis

The major requirement of this project is to build a console-based Java application that records, manages, and summarises public transport journeys for a single day using information inputted by the user. The system must be entirely menu-driven, storing all data in memory during the session with no file handling required.

The following key functional requirements were identified from the assignment brief:

- The system must display a main menu with eight options: add journey, list journeys, filter journeys, view daily summary, view totals by passenger type, remove journey, reset day, and exit and has to be looping until the user selects exit.

- When adding a journey, the system must capture: date, time band (peak or off-peak), passenger type (adult, student, child, or senior citizen), from zone, and to zone (zones 1–5). Each journey must be assigned a unique session ID.

- The system must calculate zones crossed using the formula: abs(toZone − fromZone) + 1, look up the correct base fare from the CityRideDataset, and apply the relevant passenger discount (Adult 0%, Student 25%, Child 50%, Senior Citizen 30%).

- The system must enforce daily spending caps (Adult £8.00, Student £6.00, Child £4.00, Senior Citizen £7.00). If a journey would exceed the cap, the fare is reduced to meet it exactly. Any further journeys for that passenger type are charged £0.

- The system must allow filtering of journeys by passenger type, time band, zone, and date.

- The system must display a daily summary showing total journeys, total cost charged, average cost per journey, and the most expensive journey, as well as category counts for peak vs off-peak and per zone.

- The system must display totals broken down by each passenger type, including journey count and whether the daily cap was reached.

- The system must allow a journey to be removed by ID (with error handling for invalid IDs) and allow a full day reset, both requiring a confirmation prompt.

- All inputs must be validated, with the program re-prompting on invalid entries rather than crashing. All monetary values must be rounded to 2 decimal places.  

  ![](IPO.png)

---

## Algorithm Design

**FlowChart:**
![](Flow.png)

**Subprocesses:**
<img title="" src="Flow1.PNG" alt="" width="242">

<img title="" src="Flow2.PNG" alt="" width="246">

<img title="" src="Flow3.PNG" alt="" width="295">

<img src="Flow4.PNG" title="" alt="" width="202">

<img src="Flow5.PNG" title="" alt="" width="274">

**Class Diagram:**

![](Class_Diagram.PNG)

---

## Testing

**Testing Table:**

| Test Number | Item to Test                      | Test Description (With example)                 | Expected Result                                                                                                                                            | Actual Result                                                         | Comments                                                                                        |
| ----------- | --------------------------------- | ----------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| 1           | menuChoice = input.nextInt();     | Valid data: enter 1                             | System accepts the input and opens the Add Journey section.                                                                                                | System accepted the input and opened the Add Journey section.         | No comment                                                                                      |
| 2           | menuChoice = input.nextInt();     | Invalid data: enter 9                           | System rejects the input and displays “Invalid choice.”                                                                                                    | System rejected the input and displayed “Invalid choice.”             | No comment                                                                                      |
| 3           | menuChoice = input.nextInt();     | Erroneous data: enter abc                       | System should not crash and should ask the user to enter a valid number.                                                                                   | System displayed an invalid choice error and asked for another input. | No comment                                                                                      |
| 4           | menuChoice = input.nextInt();     | Edge case: enter 8                              | System exits the program.                                                                                                                                  | System exited the program successfully.                               | No comment                                                                                      |
| 5           | journeyDate = input.nextLine();   | Valid data: enter 31/05/2026                    | System accepts the date and continues to the next input.                                                                                                   | System accepted the date and continued.                               | No comment                                                                                      |
| 6           | journeyDate = input.nextLine();   | Invalid data: enter a blank input               | System displays “Date cannot be blank.” and re-prompts.                                                                                                    | System displayed the blank input error and re-prompted.               | No comment                                                                                      |
| 7           | journeyDate = input.nextLine();   | Erroneous data: enter !@#                       | System should accept only a non-blank value and continue.                                                                                                  | System accepted the text as input.                                    | Weak validation: the program accepts non-date text because it only checks for blank input.      |
| 8           | journeyDate = input.nextLine();   | Edge case: enter a very long date string        | System should still store the input without crashing.                                                                                                      | System stored the input without crashing.                             | The program accepts long text, but it does not validate whether the date is in a proper format. |
| 9           | timeBand = input.nextLine();      | Valid data: enter Peak                          | System accepts the input as a valid time band.                                                                                                             | System accepted the input.                                            | No comment                                                                                      |
| 10          | timeBand = input.nextLine();      | Invalid data: enter Morning                     | System displays “Invalid time band.” and re-prompts.                                                                                                       | System displayed the invalid time band message and re-prompted.       | No comment                                                                                      |
| 11          | timeBand = input.nextLine();      | Erroneous data: enter 123                       | System rejects the input and asks again.                                                                                                                   | System rejected the input and asked again.                            | No comment                                                                                      |
| 12          | timeBand = input.nextLine();      | Edge case: enter off-peak                       | System accepts the input regardless of case.                                                                                                               | System accepted the input regardless of case.                         | No comment                                                                                      |
| 13          | passengerType = input.nextLine(); | Valid data: enter Adult                         | System accepts the passenger type.                                                                                                                         | System accepted the passenger type.                                   | No comment                                                                                      |
| 14          | passengerType = input.nextLine(); | Invalid data: enter Worker                      | System displays “Invalid passenger type.” and re-prompts.                                                                                                  | System displayed the invalid passenger type message and re-prompted.  | No comment                                                                                      |
| 15          | passengerType = input.nextLine(); | Erroneous data: enter ###                       | System rejects the input and asks again.                                                                                                                   | System rejected the input and asked again.                            | No comment                                                                                      |
| 16          | passengerType = input.nextLine(); | Edge case: enter senior citizen                 | System accepts the input regardless of letter case.                                                                                                        | System accepted the input regardless of letter case.                  | No comment                                                                                      |
| 17          | fromZoneText = input.nextLine();  | Valid data: enter 1                             | System accepts the input and stores the from zone.                                                                                                         | System accepted the input and stored the from zone.                   | No comment                                                                                      |
| 18          | fromZoneText = input.nextLine();  | Invalid data: enter 6                           | System displays “Invalid zone.” and re-prompts.                                                                                                            | System displayed the invalid zone message and re-prompted.            | No comment                                                                                      |
| 19          | fromZoneText = input.nextLine();  | Erroneous data: enter A                         | System rejects the input and asks for a numeric zone.                                                                                                      | System rejected the input and asked again.                            | No comment                                                                                      |
| 20          | fromZoneText = input.nextLine();  | Edge case: enter 5                              | System accepts the highest valid zone value.                                                                                                               | System accepted the highest valid zone value.                         | No comment                                                                                      |
| 21          | toZoneText = input.nextLine();    | Valid data: enter 3                             | System accepts the input and stores the to zone.                                                                                                           | System accepted the input and stored the to zone.                     | No comment                                                                                      |
| 22          | toZoneText = input.nextLine();    | Invalid data: enter 0                           | System displays “Invalid zone.” and re-prompts.                                                                                                            | System displayed the invalid zone message and re-prompted.            | No comment                                                                                      |
| 23          | toZoneText = input.nextLine();    | Erroneous data: enter xyz                       | System rejects the input and asks for a numeric zone.                                                                                                      | System rejected the input and asked again.                            | No comment                                                                                      |
| 24          | toZoneText = input.nextLine();    | Edge case: enter 5                              | System accepts the highest valid zone value.                                                                                                               | System accepted the highest valid zone value.                         | No comment                                                                                      |
| 25          | journeyIdText = input.nextLine(); | Valid data: enter 2                             | System accepts the journey ID for removal.                                                                                                                 | System accepted the journey ID.                                       | No comment                                                                                      |
| 26          | journeyIdText = input.nextLine(); | Invalid/Valid data: enter 99                    | System displays “Journey ID not found”, however, if the Journey ID "99" was entered when adding a journey then it would accept it, otherwise it would not. | System displayed “Journey ID not found.”                              | No comment                                                                                      |
| 27          | journeyIdText = input.nextLine(); | Erroneous data: enter !!!                       | System rejects the input and re-prompts for a valid number.                                                                                                | System rejected the input and re-prompted.                            | No comment                                                                                      |
| 28          | journeyIdText = input.nextLine(); | Edge case: enter 1 when only one journey exists | System removes the journey if the user confirms.                                                                                                           | System removed the journey after confirmation.                        | No comment                                                                                      |
| 29          | confirmRemove = input.nextLine(); | Valid data: enter yes                           | System removes the selected journey.                                                                                                                       | System removed the selected journey.                                  | No comment                                                                                      |
| 30          | confirmRemove = input.nextLine(); | Invalid data: enter no                          | System cancels the removal.                                                                                                                                | System cancelled the removal.                                         | No comment                                                                                      |
| 31          | confirmRemove = input.nextLine(); | Erroneous data: enter maybe                     | System should reject the response and ask again, but the program may treat it as cancellation.                                                             | System treated the response as cancellation.                          | The program does not properly validate confirmation responses beyond “yes”.                     |
| 32          | confirmRemove = input.nextLine(); | Erroneous data: enter 123                       | System should reject the response and ask again.                                                                                                           | System treated the response as cancellation.                          | The program does not properly validate confirmation responses beyond “yes”.                     |
| 33          | confirmReset = input.nextLine();  | Valid data: enter yes                           | System clears all journeys from memory.                                                                                                                    | System cleared all journeys from memory.                              | No comment                                                                                      |
| 34          | confirmReset = input.nextLine();  | Invalid data: enter no                          | System cancels the reset.                                                                                                                                  | System cancelled the reset.                                           | No comment                                                                                      |
| 35          | confirmReset = input.nextLine();  | Erroneous data: enter maybe                     | System should reject the response and ask again, but the program may treat it as cancellation.                                                             | System treated the response as cancellation.                          | The program does not properly validate confirmation responses beyond “yes”.                     |
| 36          | confirmReset = input.nextLine();  | Erroneous data: enter 123                       | System should reject the response and ask again.                                                                                                           | System treated the response as cancellation.                          | The program does not properly validate confirmation responses beyond “yes”.                     |

---

## Evaluation

The program fulfills almost all of the essential needs of the task assignment, especially the core aspects which include managing journeys and calculating their fares. The program allows the user to create a journey, save it in memory, calculate the fare, apply discounts and caps, show summaries, deletes a specified journey, and can reset the whole session. However, it does not fully meet the filtering requirement because the completed code only filters journeys by peak/off-peak and zone areas used, rather than all the required filter categories.

##### Strengths

1. **Journey management works well.**    
      The program can add, store, list, and remove journeys during the session, which matches the main purpose of the application.

2. **Fare calculation is implemented correctly.**    
      The program uses the dataset to calculate fares, apply discounts, and respect the daily cap, which is one of the most important parts of the assignment.

3. **The summary output is useful.**    
      The program gives totals and passenger-type breakdowns, which helps the user understand spending and journey patterns.

##### Weaknesses

- **The `Main` class is too large and handles too much of the program logic.**    
    This is a weakness because input handling, menu control, validation flow, and program actions are all placed inside one class, which makes the code harder to read, test, and maintain.

##### Areas For Improvement

- Add full filtering by passenger type, time band, zone, and date.

- Expand totals by passenger type to show pre-discount totals, discounted totals, charged totals after cap, and cap reached status.

---

## Code Listing

**Main.java:**

import java.math.BigDecimal;

import java.util.Scanner;

public class Main {

    public static void  
main(String[] args) {

        Scanner input  
= new Scanner(System.in);

        JourneyManager  
journeyManager = new JourneyManager();

        FareCalculator  
fareCalculator = new FareCalculator();

        InputValidator  
inputValidator = new InputValidator();

        int menuChoice  
= 0;

        int  
nextJourneyId = 1;

        while  
(menuChoice != 8) {

            System.out.println(" Welcome to CityRide Lite! Please enter a  
choice from below: ");

            System.out.println("1. Add Journey");

            System.out.println("2. List Journeys");

            System.out.println("3. Display Category Counts");

            System.out.println("4. View Daily Summary");

            System.out.println("5. View Totals by Passenger Type");

            System.out.println("6. Remove Journey");

            System.out.println("7. Reset Day");

            System.out.println("8. Exit");

            System.out.print("Choose an option: ");

            while  
(!input.hasNextInt()) {

                System.out.println("Invalid choice.");

                input.nextLine();

                System.out.print("Choose an option: ");

            }

            menuChoice  
= input.nextInt();

            input.nextLine();

            if  
(menuChoice == 1) {

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

                while  
(inputValidator.isBlank(journeyDate)) {

                    System.out.println("Date cannot be blank.");

                    System.out.print("Enter date: ");

                    journeyDate = input.nextLine();

                }

                System.out.print("Enter time band (Peak or Off-Peak): ");

                timeBand = input.nextLine();

                while  
(!inputValidator.isValidTimeBand(timeBand)) {

                    System.out.println("Invalid time band.");

                    System.out.print("Enter time band (Peak or Off-Peak): ");

                    timeBand = input.nextLine();

                }

                System.out.print("Enter passenger type (Adult, Student, Child,  
Senior Citizen): ");

                passengerType = input.nextLine();

                while  
(!inputValidator.isValidPassengerType(passengerType)) {

                    System.out.println("Invalid passenger type.");

                    System.out.print("Enter passenger type (Adult, Student, Child,  
Senior Citizen): ");

                    passengerType = input.nextLine();

                }

                System.out.print("Enter from zone: ");

                fromZoneText = input.nextLine();

                while

// **Runestone (n.d.)**  
(!inputValidator.isNumeric(fromZoneText) <mark>||</mark>

// **Oracle (n.d.) Integer.parseInt()**

                        !inputValidator.isValidZone<mark>(Integer.parseInt</mark>(fromZoneText))) {

                    System.out.println("Invalid zone.");

                    System.out.print("Enter from zone: ");

                    fromZoneText = input.nextLine();

                }

// **Oracle (n.d.) Integer.parseInt()**

                fromZone = <mark>Integer.parseInt</mark>(fromZoneText);

                System.out.print("Enter to zone: ");

                toZoneText = input.nextLine();

                while

**// Runestone (n.d.)**  
(!inputValidator.isNumeric(toZoneText) <mark>||</mark>

// **Oracle (n.d.) Integer.parseInt()**

                        !inputValidator.isValidZone(<mark>Integer.parseInt</mark>(toZoneText))) {

                    System.out.println("Invalid zone.");

                    System.out.print("Enter to zone: ");

                    toZoneText = input.nextLine();

                }

                toZone

//  **Oracle (n.d.) Integer.parseInt()**  
= <mark>Integer.parseInt</mark>(toZoneText);

                zonesCrossed = fareCalculator.calculateZonesCrossed(fromZone, toZone);

                baseFare = fareCalculator.calculateBaseFare(fromZone, toZone, timeBand);

                discountedFare = fareCalculator.calculateDiscountedFare(baseFare, passengerType);

                currentTotal = journeyManager.getPassengerChargedTotal(passengerType);

                chargedFare = fareCalculator.calculateChargedFare(discountedFare,  
passengerType, currentTotal);

                Journey newJourney = new Journey(nextJourneyId, journeyDate, fromZone,  
toZone, timeBand, passengerType, zonesCrossed, baseFare, discountedFare, chargedFare);

                journeyManager.addJourney(newJourney);

                System.out.println("Journey added successfully.");

                nextJourneyId++;

            }

            else if  
(menuChoice == 2) {

                journeyManager.listAllJourneys();

            }

            else if  
(menuChoice == 3) {

                journeyManager.displayCategoryCounts();

            }

            else if  
(menuChoice == 4) {

                journeyManager.displayDailySummary();

            }

            else if  
(menuChoice == 5) {

                journeyManager.displayTotalsByPassengerType();

            }

            else if  
(menuChoice == 6) {

                String  
journeyIdText;

                int  
journeyId;

                String  
confirmRemove;

                System.out.print("Enter journey ID to remove: ");

                journeyIdText = input.nextLine();

                while  
(!inputValidator.isNumeric(journeyIdText)) {

                    System.out.println("Invalid ID.");

                    System.out.print("Enter journey ID to remove: ");

                    journeyIdText = input.nextLine();

                }

// **Oracle (n.d.) Integer.parseInt()**

                journeyId = <mark>Integer.parseInt</mark>(journeyIdText);

                if  
(journeyManager.findJourneyById(journeyId) == null) {

                    System.out.println("Journey ID not found.");

                }

                else {

                    System.out.print("Are you sure? (yes/no): ");

                    confirmRemove = input.nextLine();

                    if  
(confirmRemove.equalsIgnoreCase("yes")) {

                        journeyManager.removeJourneyById(journeyId);

                        System.out.println("Journey removed successfully.");

                    }

                    else {

                        System.out.println("Remove cancelled.");

                    }

                }

            }

            else if  
(menuChoice == 7) {

                String  
confirmReset;

                System.out.print("Are you sure you want to reset all journeys?  
(yes/no): ");

                confirmReset = input.nextLine();

                if  
(confirmReset.equalsIgnoreCase("yes")) {

                    journeyManager.resetJourneys();

                    System.out.println("All journeys have been removed.");

                }

                else {

                    System.out.println("Reset cancelled.");

                }

            }

            else if  
(menuChoice == 8) {

                System.out.println("Thanks for using CityRide Lite! Until next  
time!");

            }

            else {

                System.out.println("Invalid choice.");

            }

        }

        input.close();

    }

}

#### **Journey.java:**

import java.math.BigDecimal;  

public class Journey {  

    private int journeyId;    
    private String journeyDate;    
    private int fromZone;    
    private int toZone;    
    private String timeBand;    
    private String passengerType;    
    private int zonesCrossed;    
    private BigDecimal baseFare;    
    private BigDecimal discountedFare;    
    private BigDecimal chargedFare;  

    public Journey(int journeyId, String  
journeyDate, int fromZone, int toZone, String timeBand,    
                   String passengerType,  
int zonesCrossed, BigDecimal baseFare,    
                   BigDecimal discountedFare, BigDecimal chargedFare) {    
        this.journeyId = journeyId;    
        this.journeyDate = journeyDate;    
        this.fromZone = fromZone;    
        this.toZone = toZone;    
        this.timeBand = timeBand;    
        this.passengerType = passengerType;    
        this.zonesCrossed = zonesCrossed;    
        this.baseFare = baseFare;    
        this.discountedFare = discountedFare;    
        this.chargedFare = chargedFare;    
    }  

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

    public int getZonesCrossed() {    
        return zonesCrossed;    
    }  

    public BigDecimal getBaseFare() {    
        return baseFare;    
    }  

    public BigDecimal getDiscountedFare()  
{    
        return discountedFare;    
    }  

    public BigDecimal getChargedFare() {    
        return chargedFare;    
    }  

    public BigDecimal getDiscountAmount()  
{    
        return  
baseFare.subtract(discountedFare);    
    }  

    public void displayJourney() {    
        System.*out*.println("Journey ID: " + journeyId);    
        System.*out*.println("Date: " + journeyDate);    
        System.*out*.println("From Zone: " + fromZone);    
        System.*out*.println("To Zone: " + toZone);    
        System.*out*.println("Time Band: " + timeBand);    
        System.*out*.println("Passenger Type: " + passengerType);    
        System.*out*.println("Zones Crossed: " + zonesCrossed);    
        System.*out*.println("Base Fare: £" + baseFare);    
        System.*out*.println("Discount Applied: £" + getDiscountAmount());    
        System.*out*.println("Charged Fare: £" + chargedFare);    
        System.*out*.println();    
    }    
}

#### **JourneyManager.java:**

import java.math.BigDecimal;

import java.math.RoundingMode;

import java.util.ArrayList;

// **Oracle (n.d.) BigDecimal and RoundingMode are used in this class for fare totals and average rounding**

public class JourneyManager {

public class JourneyManager {

    private  
ArrayList<Journey> journeys;

    public  
JourneyManager() {

        journeys = new  
ArrayList<>();

    }

    public void  
addJourney(Journey journey) {

        journeys.add(journey);

    }

    public void  
listAllJourneys() {

        int i;

        if  
(journeys.size() == 0) {

            System.out.println("No journeys stored.");

        }

        else {

            for (i =  
0; i < journeys.size(); i++) {

                journeys.get(i).displayJourney();

            }

        }

    }

// **Baeldung (2018) and Oracle (n.d.) show searching through an ArrayList with a loop**

    public Journey findJourneyById(int journeyId) {

        int i;

        for (i = 0; i < journeys.size(); i++) {

            if  
(journeys.get(i).getJourneyId() == journeyId) {

                return journeys.get(i);

            }

        }

        return null;

    }

    public void removeJourneyById(int journeyId) {

        Journey  
journey;

        journey =  
findJourneyById(journeyId);

        if (journey !=  
null) {

            journeys.remove(journey);

        }

    }

    public void resetJourneys() {

        journeys.clear();

    }

    public BigDecimal  
getPassengerChargedTotal(String passengerType) {

        BigDecimal  
total = BigDecimal.ZERO;

        int i;

        for (i = 0; i  
< journeys.size(); i++) {

            if  
(journeys.get(i).getPassengerType().equalsIgnoreCase(passengerType)) {

                total  
= total.add(journeys.get(i).getChargedFare());

            }

        }

        return total;

    }

    public void  
displayCategoryCounts() {

        int peakCount = 0;

        int offPeakCount = 0;

        int zone1Count = 0;

        int zone2Count = 0;

        int zone3Count = 0;

        int zone4Count = 0;

        int zone5Count = 0;

        int i;

        if  
(journeys.size() == 0) {

            System.out.println("No journeys stored.");

        }

        else {

            for (i =  
0; i < journeys.size(); i++) {

                if  
(journeys.get(i).getTimeBand().equalsIgnoreCase("Peak")) {

                    peakCount++;

                }

                else {

                    offPeakCount++;

                }

                if  
(journeys.get(i).getFromZone() == 1) {

                    zone1Count++;

                }

                else  
if (journeys.get(i).getToZone() == 1) {

                    zone1Count++;

                }

                if  
(journeys.get(i).getFromZone() == 2) {

                    zone2Count++;

                }

                else  
if (journeys.get(i).getToZone() == 2) {

                    zone2Count++;

                }

                if  
(journeys.get(i).getFromZone() == 3) {

                    zone3Count++;

                }

                else  
if (journeys.get(i).getToZone() == 3) {

                    zone3Count++;

                }

                if  
(journeys.get(i).getFromZone() == 4) {

                    zone4Count++;

                }

                else  
if (journeys.get(i).getToZone() == 4) {

                    zone4Count++;

                }

                if  
(journeys.get(i).getFromZone() == 5) {

                    zone5Count++;

                }

                else  
if (journeys.get(i).getToZone() == 5) {

                    zone5Count++;

                }

            }

            System.out.println("Category Counts");

            System.out.println("Peak Journeys: " + peakCount);

            System.out.println("Off-Peak Journeys: " + offPeakCount);

            System.out.println("Journeys Involving Zone 1: " +  
zone1Count);

            System.out.println("Journeys Involving Zone 2: " +  
zone2Count);

            System.out.println("Journeys Involving Zone 3: " +  
zone3Count);

            System.out.println("Journeys Involving Zone 4: " +  
zone4Count);

            System.out.println("Journeys Involving Zone 5: " +  
zone5Count);

        }

    }

    public void  
displayDailySummary() {

        BigDecimal  
total = BigDecimal.ZERO;

        BigDecimal  
average = BigDecimal.ZERO;

        Journey  
mostExpensive = null;

        int i;

        if  
(journeys.size() == 0) {

            System.out.println("No journeys stored.");

        }

// **Oracle (n.d.) BigDecimal compareTo() used to total fares and find the highest fare**

        else {

            mostExpensive = journeys.get(0);

            for (i = 0; i < journeys.size(); i++) {

                total = total.add(journeys.get(i).getChargedFare());

                if  
(journeys.get(i).getChargedFare()<mark>.compareTo</mark>(mostExpensive.getChargedFare())

        {

                    mostExpensive = journeys.get(i);

                }

            }

            average =  
total.divide(new BigDecimal(journeys.size()), 2, RoundingMode.HALF_UP);

            System.out.println("Daily Summary");

            System.out.println("Total Journeys: " + journeys.size());

            System.out.println("Total Cost Charged: £" + total);

            System.out.println("Average Cost Per Journey: £" + average);

            System.out.println("Most Expensive Journey ID: " +  
mostExpensive.getJourneyId());

        }

    }

    public void displayTotalsByPassengerType() {

        showTotals("Adult");

        showTotals("Student");

        showTotals("Child");

        showTotals("Senior Citizen");

    }

    public void showTotals(String passengerType) {

        int count = 0;

        BigDecimal total = BigDecimal.ZERO;

        int i;

        for (i = 0; i < journeys.size(); i++) {

            if  
(journeys.get(i).getPassengerType().equalsIgnoreCase(passengerType)) {

                count++;

                total = total.add(journeys.get(i).getChargedFare());

            }

        }

        System.out.println(passengerType + " Journeys: " + count + " | Total: £" + total);

    }

}

#### **InputValidator.java:**

public class InputValidator {  

    public InputValidator() {    
    }  

    public boolean isValidZone(int zone)  
{    
        if (zone >= 1 && zone <= 5) {    
            return true;    
        }    
        else {    
            return false;    
        }    
    }  

    public boolean isValidTimeBand(String timeBand) {    
        if  
(timeBand.equalsIgnoreCase("Peak")) {    
            return true;    
        }    
        else if  
(timeBand.equalsIgnoreCase("Off-Peak")) {    
            return true;    
        }    
        else if (timeBand.equalsIgnoreCase("Off Peak")) {    
            return true;    
        }    
        else {    
            return false;    
        }    
    }  

    public boolean  
isValidPassengerType(String passengerType) {    
        if  
(passengerType.equalsIgnoreCase("Adult")) {    
            return true;    
        }    
        else if  
(passengerType.equalsIgnoreCase("Student")) {    
            return true;    
        }    
        else if  
(passengerType.equalsIgnoreCase("Child")) {    
            return true;    
        }    
        else if  
(passengerType.equalsIgnoreCase("Senior Citizen")) {    
            return true;    
        }    
        else {    
            return false;    
        }    
    }  

// **(Baeldung, 2024)**

    <mark>public boolean isBlank(String text) {  </mark>  
<mark>if (text == null ||text.trim().equals(" ")) { </mark>    
            return true;    
        }    
        else {    
            return false;    
        }    
    }

// **Abdul D. (2024)**

    <mark>public boolean isNumeric(String text)</mark>  
<mark>{</mark>    
    <mark>try {</mark>    
        <mark>Integer.*parseInt*(text);</mark>    
        <mark>return true;</mark>    
<mark>}</mark>    
<mark>catch (Exception e) {</mark>    
    <mark>return false;</mark>    
        <mark>}</mark>    
    <mark>}</mark>    
}

#### **FareCalculator.java:**

import java.math.BigDecimal;

import java.math.RoundingMode;

// **Oracle (n.d.) BigDecimal documentation used for currency arithmetic and comparisons**

public class FareCalculator { // Calculates fares for  
journeys

    // Constructor

    public  
FareCalculator() {

    }

    public int  
calculateZonesCrossed(int fromZone, int toZone) { // Calculates the number of  
zones crossed.

        int zonesCrossed = 0;

// **Oracle (n.d.) Math.abs() returns the absolute value**

        zonesCrossed = <mark>Math.abs</mark>(toZone - fromZone) + 1;

        return zonesCrossed;

    }

    public BigDecimal  
calculateBaseFare(int fromZone, int toZone, String timeBand) {

        // Calculates  
the base fare of the journey using timeband & zones crossed

        CityRideDataset.TimeBand selectedTimeBand;

        BigDecimal  
baseFare;

        if  
(timeBand.equalsIgnoreCase("Peak")) {

            selectedTimeBand = CityRideDataset.TimeBand.PEAK;

        }

        else {

            selectedTimeBand = CityRideDataset.TimeBand.OFF_PEAK;

        }

        baseFare =  
CityRideDataset.getBaseFare(fromZone, toZone, selectedTimeBand);

        return

// **(Oracle, n.d.)**  
baseFare<mark>.setScale(2, RoundingMode.HALF_UP);</mark>

    }

    public BigDecimal  
calculateDiscountedFare(BigDecimal baseFare, String passengerType) { // Applies  
passenger discount to the base fare

        BigDecimal  
discountRate = BigDecimal.ZERO;

        BigDecimal  
discountAmount;

        BigDecimal  
discountedFare;

        if  
(passengerType.equalsIgnoreCase("Adult")) {

            discountRate =  
CityRideDataset.DISCOUNT_RATE.get(CityRideDataset.PassengerType.ADULT);

        }

        else if  
(passengerType.equalsIgnoreCase("Student")) {

            discountRate =  
CityRideDataset.DISCOUNT_RATE.get(CityRideDataset.PassengerType.STUDENT);

        }

        else if  
(passengerType.equalsIgnoreCase("Child")) {

            discountRate =  
CityRideDataset.DISCOUNT_RATE.get(CityRideDataset.PassengerType.CHILD);

        }

        else if  
(passengerType.equalsIgnoreCase("Senior Citizen")) {

            discountRate =  
CityRideDataset.DISCOUNT_RATE.get(CityRideDataset.PassengerType.SENIOR_CITIZEN);

        }

// **(Oracle, n.d.) RoundingMode**

        discountAmount = baseFare.multiply(discountRate)<mark>.setScale(2, RoundingMode.HALF_UP</mark>);

// **(Oracle, n.d.) RoundingMode**

        discountedFare = baseFare.subtract(discountAmount)<mark>.setScale(2, RoundingMode.HALF_UP);</mark>

        return  
discountedFare;

    }

    public BigDecimal  
calculateChargedFare(BigDecimal discountedFare, String passengerType,  
BigDecimal currentTotal) {

        // Calculates  
how much should be charged after considering how much the passenger has spent  
today (cap).

        BigDecimal  
chargedFare = BigDecimal.ZERO;

        BigDecimal  
dailyCap = BigDecimal.ZERO;

        BigDecimal  
remainingCap;

        if  
(passengerType.equalsIgnoreCase("Adult")) {

            dailyCap =  
CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.ADULT);

        }

        else if  
(passengerType.equalsIgnoreCase("Student")) {

            dailyCap =  
CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.STUDENT);

        }

        else if  
(passengerType.equalsIgnoreCase("Child")) {

            dailyCap =  
CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.CHILD);

        }

        else if  
(passengerType.equalsIgnoreCase("Senior Citizen")) {

            dailyCap =  
CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.SENIOR_CITIZEN);

        }

// **(Oracle, n.d.) RoundingMode() & BigDecimal compareTo()**

        remainingCap = dailyCap.subtract(currentTotal)<mark>.setScale(2, RoundingMode.HALF_UP</mark>);

        if  
(remainingCap<mark>.compareTo</mark>(BigDecimal.ZERO) <= 0) {

            chargedFare = BigDecimal.ZERO;

        }

        else if  
(discountedFare<mark>.compareTo</mark>(remainingCap) > 0) {

            chargedFare = remainingCap;

        }

        else {

            chargedFare = discountedFare;

        }

// **(Oracle, n.d.) RoundingMode**

        return chargedFare<mark>.setScale(2, RoundingMode.HALF_UP);</mark>

    }

    public boolean  
hasReachedDailyCap(String passengerType, BigDecimal currentTotal) {

        // Checks if  
passenger has already reached daily cap

        boolean  
hasReachedCap = false;

        BigDecimal  
dailyCap = BigDecimal.ZERO;

        if  
(passengerType.equalsIgnoreCase("Adult")) {

            dailyCap =  
CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.ADULT);

        }

        else if  
(passengerType.equalsIgnoreCase("Student")) {

            dailyCap =  
CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.STUDENT);

        }

        else if  
(passengerType.equalsIgnoreCase("Child")) {

            dailyCap =  
CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.CHILD);

        }

        else if  
(passengerType.equalsIgnoreCase("Senior Citizen")) {

            dailyCap =  
CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.SENIOR_CITIZEN);

        }

        if

// **(Oracle, n.d.) BigDecimal compareTo() used to compare current total to daily cap**  
(currentTotal<mark>.compareTo</mark>(dailyCap) >= 0) { // Compares passenger type cap to  
total

            hasReachedCap = true;

        }

        return  
hasReachedCap;

    }

}

---

## Refrences

- Baeldung. (2024). *Java Blank vs Empty Strings*. Retrieved from: [Checking for Empty or Blank Strings in Java | Baeldung](https://www.baeldung.com/java-blank-empty-strings "https://www.baeldung.com/java-blank-empty-strings") [Accessed 23 May 2026].

- Abdul D. (2024). *How to check if a String is numeric in Java?* Retrieved from: [How to check if a String is numeric in Java? | Sentry](https://sentry.io/answers/how-to-check-if-a-string-is-numeric-in-java/ "https://sentry.io/answers/how-to-check-if-a-string-is-numeric-in-java/") [Accessed 23 May 2026].

- Singh, C. (2022). *Java String equals() and equalsIgnoreCase() Methods Example*. Retrieved from: [Java String equals() and equalsIgnoreCase() Methods example](https://beginnersbook.com/2013/12/java-string-equals-and-equalsignorecase-methods-example/ "https://beginnersbook.com/2013/12/java-string-equals-and-equalsignorecase-methods-example/") [Accessed 23 May 2026].

- Oracle. (n.d.). *RoundingMode (Java Platform SE 8).* Retrieved from: [RoundingMode (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/math/RoundingMode.html "https://docs.oracle.com/javase/8/docs/api/java/math/roundingmode.html") [Accessed 23 May 2026].

- Oracle. (n.d.). *BigDecimal (Java Platform SE 8).* Retrieved from: [BigDecimal (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html "https://docs.oracle.com/javase/8/docs/api/java/math/bigdecimal.html") [Accessed 23 May 2026].

- Oracle. (n.d.). *Math (Java Platform SE 8).* Retrieved from: [Math (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html "https://docs.oracle.com/javase/8/docs/api/java/lang/math.html") [Accessed 23 May 2026].

- Oracle. (n.d.). *Integer (Java Platform SE 8).* Retrieved from: [Integer (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html "https://docs.oracle.com/javase/8/docs/api/java/lang/integer.html") [Accessed 23 May 2026].

- Runestone Interactive / University of New Hampshire. (n.d.). *Logical Operators*. Retrieved from: [4. Logical Operators — Runestone Interactive Overview](https://www.cs.unh.edu/~cs415/lab_manual/labs/conditionals/logical_operators.html "https://www.cs.unh.edu/~cs415/lab_manual/labs/conditionals/logical_operators.html") [Accessed 23 May 2026].

- Bro Code. (2024). *Code a simple banking program with Java!* [YouTube video]. Available at: [Code a simple banking program with Java! 💰 - YouTube](https://www.youtube.com/watch?v=49bIIa6id08 "https://www.youtube.com/watch?v=49biia6id08") [Accessed 24 May 2026].
