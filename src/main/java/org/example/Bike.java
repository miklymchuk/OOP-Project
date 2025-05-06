package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Bike extends Vehicle implements Pricing {
    Boolean isElectric;

    public Bike(String model, String quality, Boolean isElectric) {
        super(model, quality);
        this.isElectric = isElectric;
    }

    @Override
    public double calculateCost() {
        double cost = isElectric ? 100 : 80;

        switch (quality) {
            case "low" -> cost*= 0.8;
            case "high" -> cost*= 1.5;
            case "perfect" -> cost*= 2;
            default -> cost*= 1;
        }

        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bike bike = (Bike) o;
        return Objects.equals(isElectric, bike.isElectric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isElectric);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "isElectric=" + isElectric +
                "} " + super.toString();
    }

    public Boolean getElectric() {
        return isElectric;
    }

    public void setElectric(Boolean electric) {
        isElectric = electric;
    }

    public static class CostComparator implements Comparator<Bike> {
        @Override
        public int compare(Bike o1, Bike o2) {
            return (int) (o1.calculateCost() - o2.calculateCost());
        }
    }
}
