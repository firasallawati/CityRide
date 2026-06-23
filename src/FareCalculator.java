import java.math.BigDecimal;
import java.math.RoundingMode;

public class FareCalculator {

    public FareCalculator() {
    }

    public int calculateZonesCrossed(int fromZone, int toZone) {
        int zonesCrossed;
        zonesCrossed = Math.abs(toZone - fromZone) + 1;
        return zonesCrossed;
    }

    public BigDecimal calculateBaseFare(int fromZone, int toZone, String timeBand, Config config) {
        String fareKey;
        BigDecimal baseFare;

        if (timeBand.equalsIgnoreCase("Peak")) {
            timeBand = "Peak";
        }
        else if (timeBand.equalsIgnoreCase("Off-Peak")) {
            timeBand = "Off-Peak";
        }

        fareKey = fromZone + "-" + toZone + "-" + timeBand;
        baseFare = config.getBaseFares().get(fareKey);

        if (baseFare == null) {
            baseFare = BigDecimal.ZERO;
        }

        return baseFare.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateDiscountedFare(BigDecimal baseFare, String passengerType, Config config) {
        BigDecimal discountRate;
        BigDecimal discountAmount;
        BigDecimal discountedFare;

        discountRate = config.getPassengerDiscounts().get(passengerType);

        if (discountRate == null) {
            discountRate = BigDecimal.ZERO;
        }

        discountAmount = baseFare.multiply(discountRate).setScale(2, RoundingMode.HALF_UP);
        discountedFare = baseFare.subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);

        return discountedFare;
    }

    public BigDecimal calculateChargedFare(BigDecimal discountedFare, String passengerType, BigDecimal currentTotal, Config config) {
        BigDecimal chargedFare;
        BigDecimal dailyCap;
        BigDecimal remainingCap;

        chargedFare = BigDecimal.ZERO;
        dailyCap = config.getDailyCaps().get(passengerType);

        if (dailyCap == null) {
            dailyCap = BigDecimal.ZERO;
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

    public boolean hasReachedDailyCap(String passengerType, BigDecimal currentTotal, Config config) {
        boolean hasReachedCap;
        BigDecimal dailyCap;

        hasReachedCap = false;
        dailyCap = config.getDailyCaps().get(passengerType);

        if (dailyCap == null) {
            dailyCap = BigDecimal.ZERO;
        }

        if (currentTotal.compareTo(dailyCap) >= 0) {
            hasReachedCap = true;
        }

        return hasReachedCap;
    }
}