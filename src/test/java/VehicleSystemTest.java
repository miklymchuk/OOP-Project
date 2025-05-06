import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleSystemTest {

    @Test
    public void testAddVehicleToMap1() {
        VehicleSystem.initVehicles();
        Map<String, List<Vehicle>> expected = new HashMap<>();
        List<Vehicle> a = new ArrayList<Vehicle>();

        Truck chevy = new Truck("Chevrolet", "medium", "small");
        a.add(chevy);

        expected.put("car", new ArrayList<Vehicle>());
        expected.put("truck", a);
        expected.put("bike", new ArrayList<Vehicle>());

        VehicleSystem.addVehicleToMap(chevy);

        Assertions.assertEquals(expected, VehicleSystem.vehicles);
    }

    @Test
    public void testAddVehicleToMap2() {
        VehicleSystem.initVehicles();
        Map<String, List<Vehicle>> expected = new HashMap<>();
        Map<String, List<Vehicle>> prepList = new HashMap<>();
        List<Vehicle> a = new ArrayList<>();

        Bike aa = new Bike("A", "low", false);
        Bike bb = new Bike("B", "perfect", true);

        a.add(aa);

        prepList.put("car", new ArrayList<Vehicle>());
        prepList.put("truck", new ArrayList<Vehicle>());
        prepList.put("bike", a);

        a.add(bb);

        expected.put("car", new ArrayList<Vehicle>());
        expected.put("truck", new ArrayList<Vehicle>());
        expected.put("bike", a);

        VehicleSystem.vehicles = prepList;
        VehicleSystem.addVehicleToMap(bb);

        Assertions.assertEquals(expected, VehicleSystem.vehicles);
    }

    @Test
    public void testFilter() {
        VehicleSystem.initVehicles();
        List<Vehicle> a = new ArrayList<>();

        Car ford = new Car("Ford", "medium", "large", false);
        Car audi = new Car("Audi", "high", "medium", true);
        VehicleSystem.addVehicleToMap(ford);
        VehicleSystem.addVehicleToMap(audi);

        Map<Vehicle, Double> expected = new HashMap<>();
        expected.put(ford, ford.calculateCost());

        Assertions.assertEquals(expected, VehicleSystem.filter(241));
    }
}
