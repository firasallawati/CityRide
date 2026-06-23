import java.math.BigDecimal;
import java.util.Scanner;

public class AdminService { // Handles admin login and config changes

    // Constructor
    public AdminService() {
    }

    public boolean login(String password, Config config) {
        if (config.getAdminPassword().equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void displayConfig(Config config) {
        System.out.println("Active Configuration");
        System.out.println("Admin Password: " + config.getAdminPassword());
        System.out.println("Passenger Discounts: " + config.getPassengerDiscounts());
        System.out.println("Daily Caps: " + config.getDailyCaps());
        System.out.println("Peak Windows: " + config.getPeakWindows());
        System.out.println("Base Fares: " + config.getBaseFares());
    }

    public void updatePassengerDiscount(Config config, String passengerType, BigDecimal discount) {
        if (discount.compareTo(BigDecimal.ZERO) < 0 || discount.compareTo(BigDecimal.ONE) > 0) {
            System.out.println("Invalid discount value.");
        }
        else {
            config.getPassengerDiscounts().put(passengerType, discount);
            System.out.println("Passenger discount updated successfully.");
        }
    }

    public void deletePassengerDiscount(Config config, String passengerType) {
        if (config.getPassengerDiscounts().containsKey(passengerType)) {
            config.getPassengerDiscounts().remove(passengerType);
            System.out.println("Passenger discount deleted successfully.");
        }
        else {
            System.out.println("Passenger type not found.");
        }
    }

    public void updateDailyCap(Config config, String passengerType, BigDecimal cap) {
        if (cap.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid daily cap.");
        }
        else {
            config.getDailyCaps().put(passengerType, cap);
            System.out.println("Daily cap updated successfully.");
        }
    }

    public void deleteDailyCap(Config config, String passengerType) {
        if (config.getDailyCaps().containsKey(passengerType)) {
            config.getDailyCaps().remove(passengerType);
            System.out.println("Daily cap deleted successfully.");
        }
        else {
            System.out.println("Passenger type not found.");
        }
    }

    public void updateBaseFare(Config config, String fareKey, BigDecimal fare) {
        if (fare.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid base fare.");
        }
        else {
            config.getBaseFares().put(fareKey, fare);
            System.out.println("Base fare updated successfully.");
        }
    }

    public void deleteBaseFare(Config config, String fareKey) {
        if (config.getBaseFares().containsKey(fareKey)) {
            config.getBaseFares().remove(fareKey);
            System.out.println("Base fare deleted successfully.");
        }
        else {
            System.out.println("Base fare key not found.");
        }
    }

    public void addPeakWindow(Config config, String peakWindow) {
        if (peakWindow == null || peakWindow.trim().equals("")) {
            System.out.println("Invalid peak window.");
        }
        else {
            config.getPeakWindows().add(peakWindow);
            System.out.println("Peak window added successfully.");
        }
    }

    public void deletePeakWindow(Config config, String peakWindow) {
        if (config.getPeakWindows().remove(peakWindow)) {
            System.out.println("Peak window deleted successfully.");
        }
        else {
            System.out.println("Peak window not found.");
        }
    }
}