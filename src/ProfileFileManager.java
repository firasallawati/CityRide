import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProfileFileManager { // Saves and loads RiderProfile JSON files

    // Attributes
    private Gson gson;

    // Constructor
    public ProfileFileManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Get Methods
    public RiderProfile loadProfile(String fileName) {
        RiderProfile profile = null;
        try {
            FileReader reader = new FileReader(fileName);
            profile = gson.fromJson(reader, RiderProfile.class);
            reader.close();
        }
        catch (IOException e) {
            System.out.println("Error loading profile.");
        }
        return profile;
    }

    // Set Methods
    public void saveProfile(RiderProfile profile, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            gson.toJson(profile, writer);
            writer.close();
            System.out.println("Profile saved successfully.");
        }
        catch (IOException e) {
            System.out.println("Error saving profile.");
        }
    }
}