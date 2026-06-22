import java.math.BigDecimal;

public class Journey { // Gathers ones journey details and stores it

    // Attributes
    private int journeyId;
    private String journeyDate;
    private int fromZone;
    private int toZone;
    private String timeBand;
    private String passengerType;
    private int zonesCrossed;
    private BigDecimal baseFare;
    private BigDecimal discountApplied;
    private BigDecimal chargedFare;

    // Constructors
    public Journey(int journeyId, String journeyDate, int fromZone, int toZone, String timeBand,
                   String passengerType, int zonesCrossed, BigDecimal baseFare,
                   BigDecimal discountApplied, BigDecimal chargedFare) {
        this.journeyId = journeyId;
        this.journeyDate = journeyDate;
        this.fromZone = fromZone;
        this.toZone = toZone;
        this.timeBand = timeBand;
        this.passengerType = passengerType;
        this.zonesCrossed = zonesCrossed;
        this.baseFare = baseFare;
        this.discountApplied = discountApplied;
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

    public BigDecimal getDiscountApplied() {
        return discountApplied;
    }

    public BigDecimal getChargedFare() {
        return chargedFare;
    }

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

    public void setZonesCrossed(int zonesCrossed) {
        this.zonesCrossed = zonesCrossed;
    }

    public void setBaseFare(BigDecimal baseFare) {
        this.baseFare = baseFare;
    }

    public void setDiscountApplied(BigDecimal discountApplied) {
        this.discountApplied = discountApplied;
    }

    public void setChargedFare(BigDecimal chargedFare) {
        this.chargedFare = chargedFare;
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
        System.out.println("Discount Applied: £" + discountApplied);
        System.out.println("Charged Fare: £" + chargedFare);
        System.out.println();
    }
}