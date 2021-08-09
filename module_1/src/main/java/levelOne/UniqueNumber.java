package levelOne;

import java.util.*;

public class UniqueNumber {

    public static int uniqueNumber(int[] input) {
        Set<Integer> uniqueNumbers = new TreeSet<>();
        for (int number : input) {
            uniqueNumbers.add(number);
        }
        return uniqueNumbers.size();
    }

    public static void doTask1() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = input.nextInt();
        int array[] = new int[size];
        System.out.println("Insert array elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        System.out.println("The number of unique characters in the array is " + uniqueNumber(array));
    }
}
