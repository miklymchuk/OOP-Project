package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Car extends Vehicle implements Pricing {
    String size;
    boolean isElectric;

    public Car(String model, String quality, String size, Boolean isElectric) {
        super(model, quality);
        this.size = size;
        this.isElectric = isElectric;
    }

    public double calculateCost() {
        double cost = isElectric ? 200 : 150;

        switch (size) {
            case "small" -> cost*= 0.75;
            case "large" -> cost*= 1.25;
            default -> cost*= 1;
        }

        switch (quality) {
            case "low" -> cost*= 0.6;
            case "high" -> cost*= 1.2;
            case "perfect" -> cost*= 1.5;
            default -> cost*= 1;
        }

        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(size, car.size) && Objects.equals(isElectric, car.isElectric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, isElectric);
    }

    @Override
    public String toString() {
        return "Car{" +
                "isElectric=" + isElectric +
                ", size='" + size + '\'' +
                "} " + super.toString();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getElectric() {
        return isElectric;
    }

    public void setElectric(Boolean electric) {
        isElectric = electric;
    }

    public static class CostComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return (int) (o1.calculateCost() - o2. calculateCost());
        }
    }
}
