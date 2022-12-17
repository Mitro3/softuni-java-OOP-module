package vehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split("\\s+");
        double carFuel = Double.parseDouble(carData[1]);
        double carConsumption = Double.parseDouble(carData[2]);
        double carTankCapacity = Double.parseDouble(carData[3]);
        Vehicle car = new Car(carFuel, carConsumption, carTankCapacity);

        String[] truckData = scanner.nextLine().split("\\s+");
        double truckFuel = Double.parseDouble(truckData[1]);
        double truckConsumption = Double.parseDouble(truckData[2]);
        double truckTankCapacity = Double.parseDouble(truckData[3]);
        Vehicle truck = new Truck(truckFuel, truckConsumption, truckTankCapacity);

        String[] busData = scanner.nextLine().split("\\s+");
        double busFuel = Double.parseDouble(busData[1]);
        double busConsumption = Double.parseDouble(busData[2]);
        double busTankCapacity = Double.parseDouble(busData[3]);
        Vehicle bus = new Bus(busFuel, busConsumption, busTankCapacity);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus", bus);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        while (commandsCount-- > 0) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String command = inputData[0];
            String vehicleType = inputData[1];
            double argument = Double.parseDouble(inputData [2]);

            switch (command) {
                case "DriveEmpty":
                    Bus newBus = (Bus) vehicleMap.get(vehicleType);
                    System.out.println(bus.drive(argument));
                    break;

                case "Drive":
                    System.out.println(vehicleMap.get(vehicleType).drive(argument));
                    break;

                case "Refuel":
                    try {
                        vehicleMap.get(vehicleType).refuel(argument);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
