package ua.com.alevel.countOfPrimeNumbers;

import java.util.ArrayList;
import java.util.List;

public class MainRunnable {
    private static int amountOfPrime;

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 30);
            integerList.add(random);
        }

        Thread thread1 = new Thread(new RunnableNumbers(integerList));
        Thread thread2 = new Thread(new RunnableNumbers(integerList));
        thread1.start();
        thread2.start();

    }
}
