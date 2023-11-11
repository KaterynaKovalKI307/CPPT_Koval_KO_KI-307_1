package KI307.Koval.Lab3;

import java.io.FileNotFoundException;

interface WaterActions {
    void dirtyWater();

    void clearWater();
}

public class Sea extends WaterBody implements WaterActions {
    public Sea(String name, int area, String type) {
        super(name, area, type);
        // Виклик конструктора з класу WaterBody для ініціалізації полів
    }

    // Реалізація методів інтерфейсу WaterActions
    @Override
    public void dirtyWater() {
        this.isPolluted = true;
        System.out.println("Water is now polluted.");
    }

    @Override
    public void clearWater() {
        this.isPolluted = false;
        System.out.println("Water is now clear.");
    }

    
}
