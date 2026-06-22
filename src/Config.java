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
        baseFares.put("1-1-Peak", new BigDecimal("2.50"));
        baseFares.put("1-1-Off-Peak", new BigDecimal("2.00"));
        baseFares.put("1-2-Peak", new BigDecimal("3.20"));
        baseFares.put("1-2-Off-Peak", new BigDecimal("2.70"));

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
}