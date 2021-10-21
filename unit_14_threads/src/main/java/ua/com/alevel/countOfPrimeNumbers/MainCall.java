package ua.com.alevel.countOfPrimeNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainCall {
    private static int amountPrimeNumbers;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 30);
            integerList.add(random);
        }
        for (Integer res : integerList)
            System.out.print(res + " ");
        System.out.println();

        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future<Integer>> futureResult = new ArrayList<>();
        int halfSize = integerList.size() / 2;

        for (int i = 0; i < 2; i++) {
            int from = halfSize * i;
            int to = halfSize * (i + 1);
            CallableNumbers task = new CallableNumbers(from, to);
            Future<Integer> futureInts = service.submit(task);
            futureResult.add(futureInts);
        }

        for (Future<Integer> result : futureResult) {
            amountPrimeNumbers += result.get();
        }
        service.shutdown();
        System.out.println("Amount of prime numbers is: " + amountPrimeNumbers);
    }


}
