import java.math.BigDecimal;
import java.math.RoundingMode;

public class FareCalculator { // Calculates fares for journeys (Calculations not done yet)

    // Constructor
    public FareCalculator() {
    }

    public int calculateZonesCrossed(int fromZone, int toZone) {
        int zonesCrossed = 0;
        zonesCrossed = Math.abs(toZone - fromZone) + 1;
        return zonesCrossed;
    }

    public BigDecimal calculateBaseFare(int fromZone, int toZone, String timeBand) {
        // Calculates the base fare of the journey using timeband & zones crossed

        CityRideDataset.TimeBand selectedTimeBand;
        BigDecimal baseFare;

        if (timeBand.equalsIgnoreCase("Peak")) {
            selectedTimeBand = CityRideDataset.TimeBand.PEAK;
        }
        else {
            selectedTimeBand = CityRideDataset.TimeBand.OFF_PEAK;
        }

        baseFare = CityRideDataset.getBaseFare(fromZone, toZone, selectedTimeBand);
        return baseFare.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateDiscountedFare(BigDecimal baseFare, String passengerType) { // Applies passenger discount to the base fare
        BigDecimal discountRate = BigDecimal.ZERO;
        BigDecimal discountAmount;
        BigDecimal discountedFare;

        if (passengerType.equalsIgnoreCase("Adult")) {
            discountRate = CityRideDataset.DISCOUNT_RATE.get(CityRideDataset.PassengerType.ADULT);
        }
        else if (passengerType.equalsIgnoreCase("Student")) {
            discountRate = CityRideDataset.DISCOUNT_RATE.get(CityRideDataset.PassengerType.STUDENT);
        }
        else if (passengerType.equalsIgnoreCase("Child")) {
            discountRate = CityRideDataset.DISCOUNT_RATE.get(CityRideDataset.PassengerType.CHILD);
        }
        else if (passengerType.equalsIgnoreCase("Senior Citizen")) {
            discountRate = CityRideDataset.DISCOUNT_RATE.get(CityRideDataset.PassengerType.SENIOR_CITIZEN);
        }

        discountAmount = baseFare.multiply(discountRate).setScale(2, RoundingMode.HALF_UP); // Calculates the amount that will be discounted
        discountedFare = baseFare.subtract(discountAmount).setScale(2, RoundingMode.HALF_UP); // Calculates the final fare after discount

        return discountedFare;
    }

    public BigDecimal calculateChargedFare(BigDecimal discountedFare, String passengerType, BigDecimal currentTotal) {
        // Calculates how much should be charged after considering how much the passenger has spent today (cap).

        BigDecimal chargedFare = BigDecimal.ZERO;
        BigDecimal dailyCap = BigDecimal.ZERO;
        BigDecimal remainingCap;

        if (passengerType.equalsIgnoreCase("Adult")) {
            dailyCap = CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.ADULT);
        }
        else if (passengerType.equalsIgnoreCase("Student")) {
            dailyCap = CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.STUDENT);
        }
        else if (passengerType.equalsIgnoreCase("Child")) {
            dailyCap = CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.CHILD);
        }
        else if (passengerType.equalsIgnoreCase("Senior Citizen")) {
            dailyCap = CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.SENIOR_CITIZEN);
        }

        remainingCap = dailyCap.subtract(currentTotal).setScale(2, RoundingMode.HALF_UP);

        if (remainingCap.compareTo(BigDecimal.ZERO) <= 0) {
            chargedFare = BigDecimal.ZERO;
        }
        else if (discountedFare.compareTo(remainingCap) > 0) {
            chargedFare = remainingCap;
        }
        else {
            chargedFare = discountedFare;
        }

        return chargedFare.setScale(2, RoundingMode.HALF_UP);
    }

    public boolean hasReachedDailyCap(String passengerType, BigDecimal currentTotal) {
        // Checks if passenger has already reached daily cap
        boolean hasReachedCap = false;
        BigDecimal dailyCap = BigDecimal.ZERO;

        if (passengerType.equalsIgnoreCase("Adult")) {
            dailyCap = CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.ADULT);
        }
        else if (passengerType.equalsIgnoreCase("Student")) {
            dailyCap = CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.STUDENT);
        }
        else if (passengerType.equalsIgnoreCase("Child")) {
            dailyCap = CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.CHILD);
        }
        else if (passengerType.equalsIgnoreCase("Senior Citizen")) {
            dailyCap = CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.SENIOR_CITIZEN);
        }

        if (currentTotal.compareTo(dailyCap) >= 0) { // Compares passenger type cap to total
            hasReachedCap = true;
        }

        return hasReachedCap;
    }
}
