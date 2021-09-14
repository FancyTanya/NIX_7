package ua.com.alevel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ua.com.alevel.util.MathSet;

public class MathSetController {
        String position;
        int capacity = 10;
    MathSet<Integer> firstSetNumbers;
    MathSet<Integer>secondSetNumbers;
        private final  MathSet<Integer> sets = new MathSet(capacity);
        int numberFromConsole;

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");

        try {
            navigationMenu();
            while ((position = reader.readLine()) != null) {
                mathSetInitConstructor(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                mathSetInitConstructor(position,reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
        functionalMenu();
    }

    public void navigationMenu() {
        System.out.println("------------------------------------------");
        System.out.println("Hello. Let's make a math set!");
        System.out.println("if you want to set CAPACITY of set, enter 1");
        System.out.println("if you want to enter SET of numbers, enter 2");
        System.out.println("if you want to enter  SEVERAL SETS of numbers, enter 3");
        System.out.println("if you want exit, please enter 0");
        System.out.println("------------------------------------------");
    }
    public void functionalMenu() {
        System.out.println("------------------------------------------");
        System.out.println("Choose a function to work with a set!");
        System.out.println("You can add number, enter 1");
        System.out.println("You can join another MathSet, enter 2");
        System.out.println("You can sort descending, enter 3");
        System.out.println("You can sort ascending, enter 4");
        System.out.println("You can get MAX, enter 5");
        System.out.println("You can get MIN, enter 6");
        System.out.println("You can get AVERAGE, enter 7");
        System.out.println("You can get MEDIAN, enter 8");
        System.out.println("You can clear SET, enter 9");
        System.out.println("if you want exit, please enter 0");
        System.out.println("------------------------------------------");
    }

    public void functionConstructor(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                addNumber(reader);
                break;
            case "2":
                join(reader);
                break;
            case "3":
                severalSets(reader);
                break;
            case "0":
                System.exit(0);
        }
        navigationMenu();
    }

    private void addNumber(BufferedReader reader) {
        System.out.println("Please, enter set of Integers");
        firstSetNumbers = setOfNumbersFromConsole(reader);
        System.out.println("Please, enter the number to add to the set");
        sets.add(numberFromConsole(reader));
    }

    private void join(BufferedReader reader) {
        severalSets(reader);

    }

    public void mathSetInitConstructor(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                capacity(reader);
                break;
            case "2":
                setOfNumbers(reader);
                break;
            case "3":
                severalSets(reader);
                break;
            case "0":
                System.exit(0);
        }
        navigationMenu();
    }

    private void capacity(BufferedReader reader) {
        System.out.println("Please, enter set's capacity ");
        numberFromConsole(reader);
    }

    private int numberFromConsole(BufferedReader reader) {
        try {
            String thisLine;
            while ((thisLine = reader.readLine()) != null) {
                numberFromConsole = Integer.parseInt(thisLine);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number");
        }
        return numberFromConsole;
    }

    private void setOfNumbers(BufferedReader reader) {
        setOfNumbersFromConsole(reader);
    }

    private MathSet<Integer> setOfNumbersFromConsole(BufferedReader reader) {
        try {
            System.out.println("Please, enter SET of numbers");
            String inputNumbers = reader.readLine();
            firstSetNumbers = new MathSet<>(inputNumbers.length());
            for (int i = 0; i < firstSetNumbers; i++) {
                for (char value : inputNumbers.toCharArray()) {
                    firstSetNumbers[i] = Integer.parseInt(String.valueOf(value));
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number");
        }
        return firstSetNumbers;
    }

    private void severalSets(BufferedReader reader) {
        System.out.print("Please, enter FIRST set of numbers. ");
        firstSetNumbers = setOfNumbersFromConsole(reader);
        System.out.print("Please, enter SECOND set of numbers. ");
        secondSetNumbers = setOfNumbersFromConsole(reader);
    }


}
