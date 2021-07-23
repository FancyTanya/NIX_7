package ua.com.alevel;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;


public class Task2 {

    public static void doTask2() {
        System.out.println("Please, enter something and I will calculate the number of letters");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(findLetters(s));
    }

    public static TreeMap<Character, Integer> findLetters(String string) {
        TreeMap<Character, Integer> result = new TreeMap<>();
        String input = string.replaceAll("[0-9]", "").toLowerCase();
        char[] array = input.toCharArray();
        for (char c : array) {
            if (!result.containsKey(c)) {
                result.put(c, 1);
            } else {
                result.put(c, result.get(c) + 1);
            }
        }
        return result;
    }

}
