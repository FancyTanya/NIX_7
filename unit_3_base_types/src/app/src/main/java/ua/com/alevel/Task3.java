package ua.com.alevel;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Please, enter the lesson number from 1 to 10 to find out when it will end");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println("Please enter the lesson number from 1 to 10");
        }
        int value = scanner.nextInt();
        if (value >0 && value<10) {
            System.out.println(timeOfLessonEnd(value));
        }

    }

    public static String timeOfLessonEnd(int i) {
        String[] endOfLesson = new String[]{"9:45", "10:35", "11:35", "12:25", "13:25", "14:15", "15:15", "16:05", "17:05", "17:55"};
        return "Lesson# " + i + " ends at " + endOfLesson[i - 1];
    }
}
