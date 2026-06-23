import java.math.BigDecimal;

public class AdminService {

    public AdminService() {
    }

    public boolean login(String password, Config config) {
        boolean isCorrectPassword;

        if (config.getAdminPassword().equals(password)) {
            isCorrectPassword = true;
        }
        else {
            isCorrectPassword = false;
        }

        return isCorrectPassword;
    }

    public void displayConfig(Config config) {
        System.out.println("Active Configuration");
        System.out.println("Admin Password: " + config.getAdminPassword());
        System.out.println("Passenger Discounts: " + config.getPassengerDiscounts());
        System.out.println("Daily Caps: " + config.getDailyCaps());
        System.out.println("Peak Windows: " + config.getPeakWindows());
        System.out.println("Base Fares: " + config.getBaseFares());
    }

    public void updatePassengerDiscount(Config config, String passengerType, BigDecimal discountValue) {
        if (discountValue.compareTo(BigDecimal.ZERO) < 0 || discountValue.compareTo(BigDecimal.ONE) > 0) {
            System.out.println("Invalid discount value. Enter a value between 0 and 1.");
        }
        else {
            config.getPassengerDiscounts().put(passengerType, discountValue);
            System.out.println("Passenger discount updated successfully.");
        }
    }

    public void deletePassengerDiscount(Config config, String passengerType) {
        if (config.getPassengerDiscounts().containsKey(passengerType)) {
            config.getPassengerDiscounts().remove(passengerType);
            System.out.println("Passenger discount deleted successfully.");
        }
        else {
            System.out.println("Passenger discount not found.");
        }
    }

    public void updateDailyCap(Config config, String passengerType, BigDecimal dailyCapValue) {
        if (dailyCapValue.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid daily cap value.");
        }
        else {
            config.getDailyCaps().put(passengerType, dailyCapValue);
            System.out.println("Daily cap updated successfully.");
        }
    }

    public void deleteDailyCap(Config config, String passengerType) {
        if (config.getDailyCaps().containsKey(passengerType)) {
            config.getDailyCaps().remove(passengerType);
            System.out.println("Daily cap deleted successfully.");
        }
        else {
            System.out.println("Daily cap not found.");
        }
    }

    public void updateBaseFare(Config config, String fareKey, BigDecimal fareAmount) {
        if (fareAmount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid base fare amount.");
        }
        else {
            config.getBaseFares().put(fareKey, fareAmount);
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
        if (config.getPeakWindows().contains(peakWindow)) {
            System.out.println("Peak window already exists.");
        }
        else {
            config.getPeakWindows().add(peakWindow);
            System.out.println("Peak window added successfully.");
        }
    }

    public void deletePeakWindow(Config config, String peakWindow) {
        if (config.getPeakWindows().contains(peakWindow)) {
            config.getPeakWindows().remove(peakWindow);
            System.out.println("Peak window deleted successfully.");
        }
        else {
            System.out.println("Peak window not found.");
        }
    }
}