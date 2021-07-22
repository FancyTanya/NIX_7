package ua.com.alevel;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        System.out.println("Please, enter something and I will calculate the sum of the numbers");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(findSumOfDigits(s));
    }

    public static int findSumOfDigits(String string) {
        String input = string.replaceAll("[^0-9]", "");
        int sum = 0;
        for (char c : input.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
}
