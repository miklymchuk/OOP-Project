package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Truck extends Vehicle implements Pricing {
    TruckSize size;

    public Truck(String model, Quality quality, TruckSize size) {
        super(model, quality);
        this.size = size;
    }

    public double calculateCost() {
        double cost = 250;

        switch (size) {
            case SMALL -> cost*= 0.6;
            case LARGE -> cost*= 1.5;
            default -> cost*=1;
        }

        switch (quality) {
            case LOW -> cost*= 0.8;
            case HIGH -> cost*= 1.15;
            case PERFECT -> cost*= 1.4;
            default -> cost*= 1;
        }

        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return Objects.equals(size, truck.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "size='" + size + '\'' +
                "} " + super.toString();
    }

    public TruckSize getSize() {
        return size;
    }

    public void setSize(TruckSize size) {
        this.size = size;
    }

    public enum TruckSize {
        SMALL,
        MEDIUM,
        LARGE
    }

    public static class CostComparator implements Comparator<Truck> {
        @Override
        public int compare(Truck o1, Truck o2) {
            return (int) (o1.calculateCost() - o2.calculateCost());
        }
    }
}
