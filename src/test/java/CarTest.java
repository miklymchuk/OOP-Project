import org.example.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void testCalculateCost1() {
        Car a = new Car("Mercedez", "high", "large", false);

        double expected = 225;

        Assertions.assertEquals(expected, a.calculateCost());
    }

    @Test
    public void testCalculateCost2() {
        Car a = new Car("Tesla", "medium", "medium", true);

        double expected = 200;

        Assertions.assertEquals(expected, a.calculateCost());
    }
}
