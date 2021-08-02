import libs.reverseString.jar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("**************************");
        System.out.println("If you want to reverse the string. Enter number 1");
        System.out.println("If you want to enter a string and reverse some word. Enter number 2");
        System.out.println("If you want to enter a string and reverse part of the string using the start and end indices. Enter number 3");
        System.out.println("**************************");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Please, enter the string");
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();

        if (number == 1) {
            System.out.println(inputStr.reverse);
        }

    }
}
