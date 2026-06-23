public class InputValidator {

    public InputValidator() {
    }

    public boolean isValidZone(int zone) {
        boolean isValidZone;

        if (zone >= 1 && zone <= 5) {
            isValidZone = true;
        }
        else {
            isValidZone = false;
        }

        return isValidZone;
    }

    public boolean isValidTimeBand(String timeBand) {
        boolean isValidTimeBand;

        if (timeBand.equalsIgnoreCase("Peak")) {
            isValidTimeBand = true;
        }
        else if (timeBand.equalsIgnoreCase("Off-Peak")) {
            isValidTimeBand = true;
        }
        else if (timeBand.equalsIgnoreCase("Off Peak")) {
            isValidTimeBand = true;
        }
        else {
            isValidTimeBand = false;
        }

        return isValidTimeBand;
    }

    public boolean isValidPassengerType(String passengerType) {
        boolean isValidPassengerType;

        if (passengerType.equals("Adult")) {
            isValidPassengerType = true;
        }
        else if (passengerType.equals("Student")) {
            isValidPassengerType = true;
        }
        else if (passengerType.equals("Child")) {
            isValidPassengerType = true;
        }
        else if (passengerType.equals("Senior Citizen")) {
            isValidPassengerType = true;
        }
        else {
            isValidPassengerType = false;
        }

        return isValidPassengerType;
    }

    public boolean isValidPaymentOption(String paymentOption) {
        boolean isValidPaymentOption;

        if (paymentOption.equals("Cash")) {
            isValidPaymentOption = true;
        }
        else if (paymentOption.equals("Card")) {
            isValidPaymentOption = true;
        }
        else {
            isValidPaymentOption = false;
        }

        return isValidPaymentOption;
    }

    public boolean isBlank(String text) {
        boolean isBlankText;

        if (text == null || text.trim().equals("")) {
            isBlankText = true;
        }
        else {
            isBlankText = false;
        }

        return isBlankText;
    }

    public boolean isNumeric(String text) {
        boolean isNumericText;

        try {
            Integer.parseInt(text);
            isNumericText = true;
        }
        catch (Exception e) {
            isNumericText = false;
        }

        return isNumericText;
    }

    public boolean isDecimal(String text) {
        boolean isDecimalText;

        try {
            Double.parseDouble(text);
            isDecimalText = true;
        }
        catch (Exception e) {
            isDecimalText = false;
        }

        return isDecimalText;
    }

    public boolean isPositiveDecimal(String text) {
        boolean isPositiveDecimal;
        double decimalNumber;

        if (isDecimal(text)) {
            decimalNumber = Double.parseDouble(text);

            if (decimalNumber >= 0) {
                isPositiveDecimal = true;
            }
            else {
                isPositiveDecimal = false;
            }
        }
        else {
            isPositiveDecimal = false;
        }

        return isPositiveDecimal;
    }

    public boolean isValidDiscountDecimal(String text) {
        boolean isValidDiscount;
        double discountValue;

        if (isDecimal(text)) {
            discountValue = Double.parseDouble(text);

            if (discountValue >= 0 && discountValue <= 1) {
                isValidDiscount = true;
            }
            else {
                isValidDiscount = false;
            }
        }
        else {
            isValidDiscount = false;
        }

        return isValidDiscount;
    }

    public boolean isYesNo(String text) {
        boolean isYesNoAnswer;

        if (text.equalsIgnoreCase("yes")) {
            isYesNoAnswer = true;
        }
        else if (text.equalsIgnoreCase("no")) {
            isYesNoAnswer = true;
        }
        else {
            isYesNoAnswer = false;
        }

        return isYesNoAnswer;
    }

    public boolean isValidFareKey(String fareKey) {
        boolean isValidFareKey;
        String[] fareKeyParts;
        int fromZone;
        int toZone;
        String timeBand;

        if (fareKey == null || fareKey.trim().equals("")) {
            isValidFareKey = false;
        }
        else {
            fareKeyParts = fareKey.split("-", 3);

            if (fareKeyParts.length != 3) {
                isValidFareKey = false;
            }
            else if (!isNumeric(fareKeyParts[0]) || !isNumeric(fareKeyParts[1])) {
                isValidFareKey = false;
            }
            else {
                fromZone = Integer.parseInt(fareKeyParts[0]);
                toZone = Integer.parseInt(fareKeyParts[1]);
                timeBand = fareKeyParts[2];

                if (!isValidZone(fromZone) || !isValidZone(toZone)) {
                    isValidFareKey = false;
                }
                else if (!isValidTimeBand(timeBand)) {
                    isValidFareKey = false;
                }
                else {
                    isValidFareKey = true;
                }
            }
        }

        return isValidFareKey;
    }

    public boolean isValidPeakWindow(String peakWindow) {
        boolean isValidPeakWindow;
        String[] peakWindowParts;
        String[] startTimeParts;
        String[] endTimeParts;
        int startHour;
        int startMinute;
        int endHour;
        int endMinute;

        if (peakWindow == null || peakWindow.trim().equals("")) {
            isValidPeakWindow = false;
        }
        else {
            peakWindowParts = peakWindow.split("-");

            if (peakWindowParts.length != 2) {
                isValidPeakWindow = false;
            }
            else {
                startTimeParts = peakWindowParts[0].split(":");
                endTimeParts = peakWindowParts[1].split(":");

                if (startTimeParts.length != 2 || endTimeParts.length != 2) {
                    isValidPeakWindow = false;
                }
                else if (!isNumeric(startTimeParts[0]) || !isNumeric(startTimeParts[1])) {
                    isValidPeakWindow = false;
                }
                else if (!isNumeric(endTimeParts[0]) || !isNumeric(endTimeParts[1])) {
                    isValidPeakWindow = false;
                }
                else {
                    startHour = Integer.parseInt(startTimeParts[0]);
                    startMinute = Integer.parseInt(startTimeParts[1]);
                    endHour = Integer.parseInt(endTimeParts[0]);
                    endMinute = Integer.parseInt(endTimeParts[1]);

                    if (startHour < 0 || startHour > 23) {
                        isValidPeakWindow = false;
                    }
                    else if (endHour < 0 || endHour > 23) {
                        isValidPeakWindow = false;
                    }
                    else if (startMinute < 0 || startMinute > 59) {
                        isValidPeakWindow = false;
                    }
                    else if (endMinute < 0 || endMinute > 59) {
                        isValidPeakWindow = false;
                    }
                    else {
                        isValidPeakWindow = true;
                    }
                }
            }
        }

        return isValidPeakWindow;
    }
}