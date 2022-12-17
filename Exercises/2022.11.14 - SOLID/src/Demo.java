import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = null;
        while (!"end".equals(command)) {
            System.out.println(command);
            command = scanner.nextLine();
        }

        System.out.println("hi");
    }
}
