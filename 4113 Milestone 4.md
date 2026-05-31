# IY4113 Milestone 4

| Assessment Details | Please Complete All Details                                           |
| ------------------ | --------------------------------------------------------------------- |
| Group              | A                                                                     |
| Module Title       | IY4113 Applied Software Engineering using Object-Oriented Programming |
| Assessment Type    | Java Fundamentals Milestone 4                                         |
| Module Tutor Name  | Jonathan Shore                                                        |
| Student ID Number  | P466146                                                               |
| Date of Submission | 24/05/2026                                                            |
| Word Count         | 943                                                                   |
| GItHub Link        | https://github.com/firasallawati/T0466146_Firas_4113                  |

- [x] *I confirm that this assignment is my own work. Where I have referred to academic sources, I have provided in-text citations and included the sources in
  the final reference list.*

- [x] Where I have used AI, I have cited and referenced appropriately.

------------------------------------------------------------------------------------------------------------------------------

### Program Code

---

#### **Main.java:**

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

------------------------------------------------------------------------------------------------------------------------------

### Updated Gantt Chart

------------------------------------------------------------------------------------------------------------------------------

![](Ganttchart4.PNG)

------------------------------------------------------------------------------------------------------------------------------

### Diary Entries

------------------------------------------------------------------------------------------------------------------------------

**05/20/2026 - Diary Entry 1 - Journey Class and InputValidator**

I started with working on the Journey class which is meant to store all the necessary data regarding the journey. The data was supposed to be journey id, journey date, zones covered, passenger type, fare value, and number of zones.

After doing this, I worked on the InputValidator class which ensured that all the inputs by the user were validated. This step became necessary since the rest of the code processes depended on the validity of the user inputs. The checks I added include passenger type, time band, and zones.

The biggest problem I encountered while doing these was ensuring that the two classes met the requirements of the assignment. I solved this by keeping the Journey class focused on the data storage and the InputValidator class focused solely on checking input before any calculations were made which follows the NTIC Guide to Good Programming which states that a class should do one thing and one thing only which is what i focused on during doing the code for the project.

**05/21/2026 - Diary Entry 2 - FareCalculator**

Today, I worked on the FareCalculator class. Its job is to calculate everything related to the fares such as the number of zones traveled, base fare, discounts, and total charged fare. I have used BigDecimal to ensure that the financial calculations performed here are precise and that there would be no issue related to rounding.

Furthermore, I have included the necessary logic to work with the different passenger categories. This class turned out to be one of the most crucial classes as it would determine the fare calculation process based on the details inputted by the user.

The main challenge in this task was ensuring the consistency of the calculations and understanding how BigDecimal works and because of how big it is and the number of things it can do it took a while for me to grasp the relevant functions that I can use for the FareCalculator. I also used the Java standard library class RoundingMode to simplify the process of rounding the final calculations in order to fulfill the brief requirement.

**05/22/2026 - Diary Entry 3 - JourneyManager**

Today, I worked on the JourneyManager class. I created different methods to save a journey, list all journeys, get a journey using its unique ID, delete a journey, and clear the entire journey list.  I also added methods to calculate totals and display summaries, such as category counts which include the peak vs off peak journeys & the zone count. I also added a method to display daily summary of the journeys stored in the memory of the program.  

The importance of this class is the management of the already created journey details that were inputted by the user and stored in the Journey Class. I used an ArrayList for all journeys so that they can be stored, modified, and processed conveniently. I also used BigDecimal to get precise results in my total calculations just like in the FareCalculator class.  

The greatest challenge I faced during the coding of this class was getting the summary calculations right, especially getting the most expensive fare amount. I overcame this by breaking the logic into smaller methods, researching and checking each one separately by going through them ensuring that the logic makes sense and functions in the way that it's supposed to. However, one issue I was unable to solve was adding the filtering data option in the menu, which was a requirement in the brief. I tried several different approaches, but I was still not able to fully understand how to implement it. I hope to be able to have it completed by the final submission as I will have extra time to research about it by then.

**05/23/2026 - Diary Entry 4 - Main**

Today I have completed the code for the Main class and integrated it throughout the entire project. First, I have created the menu which enables the user to be able to perform various functions, such as adding new journeys, listing journeys, displaying the categories count, displaying the daily summary, displaying totals by passenger type, deleting journeys, resetting the day, and exiting the program.

In addition, I did some research on the proper usage of isBlank and isNumeric methods prior to their integration into the InputValidator class because I felt that this would ensure the improvement in the quality of the input check process.

Linking up the Main class to other classes was the last major step involved in putting together the entire program. The hardest part of this step was ensuring that the menu loop runs perfectly, and the inputs are handled correctly, which I accomplished through the careful validation of each input by testing it as I go along the code of the class. I also learned how to use Integer.parseInt() to convert string input into integers, which was important for validating and processing the zone numbers and journey IDs entered by the user.

------------------------------------------------------------------------------------------------------------------------------

### Refrence List

---

- Baeldung. (2024). *Java Blank vs Empty Strings*. Retrieved from: [Checking for Empty or Blank Strings in Java | Baeldung](https://www.baeldung.com/java-blank-empty-strings "https://www.baeldung.com/java-blank-empty-strings") [Accessed 23 May 2026].

- Abdul D. (2024). *How to check if a String is numeric in Java?* Retrieved from: [How to check if a String is numeric in Java? | Sentry](https://sentry.io/answers/how-to-check-if-a-string-is-numeric-in-java/ "https://sentry.io/answers/how-to-check-if-a-string-is-numeric-in-java/") [Accessed 23 May 2026].

- Singh, C. (2022). *Java String equals() and equalsIgnoreCase() Methods Example*. Retrieved from: [Java String equals() and equalsIgnoreCase() Methods example](https://beginnersbook.com/2013/12/java-string-equals-and-equalsignorecase-methods-example/ "https://beginnersbook.com/2013/12/java-string-equals-and-equalsignorecase-methods-example/") [Accessed 23 May 2026].

- Oracle. (n.d.). *RoundingMode (Java Platform SE 8).* Retrieved from: [RoundingMode (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/math/RoundingMode.html "https://docs.oracle.com/javase/8/docs/api/java/math/roundingmode.html") [Accessed 23 May 2026].

- Oracle. (n.d.). *BigDecimal (Java Platform SE 8).* Retrieved from: [BigDecimal (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html "https://docs.oracle.com/javase/8/docs/api/java/math/bigdecimal.html") [Accessed 23 May 2026].

- Oracle. (n.d.). *Math (Java Platform SE 8).* Retrieved from: [Math (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html "https://docs.oracle.com/javase/8/docs/api/java/lang/math.html") [Accessed 23 May 2026].

- Oracle. (n.d.). *Integer (Java Platform SE 8).* Retrieved from: [Integer (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html "https://docs.oracle.com/javase/8/docs/api/java/lang/integer.html") [Accessed 23 May 2026].

- Runestone Interactive / University of New Hampshire. (n.d.). *Logical Operators*. Retrieved from: [4. Logical Operators &#8212; Runestone Interactive Overview](https://www.cs.unh.edu/~cs415/lab_manual/labs/conditionals/logical_operators.html "https://www.cs.unh.edu/~cs415/lab_manual/labs/conditionals/logical_operators.html") [Accessed 23 May 2026].

- Bro Code. (2024). *Code a simple banking program with Java!* [YouTube video]. Available at: [Code a simple banking program with Java! 💰 - YouTube](https://www.youtube.com/watch?v=49bIIa6id08 "https://www.youtube.com/watch?v=49biia6id08") [Accessed 24 May 2026].
