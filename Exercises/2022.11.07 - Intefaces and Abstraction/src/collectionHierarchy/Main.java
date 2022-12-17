package collectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemovable addRemovable = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        String[] words = scanner.nextLine().split("\\s+");
        int countRemoveOperation = Integer.parseInt(scanner.nextLine());

        performAddOperations(words, addCollection);
        performAddOperations(words, addRemovable);
        performAddOperations(words, myList);

        performRemoveOperations(countRemoveOperation, addRemovable);
        performRemoveOperations(countRemoveOperation, myList);
    }

    public static void performRemoveOperations(int counter, AddRemovable addRemovable){
        for (int i = 0; i < counter; i++) {
            System.out.print(addRemovable.remove() + " ");
        }
    }

    public static void performAddOperations(String[] words, Addable addable){
        for (String word : words) {
            System.out.print(addable.add(word) + " ");

        }

        System.out.println();
    }
}
