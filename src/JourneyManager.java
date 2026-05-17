import java.util.ArrayList;

public class JourneyManager { // In charge of the whole list of Journeys stored

    // Attributes
    private ArrayList<Journey> journeys;

    // Constructor
    public JourneyManager() {
        journeys = new ArrayList<>();
    }

    public void addJourney(Journey journey) { // Adds new journey to the array
        System.out.println("Add Journey"); // Not Finished
    }

    public void displayAllJourneys() { // Display stored journeys
        System.out.println("List Journeys"); // Not Finished
    }

    public void removeJourneyById(int journeyId) { // Delete Journey using unique ID
        System.out.println("Remove Journey"); // Not Finished
    }

    public void resetJourneys() { // Delete all stored journeys
        System.out.println("Reset Day"); // Not Finished
    }
}
