import org.example.Car;
import org.example.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void testCalculateCost1() {
        Car a = new Car("Mercedez", Vehicle.Quality.HIGH, Car.Size.LARGE, false);

        double expected = 225;

        Assertions.assertEquals(expected, a.calculateCost());
    }

    @Test
    public void testCalculateCost2() {
        Car a = new Car("Tesla", Vehicle.Quality.MEDIUM, Car.Size.MEDIUM, true);

        double expected = 200;

        Assertions.assertEquals(expected, a.calculateCost());
    }
}
