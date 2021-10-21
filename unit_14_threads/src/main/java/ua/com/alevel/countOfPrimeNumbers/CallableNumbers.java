package ua.com.alevel.countOfPrimeNumbers;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableNumbers implements Callable {

    private int from;
    private int to;
    private int localSum;
    private List<Integer> list;

    public CallableNumbers(int from, int to) {
        this.from = from;
        this.to = to;
//        this.list = list;
    }

    @Override
    public Integer call() throws Exception {

        for (int i = from; i < to; i++) {
            if (isPrimeNumbers(i)) {
                localSum++;
            }
        }
        return localSum;
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
