package foodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int personCount = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyerMap = new HashMap<>();

        for (int i = 0; i < personCount; i++) {
            String[] personTokens = scanner.nextLine().split("\\s+");
            String personName = personTokens[0];
            int personAge = Integer.parseInt(personTokens[1]);
            Buyer buyer;

            if (personTokens.length == 4) {
                String id = personTokens[2];
                String birthDate = personTokens[3];
                buyer = new Citizen(personName, personAge, id, birthDate);
            } else {
                String group = personTokens[2];
                buyer = new Rebel(personName, personAge, group);
            }

            buyerMap.put(personName, buyer);
        }

        String nameFromConsole = scanner.nextLine();
        while (!"End".equals(nameFromConsole)) {
            Buyer buyer = buyerMap.get(nameFromConsole);

            if (buyer != null) {
                buyer.buyFood();
            }

            nameFromConsole = scanner.nextLine();
        }

        int totalFood = buyerMap.values().stream()
                .mapToInt(b -> b.getFood())
                .sum();

        System.out.println(totalFood);
    }
}
