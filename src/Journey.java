import java.math.BigDecimal;

public class Journey { // Gathers one Journey's details and stores it

    // Attributes
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

    // Constructor
    public Journey(int journeyId, String journeyDate, int fromZone, int toZone,
                   String timeBand, String passengerType, int zonesCrossed, BigDecimal baseFare,
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

    public BigDecimal getDiscountedFare() {
        return discountedFare;
    }

    public BigDecimal getChargedFare() {
        return chargedFare;
    }

    public BigDecimal getDiscountAmount() {
        return baseFare.subtract(discountedFare);
    }

    public void displayJourney() {
        System.out.println("Journey ID: " + journeyId);
        System.out.println("Date: " + journeyDate);
        System.out.println("From Zone: " + fromZone);
        System.out.println("To Zone: " + toZone);
        System.out.println("Time Band: " + timeBand);
        System.out.println("Passenger Type: " + passengerType);
        System.out.println("Zones Crossed: " + zonesCrossed);
        System.out.println("Base Fare: £" + baseFare);
        System.out.println("Discount Applied: £" + getDiscountAmount());
        System.out.println("Charged Fare: £" + chargedFare);
        System.out.println();
    }
}
