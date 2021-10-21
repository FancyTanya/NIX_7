package ua.com.alevel.fiftyThreads;

public class Main {

    public static void main(String[] args) {

        for (int i = 50; i > 0; i--) {
            new MakeFiftyThreads("Hello from thread " + i).start();
        }
    }
}
