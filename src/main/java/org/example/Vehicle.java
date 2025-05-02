package org.example;

import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle> {
    protected String model;
    protected String quality;

    public Vehicle(String model, String quality) {
        this.model = model;
        this.quality = quality;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(model, vehicle.model) && Objects.equals(quality, vehicle.quality);
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.model.compareTo(o.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, quality);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", quality='" + quality + '\'' +
                '}';
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
