package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        Field field = new Field(rows, cols);
        Galaxy galaxy = new Galaxy(field);

        String command = scanner.nextLine();
        long starsCollected = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int rowEvil = evilCoordinates[0];
            int colEvil = evilCoordinates[1];

            galaxy.moveEvil(rowEvil, colEvil);

            int rowJedi = jediCoordinates[0];
            int colJedi = jediCoordinates[1];

            starsCollected += galaxy.moveJedi(rowJedi, colJedi);

            command = scanner.nextLine();
        }

        System.out.println(starsCollected);
    }
}
