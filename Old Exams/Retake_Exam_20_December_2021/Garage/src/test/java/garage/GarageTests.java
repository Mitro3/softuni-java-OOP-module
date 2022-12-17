package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    private Garage garage;
    private Car car;
    private static final String CAR_MODEL = "Volkswagen";
    private static final int CAR_MAX_SPEED = 220;
    private static final double CAR_PRICE = 1000.20;

    @Before
    public void setUp() {
        this.garage = new Garage();
        this.car = new Car(CAR_MODEL, CAR_MAX_SPEED, CAR_PRICE);
    }

    @Test
    public void testInvokeConstructorShouldCreateEmptyList() {
        Assert.assertEquals(0, garage.getCount());
    }

    @Test
    public void testAddCarShouldIncreaseCollectionSize() {
        Assert.assertEquals(0, garage.getCount());
        garage.addCar(car);
        Assert.assertEquals(1, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullCarShouldThrow() {
        garage.addCar(null);
    }

    @Test
    public void testFindAllCarsWithSpeedAboveGivenOne() {
        getGarageWithFourCars();

        List<Car> carsWithMaxSpeedAboveGiven = garage.findAllCarsWithMaxSpeedAbove(200);
        Assert.assertEquals(2, carsWithMaxSpeedAboveGiven.size());
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        getGarageWithFourCars();

        Car mostExpensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertEquals("Ferrari", mostExpensiveCar.getBrand());
    }

    @Test
    public void testFindAllCarsByBrand() {
        getGarageWithFourCars();

        List<Car> carsByBrand = garage.findAllCarsByBrand("Ford");
        Assert.assertEquals(2, carsByBrand.size());
        Assert.assertEquals("Ford", carsByBrand.get(0).getBrand());
    }

    private void getGarageWithFourCars() {
        Car volkswagenCar = car;
        Car fordCar = new Car("Ford", 150, 900.10);
        Car secondFordCar = new Car("Ford", 120, 800.10);
        Car ferrariCar = new Car("Ferrari", 300, 5000.50);
        garage.addCar(volkswagenCar);
        garage.addCar(fordCar);
        garage.addCar(secondFordCar);
        garage.addCar(ferrariCar);
    }

}