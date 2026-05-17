public class Journey { // Gathers one Journey's details and stores it

    // Attributes
    private int journeyId;
    private String journeyDate;
    private int fromZone;
    private int toZone;
    private String timeBand;
    private String passengerType;

    // Constructor
    public Journey(int journeyId, String journeyDate, int fromZone, int toZone, String timeBand, String passengerType) {
        this.journeyId = journeyId;
        this.journeyDate = journeyDate;
        this.fromZone = fromZone;
        this.toZone = toZone;
        this.timeBand = timeBand;
        this.passengerType = passengerType;
    }

    // Get Methods
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

    // Set Methods
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
}
