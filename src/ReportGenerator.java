import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReportGenerator { // Creates CSV and text reports

    // Constructor
    public ReportGenerator() {
    }

    public void exportSummaryCsv(String fileName, RiderProfile profile, JourneyManager journeyManager) {
        int i;
        BigDecimal totalCost = BigDecimal.ZERO;
        BigDecimal totalBaseCost = BigDecimal.ZERO;
        BigDecimal totalSavings = BigDecimal.ZERO;

        try {
            File folder = new File("reports");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            PrintWriter writer = new PrintWriter(fileName);
            writer.println("RiderName,PassengerType,JourneyId,Date,FromZone,ToZone,TimeBand,ZonesCrossed,BaseFare,DiscountApplied,ChargedFare");

            for (i = 0; i < journeyManager.getJourneys().size(); i++) {
                Journey journey = journeyManager.getJourneys().get(i);
                BigDecimal discountApplied = journey.getBaseFare().subtract(journey.getChargedFare());

                totalCost = totalCost.add(journey.getChargedFare());
                totalBaseCost = totalBaseCost.add(journey.getBaseFare());

                writer.println(
                        profile.getName() + "," +
                                profile.getPassengerType() + "," +
                                journey.getJourneyId() + "," +
                                journey.getJourneyDate() + "," +
                                journey.getFromZone() + "," +
                                journey.getToZone() + "," +
                                journey.getTimeBand() + "," +
                                journey.getZonesCrossed() + "," +
                                journey.getBaseFare() + "," +
                                discountApplied + "," +
                                journey.getChargedFare()
                );
            }

            totalSavings = totalBaseCost.subtract(totalCost);

            writer.println();
            writer.println("Total Journeys," + journeyManager.getJourneys().size());
            writer.println("Total Cost," + totalCost);
            writer.println("Savings," + totalSavings);

            writer.close();
            System.out.println("CSV report exported successfully.");
        }
        catch (Exception e) {
            System.out.println("Error exporting CSV report.");
        }
    }

    public void exportSummaryText(String fileName, RiderProfile profile, JourneyManager journeyManager) {
        int i;
        int peakCount = 0;
        int offPeakCount = 0;
        int zone1Count = 0;
        int zone2Count = 0;
        int zone3Count = 0;
        int zone4Count = 0;
        int zone5Count = 0;
        BigDecimal totalCost = BigDecimal.ZERO;
        BigDecimal totalBaseCost = BigDecimal.ZERO;
        BigDecimal averageCost = BigDecimal.ZERO;
        BigDecimal totalSavings = BigDecimal.ZERO;
        Journey mostExpensive = null;

        try {
            File folder = new File("reports");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            PrintWriter writer = new PrintWriter(fileName);

            if (journeyManager.getJourneys().size() > 0) {
                mostExpensive = journeyManager.getJourneys().get(0);
            }

            for (i = 0; i < journeyManager.getJourneys().size(); i++) {
                Journey journey = journeyManager.getJourneys().get(i);

                totalCost = totalCost.add(journey.getChargedFare());
                totalBaseCost = totalBaseCost.add(journey.getBaseFare());

                if (journey.getTimeBand().equalsIgnoreCase("Peak")) {
                    peakCount++;
                }
                else {
                    offPeakCount++;
                }

                if (journey.getFromZone() == 1 || journey.getToZone() == 1) {
                    zone1Count++;
                }
                if (journey.getFromZone() == 2 || journey.getToZone() == 2) {
                    zone2Count++;
                }
                if (journey.getFromZone() == 3 || journey.getToZone() == 3) {
                    zone3Count++;
                }
                if (journey.getFromZone() == 4 || journey.getToZone() == 4) {
                    zone4Count++;
                }
                if (journey.getFromZone() == 5 || journey.getToZone() == 5) {
                    zone5Count++;
                }

                if (mostExpensive != null && journey.getChargedFare().compareTo(mostExpensive.getChargedFare()) > 0) {
                    mostExpensive = journey;
                }
            }

            if (journeyManager.getJourneys().size() > 0) {
                averageCost = totalCost.divide(new BigDecimal(journeyManager.getJourneys().size()), 2, RoundingMode.HALF_UP);
            }

            totalSavings = totalBaseCost.subtract(totalCost);

            writer.println("CityRide Lite End-of-Day Summary");
            writer.println("Rider Name: " + profile.getName());
            writer.println("Passenger Type: " + profile.getPassengerType());
            writer.println("Default Payment Option: " + profile.getDefaultPaymentOption());
            writer.println("Number of Journeys: " + journeyManager.getJourneys().size());
            writer.println("Total Cost: £" + totalCost);
            writer.println("Average Cost Per Journey: £" + averageCost);

            if (mostExpensive != null) {
                writer.println("Most Expensive Journey ID: " + mostExpensive.getJourneyId());
                writer.println("Most Expensive Journey Fare: £" + mostExpensive.getChargedFare());
            }

            writer.println("Peak Journeys: " + peakCount);
            writer.println("Off-Peak Journeys: " + offPeakCount);
            writer.println("Journeys Involving Zone 1: " + zone1Count);
            writer.println("Journeys Involving Zone 2: " + zone2Count);
            writer.println("Journeys Involving Zone 3: " + zone3Count);
            writer.println("Journeys Involving Zone 4: " + zone4Count);
            writer.println("Journeys Involving Zone 5: " + zone5Count);
            writer.println("Savings Compared To Base Fares: £" + totalSavings);

            if (totalSavings.compareTo(BigDecimal.ZERO) > 0) {
                writer.println("Cap or discount savings were applied.");
            }
            else {
                writer.println("No cap or discount savings were applied.");
            }

            writer.close();
            System.out.println("Text summary exported successfully.");
        }
        catch (Exception e) {
            System.out.println("Error exporting text summary.");
        }
    }
}