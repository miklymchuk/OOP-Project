package org.example;

import java.util.*;

public class VehicleSystem {
    public static Map<String, List<Vehicle>> vehicles = new HashMap<>();

    public static void initVehicles() {
        vehicles.put("car", new ArrayList<Vehicle>());
        vehicles.put("truck", new ArrayList<Vehicle>());
        vehicles.put("bike", new ArrayList<Vehicle>());
    }

    public static void addVehicleToMap(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            List<Vehicle> cars = vehicles.get("car");
            cars.add(vehicle);
            vehicles.replace("car", cars);
        } else if (vehicle instanceof Truck) {
            List<Vehicle> trucks = vehicles.get("truck");
            trucks.add(vehicle);
            vehicles.replace("truck", trucks);
        } else {
            List<Vehicle> bikes = vehicles.get("bike");
            bikes.add(vehicle);
            vehicles.replace("bike", bikes);
        }
    }

    public static Map<Vehicle, Double> filter(int key) {
        Map<Vehicle, Double> filteredVehicles = new HashMap<>();
        Scanner scanner = new Scanner(System.in);


        if (key == 1) {
            List<Vehicle> a = vehicles.get("car");
            List<Car> cars = new ArrayList<>();

            for (Vehicle v : a) {
                if (v instanceof Car) {
                    cars.add((Car) v);
                }
            }

            int input = 0;
            while (input < 1 || input > 4) {
                System.out.println("""
                        If you want to filter by maximum cost, enter 1
                        If you want to filter by quality, enter 2
                        If you want to filter by size, enter 3
                        If you want to filter by electric cars, enter 4
                        """);
                input = scanner.nextInt();
            }

            if (input == 1) {
                cars.sort(new Car.CostComparator());

                int maxCost = scanner.nextInt();
                cars.stream()
                        .filter(car -> car.calculateCost() < maxCost)
                        .forEach(car -> filteredVehicles.put(car, car.calculateCost()));

            } else if (input == 2) {
                Collections.sort(cars);
                String quality = "";
                while (!((quality == "low") || (quality == "medium") || (quality == "high") || (quality == "perfect"))) {
                    quality = scanner.nextLine();
                }

                String finalQuality = quality;
                cars.stream()
                        .filter(car -> car.getQuality().equals(finalQuality))
                        .forEach(car -> filteredVehicles.put(car, car.calculateCost()));
            } else if (input == 3) {
                Collections.sort(cars);
                String size = "";
                while (!((size == "small") || (size == "medium") || (size == "large"))) {
                    System.out.println("Enter the size of car you are looking for.");
                    size = scanner.nextLine();
                }

                String finalSize = size;
                cars.stream()
                        .filter(car -> car.getSize().equals(finalSize))
                        .forEach(car -> filteredVehicles.put(car, car.calculateCost()));
            } else {
                Collections.sort(cars);
                System.out.println("""
                        Enter 1 if you want an electric car
                        Enter anything else if you don't want an electric car""");
                input = scanner.nextInt();

                boolean electric = false;
                if (input == 1) {
                    electric = true;
                }

                cars.stream()
                        .filter(Car::getElectric)
                        .forEach(car -> filteredVehicles.put(car, car.calculateCost()));
            }
        } else if (key == 2) {

        } else {

        }
        return filteredVehicles;
    }
}
