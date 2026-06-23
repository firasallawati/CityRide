import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class JourneyManager { // In charge of the whole list of Journeys stored

    // Attributes
    private ArrayList<Journey> journeys;

    // Constructor
    public JourneyManager() {
        journeys = new ArrayList<>();
    }

    // Get Methods
    public ArrayList<Journey> getJourneys() {
        return journeys;
    }

    public Journey findJourneyById(int journeyId) {
        int i;
        for (i = 0; i < journeys.size(); i++) {
            if (journeys.get(i).getJourneyId() == journeyId) {
                return journeys.get(i);
            }
        }
        return null;
    }

    public BigDecimal getPassengerChargedTotal(String passengerType) {
        BigDecimal total = BigDecimal.ZERO;
        int i;
        for (i = 0; i < journeys.size(); i++) {
            if (journeys.get(i).getPassengerType().equalsIgnoreCase(passengerType)) {
                total = total.add(journeys.get(i).getChargedFare());
            }
        }
        return total;
    }

    // Set Methods
    public void setJourneys(ArrayList<Journey> journeys) {
        this.journeys = journeys;
    }

    public void addJourney(Journey journey) { // Adds new journey to the array
        journeys.add(journey);
    }

    public boolean editJourney(int journeyId, Journey updatedJourney) {
        int i;
        for (i = 0; i < journeys.size(); i++) {
            if (journeys.get(i).getJourneyId() == journeyId) {
                journeys.set(i, updatedJourney);
                return true;
            }
        }
        return false;
    }

    public void displayAllJourneys() { // Display stored journeys
        int i;
        if (journeys.size() == 0) {
            System.out.println("No journeys stored.");
        }
        else {
            for (i = 0; i < journeys.size(); i++) {
                journeys.get(i).displayJourney();
            }
        }
    }

    public void removeJourneyById(int journeyId) { // Delete Journey using unique ID
        Journey journey;
        journey = findJourneyById(journeyId);
        if (journey != null) {
            journeys.remove(journey);
        }
    }

    public void resetJourneys() { // Delete all stored journeys
        journeys.clear();
    }

    public void displayCategoryCounts() {
        int peakCount = 0;
        int offPeakCount = 0;
        int zone1Count = 0;
        int zone2Count = 0;
        int zone3Count = 0;
        int zone4Count = 0;
        int zone5Count = 0;
        int i;
        if (journeys.size() == 0) {
            System.out.println("No journeys stored.");
        }
        else {
            for (i = 0; i < journeys.size(); i++) {
                if (journeys.get(i).getTimeBand().equalsIgnoreCase("Peak")) {
                    peakCount++;
                }
                else {
                    offPeakCount++;
                }
                if (journeys.get(i).getFromZone() == 1 || journeys.get(i).getToZone() == 1) {
                    zone1Count++;
                }
                if (journeys.get(i).getFromZone() == 2 || journeys.get(i).getToZone() == 2) {
                    zone2Count++;
                }
                if (journeys.get(i).getFromZone() == 3 || journeys.get(i).getToZone() == 3) {
                    zone3Count++;
                }
                if (journeys.get(i).getFromZone() == 4 || journeys.get(i).getToZone() == 4) {
                    zone4Count++;
                }
                if (journeys.get(i).getFromZone() == 5 || journeys.get(i).getToZone() == 5) {
                    zone5Count++;
                }
            }
            System.out.println("Category Counts");
            System.out.println("Peak Journeys: " + peakCount);
            System.out.println("Off-Peak Journeys: " + offPeakCount);
            System.out.println("Journeys Involving Zone 1: " + zone1Count);
            System.out.println("Journeys Involving Zone 2: " + zone2Count);
            System.out.println("Journeys Involving Zone 3: " + zone3Count);
            System.out.println("Journeys Involving Zone 4: " + zone4Count);
            System.out.println("Journeys Involving Zone 5: " + zone5Count);
        }
    }

    public void displayDailySummary() {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal average = BigDecimal.ZERO;
        Journey mostExpensive = null;
        int i;
        if (journeys.size() == 0) {
            System.out.println("No journeys stored.");
        }
        else {
            mostExpensive = journeys.get(0);
            for (i = 0; i < journeys.size(); i++) {
                total = total.add(journeys.get(i).getChargedFare());
                if (journeys.get(i).getChargedFare().compareTo(mostExpensive.getChargedFare()) > 0) {
                    mostExpensive = journeys.get(i);
                }
            }
            average = total.divide(new BigDecimal(journeys.size()), 2, RoundingMode.HALF_UP);
            System.out.println("Daily Summary");
            System.out.println("Total Journeys: " + journeys.size());
            System.out.println("Total Cost Charged: £" + total);
            System.out.println("Average Cost Per Journey: £" + average);
            System.out.println("Most Expensive Journey ID: " + mostExpensive.getJourneyId());
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
            if (journeys.get(i).getPassengerType().equalsIgnoreCase(passengerType)) {
                count++;
                total = total.add(journeys.get(i).getChargedFare());
            }
        }
        System.out.println(passengerType + " Journeys: " + count + " | Total: £" + total);
    }
}