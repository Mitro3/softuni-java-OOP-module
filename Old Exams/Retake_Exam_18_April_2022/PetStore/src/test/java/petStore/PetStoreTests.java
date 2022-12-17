package petStore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PetStoreTests {

    private Animal animal;
    private PetStore petStore;
    private static final int BOUNDARY_KG = 25;

    @Before
    public void setUp() {
        this.animal = new Animal("Dog", 30, 100.00);
        this.petStore = new PetStore();
    }

    @Test
    public void testAddAnimalShouldIncreasePetStoreCount() {
        assertEquals(0, petStore.getCount());
        petStore.addAnimal(animal);
        assertEquals(1, petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrowWhenAnimalIsNull() {
        petStore.addAnimal(null);
    }

    @Test
    public void testFilterAnimalsWithBiggerKgThanGivenShouldReturnCorrectAnimals() {
        addFourAnimalsToPetStore(petStore, animal);
        List<Animal> filteredAnimals = petStore.findAllAnimalsWithMaxKilograms(25);
        assertEquals(2, filteredAnimals.size());
    }

    @Test
    public void testFilterAnimalsBySpecieShouldReturnCorrectAnimals() {
        addFourAnimalsToPetStore(petStore, animal);
        List<Animal> filteredAnimals = petStore.findAllAnimalBySpecie("Cat");
        assertEquals(2, filteredAnimals.size());
    }

    @Test
    public void testGetMostExpensiveAnimalShouldReturnCorrectAnimal() {
        addFourAnimalsToPetStore(petStore, animal);
        Animal mostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();
        assertEquals(0.00, 150.00, mostExpensiveAnimal.getPrice());
    }

    private void addFourAnimalsToPetStore(PetStore petStore, Animal animal) {
        Animal animal2 = new Animal("Cat", 20, 150.00);
        Animal animal3 = new Animal("Snake", 40, 90.00);
        Animal animal4 = new Animal("Cat", 10, 110.00);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);
    }



}

