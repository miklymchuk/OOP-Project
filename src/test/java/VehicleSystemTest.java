import org.example.Bike;
import org.example.Truck;
import org.example.Vehicle;
import org.example.VehicleSystem;
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
}
