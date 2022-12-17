package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String objectType = tokens[0];
            String name = tokens[1];

            switch (objectType) {
                case "Citizen":
                    int personAge = Integer.parseInt(tokens[2]);
                    String personId = tokens[3];
                    String personBirthDate = tokens[4];
                    Citizen citizen = new Citizen(name, personAge, personId, personBirthDate);
                    birthables.add(citizen);
                    break;

                case "Pet":
                    String petBirthDay = tokens[2];
                    Pet pet = new Pet(name, petBirthDay);
                    birthables.add(pet);
                    break;

                case "Robot":
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
