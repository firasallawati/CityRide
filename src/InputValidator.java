public class InputValidator { // Checks if user input is valid

    // Constructor
    public InputValidator() {
    }

    public boolean isValidZone(int zone) {
        if (zone >= 1 && zone <= 5) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isValidTimeBand(String timeBand) {
        boolean isValid = false;

        if (timeBand.equalsIgnoreCase("Peak")) {
            return true;
        }
        else if (timeBand.equalsIgnoreCase("Off Peak")) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isValidPassengerType(String passengerType) {

        if (passengerType.equalsIgnoreCase("Adult")) {
            return true;
        } else if (passengerType.equalsIgnoreCase("Student")) {
            return true;
        } else if (passengerType.equalsIgnoreCase("Child")) {
            return true;
        } else if (passengerType.equalsIgnoreCase("Senior Citizen")) {
            return true;
        }
        return false;
    }

    public boolean isBlank(String text) {
        if (text == null || text.trim().equals("")) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
