public class InputValidator { // Checks if user input is valid

    // Constructor
    public InputValidator() {
    }

    public boolean isValidZone(int zone) {
        boolean isValid = false;

        if (zone >= 1 && zone <= 5) {
            isValid = true;
        }
        return isValid;
    }

    public boolean isValidTimeBand(String timeBand) {
        boolean isValid = false;

        if ("Peak".equalsIgnoreCase(timeBand)) {
            isValid = true;
        } else if ("Off-Peak".equalsIgnoreCase(timeBand)) {
            isValid = true;
        }
        return isValid;
    }

    public boolean isValidPassengerType(String passengerType) {
        boolean isValid = false;

        if (passengerType.equalsIgnoreCase("Adult")) {
            isValid = true;
        } else if (passengerType.equalsIgnoreCase("Student")) {
            isValid = true;
        } else if (passengerType.equalsIgnoreCase("Child")) {
            isValid = true;
        } else if (passengerType.equalsIgnoreCase("Senior Citizen")) {
            isValid = true;
        }
        return isValid;
    }
}
