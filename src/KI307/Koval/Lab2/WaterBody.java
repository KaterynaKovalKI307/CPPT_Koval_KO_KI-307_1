package KI307.Koval.Lab2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents a body of water with various attributes and behaviors.
 */
public class WaterBody {
    private String name;
    private int area;
    private String type;
    private boolean isPolluted;
    private int depth;

    /**
     * Constructs a WaterBody with specified name, area, and type.
     * @param name The name of the water body.
     * @param area The area covered by the water body.
     * @param type The type of the water body.
     */
    public WaterBody(String name, int area, String type) {
        this.name = name;
        this.area = area;
        this.type = type;
        this.isPolluted = false;
        this.depth = 0;
    }

    /**
     * Constructs a WaterBody with a default name and unknown type.
     * @param name The name of the water body.
     */
    public WaterBody(String name) {
        this.name = name;
        this.area = 0;
        this.type = "Unknown";
        this.isPolluted = false;
        this.depth = 0;
    }

    /**
     * Sets the name of the water body.
     * @param name The name to set for the water body.
     */
    public void setName(String name) {
        this.name = name;
        logActivity("Set name to " + name);
    }

    /**
     * Sets the area of the water body.
     * @param area The area to set for the water body.
     */
    public void setArea(int area) {
        this.area = area;
        logActivity("Set area to " + area);
    }

    /**
     * Sets the type of the water body.
     * @param type The type to set for the water body.
     */
    public void setType(String type) {
        this.type = type;
        logActivity("Set type to " + type);
    }

    /**
     * Gets the name of the water body.
     * @return The name of the water body.
     */
    public String getName() {
        logActivity("Accessed name: " + name);
        return name;
    }

    /**
     * Gets the area of the water body.
     * @return The area of the water body.
     */
    public int getArea() {
        logActivity("Accessed area: " + area);
        return area;
    }

    /**
     * Gets the type of the water body.
     * @return The type of the water body.
     */
    public String getType() {
        logActivity("Accessed type: " + type);
        return type;
    }

    /**
     * Increases the area of the water body by a specified amount.
     * @param additionalArea The additional area to increase.
     */
    public void increaseArea(int additionalArea) {
        this.area += additionalArea;
        logActivity("Increased area by " + additionalArea + " to " + area);
    }

    /**
     * Changes the type of the water body.
     * @param newType The new type to be set.
     */
    public void changeType(String newType) {
        this.type = newType;
        logActivity("Changed type to " + newType);
    }

    /**
     * Prints details about the water body including name, area, type, pollution status, and depth.
     */
    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Area: " + area);
        System.out.println("Type: " + type);
        System.out.println("Polluted: " + isPolluted);
        System.out.println("Depth: " + depth);
        logActivity("Printed details");
    }

    /**
     * Simulates the effect of rainfall on the water body's area.
     * @param rainfall The amount of rainfall.
     */
    public void rainfallEffect(int rainfall) {
        if (rainfall > 50) {
            increaseArea(rainfall);
            logActivity("Rainfall increased area by " + rainfall);
        } else {
            logActivity("Rainfall was not sufficient to increase area");
        }
    }

    /**
     * Simulates the pollution of the water body.
     */
    public void pollute() {
        this.isPolluted = true;
        logActivity("Water body is now polluted");
    }

    /**
     * Cleans the water body from pollution.
     */
    public void clean() {
        this.isPolluted = false;
        logActivity("Water body is now clean");
    }

    /**
     * Sets the depth of the water body.
     * @param depth The depth to set.
     */
    public void setDepth(int depth) {
        this.depth = depth;
        logActivity("Set depth to " + depth);
    }

    /**
     * Changes the depth of the water body.
     * @param change The change in depth.
     */
    public void depthChange(int change) {
        this.depth += change;
        logActivity("Changed depth by " + change + " to " + depth);
    }

    /**
     * Simulates the process of water evaporation from the water body.
     * @param amount The amount of water to be evaporated.
     */
    public void evaporate(int amount) {
        if (amount < depth) {
            depth -= amount;
            logActivity("Evaporated " + amount + " of water");
        } else {
            depth = 0;
            logActivity("Evaporated all water, depth is now 0");
        }
    }

    /**
     * Simulates the process of water absorption by the water body.
     * @param amount The amount of water to be absorbed.
     */
    public void absorbWater(int amount) {
        depth += amount;
        logActivity("Absorbed " + amount + " of water");
    }

    /**
     * Logs an activity to a file.
     * @param activity The activity to be logged.
     */
    private void logActivity(String activity) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(activity + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the log file after finishing with logging activities.
     * This method should be called at the end to ensure proper file closure.
     */
    public void closeLogFile() {
        // Method to close the file or handle the file closing process
        // This method should be called after finishing working with the log file
    }
}
