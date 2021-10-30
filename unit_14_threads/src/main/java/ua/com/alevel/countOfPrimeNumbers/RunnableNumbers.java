package ua.com.alevel.countOfPrimeNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class RunnableNumbers implements Runnable {

    private final List<Integer> list;
    private final ReentrantLock lock = new ReentrantLock();


    public RunnableNumbers(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        List<Integer> indexes = new ArrayList<>();
        List<Integer> primes = new ArrayList<>();
        int numbersAmount = 100;

        lock.lock();
        try {
            for (int i = 0; i < list.size(); i++) {
                if (!indexes.contains(i)) {
                    indexes.add(i);
                    numbersAmount--;
                    if (isPrimeNumbers(list.get(i))) {
                        primes.add(list.get(i));
                    }
                }
            }
        } finally {
            System.out.println("Amount of prime numbers: " + primes.size() );
            lock.unlock();
        }
    }

//    @Override
//    public void run() {
//        lock.lock();
//        try {
//            List<Integer> result = new ArrayList<>();
//            if (Thread.currentThread().getName() != null && Thread.currentThread().getName().equalsIgnoreCase("thread1")) {
//                int middle = list.size() / 2;
//                for (int i = 0; i < middle; i++) {
//                    if (isPrimeNumbers(i)) {
//                        result.add(i);
//                    }
//                }
//                if (Thread.currentThread().getName() != null && Thread.currentThread().getName().equalsIgnoreCase("thread2")) {
//                    for (int i = middle; i < list.size(); i++) {
//                        if (isPrimeNumbers(i)) {
//                            result.add(i);
//                        }
//                    }
//                }
//            }
//            System.out.println("Amount of prime numbers: " + result.size());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            lock.unlock();
//        }
//    }

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
