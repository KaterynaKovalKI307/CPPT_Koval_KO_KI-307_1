package KI307.Koval.Lab2;

/**
 * A sample application to demonstrate the functionalities of the WaterBody class.
 */
public class WaterBodyApp {
    public static void main(String[] args) {
        WaterBody river = new WaterBody("Nile", 6650, "River");
        System.out.println("Initial Details:");
        river.printDetails();

        river.setName("Amazon");
        river.setArea(7000);
        river.setType("River");

        river.depthChange(10);
        river.absorbWater(50);
        river.evaporate(20);

        river.pollute();

        System.out.println("\nModified Details:");
        river.printDetails();

        river.closeLogFile();
    }
}
