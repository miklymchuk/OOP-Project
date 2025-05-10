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

        if (key % 10 == 1) {
            List<Vehicle> carVehicles = vehicles.get("car");
            List<Car> cars = new ArrayList<>();

            for (Vehicle v : carVehicles) {
                cars.add((Car) v);
            }

            key /= 10;

            if (key % 10 == 1) {
                cars.sort(new Car.CostComparator());

                int maxCost = scanner.nextInt();
                cars.stream()
                        .filter(car -> car.calculateCost() < maxCost)
                        .forEach(car -> filteredVehicles.put(car, car.calculateCost()));

            } else if (key % 10 == 2) {
                Collections.sort(cars);

                String quality = "";
                while (!((quality.equals("low")) || (quality.equals("medium")) || (quality.equals("high")) || (quality.equals("perfect")))) {
                    quality = scanner.nextLine();
                }

                String finalQuality = quality;
                cars.stream()
                        .filter(car -> finalQuality.equalsIgnoreCase(car.getQuality().name()))
                        .forEach(car -> filteredVehicles.put(car, car.calculateCost()));
            } else if (key % 10 == 3) {
                Collections.sort(cars);
                String size = "";
                while (!((size.equals("small")) || (size.equals("medium")) || (size.equals("large")))) {
                    System.out.println("Enter the size of car you are looking for.");
                    size = scanner.nextLine();
                }

                String finalSize = size;
                cars.stream()
                        .filter(car -> finalSize.equalsIgnoreCase(car.getSize().name()))
                        .forEach(car -> filteredVehicles.put(car, car.calculateCost()));
            } else {
                Collections.sort(cars);
                key /= 10;

                boolean electric;
                if (key % 10 == 1) {
                    electric = true;
                } else {
                    electric = false;
                }

                cars.stream()
                        .filter(car -> car.getElectric() == electric)
                        .forEach(car -> filteredVehicles.put(car, car.calculateCost()));
            }
        } else if (key % 10 == 2) {
            List<Vehicle> truckVehicles = vehicles.get("truck");
            List<Truck> trucks = new ArrayList<>();

            for (Vehicle v : truckVehicles) {
                trucks.add((Truck) v);
            }
            key /= 10;

            if (key % 10 == 1) {
                trucks.sort(new Truck.CostComparator());

                int maxCost = scanner.nextInt();
                trucks.stream()
                        .filter(truck -> truck.calculateCost() <= maxCost)
                        .forEach(truck -> filteredVehicles.put(truck, truck.calculateCost()));
            } else if (key % 10 == 2) {
                Collections.sort(trucks);

                String quality = "";
                while (!((quality.equals("LOW")) || (quality.equals("medium")) || (quality.equals("high")) || (quality.equals("perfect")))) {
                    quality = scanner.nextLine();
                }

                String finalQuality = quality;

                trucks.stream()
                        .filter(truck -> finalQuality.equalsIgnoreCase(truck.getQuality().name()))
                        .forEach(truck -> filteredVehicles.put(truck, truck.calculateCost()));
            } else {
                Collections.sort(trucks);
                String size = "";
                while (!((size.equals("small")) || (size.equals("medium")) || (size.equals("large")))) {
                    System.out.println("Enter the size of car you are looking for.");
                    size = scanner.nextLine();
                }

                String finalSize = size;
                trucks.stream()
                        .filter(truck -> finalSize.equalsIgnoreCase(truck.getSize().name()))
                        .forEach(truck -> filteredVehicles.put(truck, truck.calculateCost()));
            }
        } else {
            List<Vehicle> bikeVehicles = vehicles.get("bike");
            List<Bike> bikes = new ArrayList<>();

            for (Vehicle v : bikeVehicles) {
                bikes.add((Bike) v);
            }
            key /= 10;

            if (key % 10 == 1) {
                bikes.sort(new Bike.CostComparator());

                int maxCost = scanner.nextInt();
                bikes.stream()
                        .filter(bike -> bike.calculateCost() <= maxCost)
                        .forEach(bike -> filteredVehicles.put(bike, bike.calculateCost()));
            } else if (key % 10 == 2) {
                Collections.sort(bikes);

                String quality = "";
                while (!((quality.equals("low")) || (quality.equals("medium")) || (quality.equals("high")) || (quality.equals("perfect")))) {
                    quality = scanner.nextLine();
                }

                String finalQuality = quality;

                bikes.stream()
                        .filter(bike -> finalQuality.equalsIgnoreCase(bike.getQuality().name()))
                        .forEach(bike -> filteredVehicles.put(bike, bike.calculateCost()));
            } else {
                key /= 10;

                boolean electric;
                if (key % 10 == 1) {
                    electric = true;
                } else {
                    electric = false;
                }

                bikes.stream()
                        .filter(bike -> bike.getElectric() == electric)
                        .forEach(bike -> filteredVehicles.put(bike, bike.calculateCost()));
            }
        }
        return filteredVehicles;
    }
}
