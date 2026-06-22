import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigFileManager { // Saves and loads system config JSON files

    // Attributes
    private Gson gson;

    // Constructor
    public ConfigFileManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Get Methods
    public Config loadConfig(String fileName) {
        Config config = null;
        try {
            FileReader reader = new FileReader(fileName);
            config = gson.fromJson(reader, Config.class);
            reader.close();
            System.out.println("Config loaded successfully.");
        }
        catch (IOException e) {
            config = new Config();
            System.out.println("Config file not found. Safe defaults loaded.");
        }
        return config;
    }

    // Set Methods
    public void saveConfig(Config config, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            gson.toJson(config, writer);
            writer.close();
            System.out.println("Config saved successfully.");
        }
        catch (IOException e) {
            System.out.println("Error saving config.");
        }
    }
}