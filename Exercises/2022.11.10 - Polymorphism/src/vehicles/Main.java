package vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split("\\s+");
        double carFuel = Double.parseDouble(carData[1]);
        double carConsumption = Double.parseDouble(carData[2]);
        Vehicle car = new Car(carFuel, carConsumption);

        String[] truckData = scanner.nextLine().split("\\s+");
        double truckFuel = Double.parseDouble(truckData[1]);
        double truckConsumption = Double.parseDouble(truckData[2]);
        Vehicle truck = new Truck(truckFuel, truckConsumption);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        while (commandsCount-- > 0) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String command = inputData[0];
            String vehicleType = inputData[1];
            double argument = Double.parseDouble(inputData [2]);

            switch (command) {
                case "Drive":
                    System.out.println(vehicleMap.get(vehicleType).drive(argument));
                    break;

                case "Refuel":
                    vehicleMap.get(vehicleType).refuel(argument);
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
