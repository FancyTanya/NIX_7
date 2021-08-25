package levelTwo;

import java.util.Scanner;

public class isCorrectString {

    public static boolean isCorrectString(String input) {
        if ((input.startsWith("(") && input.endsWith(")"))
                || input.isEmpty()
                || (input.startsWith("[") && input.endsWith("]"))
                || (input.startsWith("{") && input.endsWith("}"))) {
            if (input.length() > 2) {
                isCorrectString(input.substring(1, input.length() - 1));
                return true;
            }
        }
        return  false;
    }

    public static void testIsCorrectString() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the string with braces");
        String stringForTest = input.nextLine();
        System.out.println("Correctness of string input: " + isCorrectString(stringForTest));
    }
}

