import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class JourneyCSVHandler { // Imports and exports journeys in CSV format

    // Constructor
    public JourneyCSVHandler() {
    }

    public void exportJourneys(String fileName, JourneyManager journeyManager) {
        int i;
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.println("JourneyId,Date,FromZone,ToZone,TimeBand,PassengerType,ZonesCrossed,BaseFare,DiscountApplied,ChargedFare");
            for (i = 0; i < journeyManager.getJourneys().size(); i++) {
                Journey journey = journeyManager.getJourneys().get(i);
                writer.println(
                        journey.getJourneyId() + "," +
                                journey.getJourneyDate() + "," +
                                journey.getFromZone() + "," +
                                journey.getToZone() + "," +
                                journey.getTimeBand() + "," +
                                journey.getPassengerType() + "," +
                                journey.getZonesCrossed() + "," +
                                journey.getBaseFare() + "," +
                                journey.getDiscountedFare() + "," +
                                journey.getChargedFare()
                );
            }
            writer.close();
            System.out.println("Journeys exported successfully.");
        }
        catch (Exception e) {
            System.out.println("Error exporting journeys.");
        }
    }

    public void importJourneys(String fileName, JourneyManager journeyManager) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            if (reader.hasNextLine()) {
                reader.nextLine();
            }

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split(",");

                if (data.length == 10) {
                    int journeyId = Integer.parseInt(data[0]);
                    String journeyDate = data[1];
                    int fromZone = Integer.parseInt(data[2]);
                    int toZone = Integer.parseInt(data[3]);
                    String timeBand = data[4];
                    String passengerType = data[5];
                    int zonesCrossed = Integer.parseInt(data[6]);
                    BigDecimal baseFare = new BigDecimal(data[7]);
                    BigDecimal discountedFare = new BigDecimal(data[8]);
                    BigDecimal chargedFare = new BigDecimal(data[9]);

                    Journey journey = new Journey(journeyId, journeyDate, fromZone, toZone, timeBand, passengerType,
                            zonesCrossed, baseFare, discountedFare, chargedFare);

                    journeyManager.addJourney(journey);
                }
            }

            reader.close();
            System.out.println("Journeys imported successfully.");
        }
        catch (Exception e) {
            System.out.println("Error importing journeys.");
        }
    }
}