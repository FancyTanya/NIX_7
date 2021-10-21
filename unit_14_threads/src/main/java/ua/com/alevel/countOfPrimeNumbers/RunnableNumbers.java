package ua.com.alevel.countOfPrimeNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RunnableNumbers implements Runnable {

    private static int firstLocalAmount;
    private static int secondLocalAmount;
    private List<Integer> list;

    public RunnableNumbers(List<Integer> list) {
        this.list = list;
    }

    @Override
    public synchronized void run() {
        List<Integer> result = new ArrayList<>();
        if (Thread.currentThread().getName() != null && Thread.currentThread().getName().equalsIgnoreCase("thread1")) {
            int middle = list.size() / 2;
            for (int i = 0; i < middle; i++) {
                if (isPrimeNumbers(i)) {
                    result.add(i);
                }

            }
            if (Thread.currentThread().getName() != null && Thread.currentThread().getName().equalsIgnoreCase("thread2")) {
                for (int i = middle; i < list.size(); i++) {
                    if (isPrimeNumbers(i)) {
                        result.add(i);
                    }

                }
            }
        }
        System.out.println("Amount of prime numbers: " + result.size());

    }

    public boolean isPrimeNumbers(int number) {
        boolean isPrimeNum = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrimeNum = false;
            }
        }
        return isPrimeNum;
    }
}
