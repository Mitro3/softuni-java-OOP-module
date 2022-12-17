package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    House house;
    Cat cat;
    private static final String HOUSE_NAME = "Lagera";
    private static final int HOUSE_CAPACITY = 3;

    @Before
    public void setUp() {
        this.house = new House(HOUSE_NAME, HOUSE_CAPACITY);
    }

    @Test
    public void testInvokeConstructorShouldCreateHouse() {
        Assert.assertEquals("Lagera", house.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldThrow() {
        House invalidHouse = new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmptyNameShouldThrow() {
        House invalidHouse = new House("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacityShouldThrow() {
        House invalidHouse = new House("Lagera", -1);
    }

    @Test
    public void testAddCatShouldIncreaseCollectionSize() {
        Assert.assertEquals(0, house.getCount());
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatShouldThrowWhenNoCapacityLeft() {
        getHouseWithThreeCats();
        Cat catTosho= new Cat("Tosho");
        house.addCat(catTosho);
    }

    @Test
    public void testRemoveCatShouldDecreaseCollectionSize() {
        getHouseWithThreeCats();
        Assert.assertEquals(3, house.getCount());
        house.removeCat("Pesho");
        Assert.assertEquals(2, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatShouldThrowWhenCatIsNotPresent() {
        house.removeCat("Sasho");
    }

    @Test
    public void testCatForSaleShouldSetHungryToTrue() {
        getHouseWithThreeCats();
        Cat carForSale = house.catForSale("Pesho");
        Assert.assertFalse(carForSale.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleShouldThrowWhenCatIsNotPresent() {
        house.catForSale("Sasho");
    }

    @Test
    public void testGetStatisticsShouldReturnCatReportInHouse() {
        getHouseWithThreeCats();
        String catReport = house.statistics();
        String expectedReport = String.format("The cat %s is in the house %s!",
                "Sasho, Pesho, Gosho", house.getName());
    }

    private void getHouseWithThreeCats() {
        Cat catSasho = new Cat("Sasho");
        house.addCat(catSasho);
        Cat catPesho = new Cat("Pesho");
        house.addCat(catPesho);
        Cat catGosho = new Cat("Gosho");
        house.addCat(catGosho);
    }

}
