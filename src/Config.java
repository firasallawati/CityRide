import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Config { // Stores system fare configuration

    // Attributes
    private HashMap<String, BigDecimal> baseFares;
    private HashMap<String, BigDecimal> passengerDiscounts;
    private HashMap<String, BigDecimal> dailyCaps;
    private ArrayList<String> peakWindows;
    private String adminPassword;

    // Constructor
    public Config() {
        baseFares = new HashMap<>();
        passengerDiscounts = new HashMap<>();
        dailyCaps = new HashMap<>();
        peakWindows = new ArrayList<>();
        adminPassword = "admin123";
        loadDefaultValues();
    }

    // Get Methods
    public HashMap<String, BigDecimal> getBaseFares() {
        return baseFares;
    }

    public HashMap<String, BigDecimal> getPassengerDiscounts() {
        return passengerDiscounts;
    }

    public HashMap<String, BigDecimal> getDailyCaps() {
        return dailyCaps;
    }

    public ArrayList<String> getPeakWindows() {
        return peakWindows;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    // Set Methods
    public void setBaseFares(HashMap<String, BigDecimal> baseFares) {
        this.baseFares = baseFares;
    }

    public void setPassengerDiscounts(HashMap<String, BigDecimal> passengerDiscounts) {
        this.passengerDiscounts = passengerDiscounts;
    }

    public void setDailyCaps(HashMap<String, BigDecimal> dailyCaps) {
        this.dailyCaps = dailyCaps;
    }

    public void setPeakWindows(ArrayList<String> peakWindows) {
        this.peakWindows = peakWindows;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public void loadDefaultValues() {
        baseFares.clear();
        passengerDiscounts.clear();
        dailyCaps.clear();
        peakWindows.clear();

        addFarePair(1, 1, "2.50", "2.00");
        addFarePair(1, 2, "3.20", "2.70");
        addFarePair(1, 3, "3.80", "3.20");
        addFarePair(1, 4, "4.40", "3.70");
        addFarePair(1, 5, "5.10", "4.30");
        addFarePair(2, 2, "2.30", "1.90");
        addFarePair(2, 3, "2.90", "2.40");
        addFarePair(2, 4, "3.50", "2.90");
        addFarePair(2, 5, "4.10", "3.40");
        addFarePair(3, 3, "2.20", "1.80");
        addFarePair(3, 4, "2.80", "2.30");
        addFarePair(3, 5, "3.40", "2.80");
        addFarePair(4, 4, "2.10", "1.70");
        addFarePair(4, 5, "2.70", "2.20");
        addFarePair(5, 5, "2.00", "1.60");

        passengerDiscounts.put("Adult", new BigDecimal("0.00"));
        passengerDiscounts.put("Student", new BigDecimal("0.25"));
        passengerDiscounts.put("Child", new BigDecimal("0.50"));
        passengerDiscounts.put("Senior Citizen", new BigDecimal("0.30"));

        dailyCaps.put("Adult", new BigDecimal("8.00"));
        dailyCaps.put("Student", new BigDecimal("6.00"));
        dailyCaps.put("Child", new BigDecimal("4.00"));
        dailyCaps.put("Senior Citizen", new BigDecimal("7.00"));

        peakWindows.add("06:30-09:30");
        peakWindows.add("16:00-19:00");
    }

    public void addFarePair(int zoneA, int zoneB, String peakFare, String offPeakFare) {
        baseFares.put(zoneA + "-" + zoneB + "-Peak", new BigDecimal(peakFare));
        baseFares.put(zoneA + "-" + zoneB + "-Off-Peak", new BigDecimal(offPeakFare));

        if (zoneA != zoneB) {
            baseFares.put(zoneB + "-" + zoneA + "-Peak", new BigDecimal(peakFare));
            baseFares.put(zoneB + "-" + zoneA + "-Off-Peak", new BigDecimal(offPeakFare));
        }
    }
}