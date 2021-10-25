package ua.com.alevel.countOfPrimeNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class AnotherSolution implements Callable<Integer> {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 30);
            integerList.add(random);
        }

        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < integerList.size() / 2; i++) {
            AnotherSolution solution = new AnotherSolution(0, integerList.size()/2, integerList.get(i));
            Future<Integer> futureSum = service.submit(solution);
            try {
                amountOfNumbers += futureSum.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                service.shutdown();
            }
        }

        for (int i = integerList.size() / 2; i < integerList.size(); i++) {
            AnotherSolution solution2 = new AnotherSolution(integerList.size() / 2, integerList.size() ,integerList.get(i));
            Future<Integer> futureSum = service.submit(solution2);
            try {
                amountOfNumbers += futureSum.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                service.shutdown();
            }
        }


        System.out.println("Amount of prime numbers: " + amountOfNumbers);
    }

    private static int amountOfNumbers = 0;
    private int inputNumber;
    private int from;
    private int to;
    CallableNumbers callableNumbers;


    public AnotherSolution(int from, int to, int inputNumber) {
        this.inputNumber = inputNumber;
        this.from = from;
        this.to = to;
    }

    @Override
    public Integer call() throws Exception {
        int localSum = 0;
        for (int i = from; i < to; i++) {
            if (callableNumbers.isPrimeNumbers(inputNumber)) {
                localSum++;
            }
        }

        return localSum;
    }
}

