import java.util.ArrayList;
import java.util.List;

public class RiderProfile {
    private String name;
    private String passengerType;
    private String defaultPaymentOption;
    private ArrayList<Journey> journeys;

    public RiderProfile() {
        this.journeys = new ArrayList<>();
    }

    public RiderProfile(String name, String passengerType, String defaultPaymentOption) {
        this.name = name;
        this.passengerType = passengerType;
        this.defaultPaymentOption = defaultPaymentOption;
        this.journeys = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public String getDefaultPaymentOption() {
        return defaultPaymentOption;
    }

    public ArrayList<Journey> getJourneys() {
        return journeys;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public void setDefaultPaymentOption(String defaultPaymentOption) {
        this.defaultPaymentOption = defaultPaymentOption;
    }

    public void setJourneys(ArrayList<Journey> journeys) {
        this.journeys = journeys;
    }

    public void addJourney(Journey journey) {
        journeys.add(journey);
    }

    public boolean removeJourneyById(int journeyId) {
        for (int i = 0; i < journeys.size(); i++) {
            if (journeys.get(i).getJourneyId() == journeyId) {
                journeys.remove(i);
                return true;
            }
        }
        return false;
    }

    public Journey findJourneyById(int journeyId) {
        for (Journey journey : journeys) {
            if (journey.getJourneyId() == journeyId) {
                return journey;
            }
        }
        return null;
    }
}