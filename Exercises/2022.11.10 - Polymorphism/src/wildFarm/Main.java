package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] animalInfo = input.split("\\s+");
            String animalType = animalInfo[0];
            String animalName = animalInfo[1];
            Double animalWeight = Double.parseDouble(animalInfo[2]);
            String animalLivingRegion = animalInfo[3];
            Animal animal = null;

            String[] foodInfo = scanner.nextLine().split("\\s+");
            String foodType = foodInfo[0];
            Integer foodQuantity = Integer.parseInt(foodInfo[1]);
            Food food = foodType.equals("Meat") ? new Meat(foodQuantity) : new Vegetable(foodQuantity);

            switch (animalType) {
                case "Mouse":
                    animal = new Mouse(animalType, animalName, animalWeight, animalLivingRegion);
                    break;
                case "Cat":
                    String catBreed = animalInfo[4];
                    animal = new Cat(animalType, animalName, animalWeight, animalLivingRegion, catBreed);
                    break;
                case "Tiger":
                    animal = new Tiger(animalType, animalName, animalWeight, animalLivingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalType, animalName, animalWeight, animalLivingRegion);
                    break;
            }
            animal.makeSound();
            animalList.add(animal);

            try {
                animal.eat(food);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            input = scanner.nextLine();
        }

        for (Animal animal : animalList) {
            System.out.println(animal);
        }

    }
}
