package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Farm farm;
    private Animal basicAnimal;
    private static final String FARM_NAME = "Lagera";
    private static final int FARM_CAPACITY = 3;
    private static final String BASIC_ANIMAL_TYPE = "Human";
    private static final double BASIC_ANIMAL_ENERGY = 100.00;

    @Before
    public void setUp() {
        this.farm = new Farm(FARM_NAME, FARM_CAPACITY);
        this.basicAnimal = new Animal(BASIC_ANIMAL_TYPE, BASIC_ANIMAL_ENERGY);
    }

    @Test
    public void testInvokeConstructorShouldCreateFarm() {
        Assert.assertEquals(0, farm.getCount());
        Assert.assertEquals("Lagera", farm.getName());
    }

    @Test
    public void testAddNewAnimalShouldIncreaseCollectionSize() {
        farm.add(basicAnimal);
        Assert.assertEquals(1, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrowWhenCollectionIsFull() {
        getFarmWithThreeAnimals();
        Animal catAnimal = new Animal("Cat", 50.00);
        farm.add(catAnimal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExistingAnimalShouldThrow() {
        farm.add(basicAnimal);
        farm.add(basicAnimal);
    }

    @Test
    public void testRemoveAnimalShouldDecreaseCollectionSize() {
        getFarmWithThreeAnimals();
        Assert.assertTrue(farm.remove(basicAnimal.getType()));
        Assert.assertEquals(2, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFarmNegativeCapacityShouldThrow() {
        Farm invalidFarm = new Farm("Invalid", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateFarmWithNullNameShouldThrow() {
        Farm invalidFarm = new Farm(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateFarmWithEmptyNameShouldThrow() {
        Farm invalidFarm = new Farm("", 1);
    }

    private void getFarmWithThreeAnimals() {
        farm.add(basicAnimal);
        Animal goatAnimal = new Animal("Goat", 20.00);
        Animal dogAnimal = new Animal("Dog", 200.00);
        farm.add(goatAnimal);
        farm.add(dogAnimal);
    }
}
