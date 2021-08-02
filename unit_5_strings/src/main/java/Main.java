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
            System.out.println(ReversString.reverseString(inputStr));
        }
        if (number == 2) {
            System.out.println("Pleas, enter the word for reverse");
            Scanner wordScan = new Scanner(System.in);
            String word = wordScan.nextLine();
            System.out.println(ReversString.reverseString(inputStr, word));
        }
        if (number == 3) {
            System.out.println("Pleas, enter start's and end's indexes ");
            Scanner scan = new Scanner(System.in);
            String[] indexes = scan.nextLine().split(" ");
            int start = Integer.parseInt(indexes[0]);
            int end = Integer.parseInt(indexes[1]);
            System.out.println(ReversString.reverseString(inputStr, start, end));
        }
        else {
            System.out.println("Please enter correct number");
        }

    }
}
