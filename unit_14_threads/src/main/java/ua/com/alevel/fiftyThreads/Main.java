package ua.com.alevel.fiftyThreads;

public class Main {

    public static void main(String[] args) {

        MakeFiftyThreads make = new MakeFiftyThreads("Thread#");
        Waiter waiter = new Waiter(make);
        Notifier notifier = new Notifier(make);

        for (int i = 50; i > 0; i--) {
            new MakeFiftyThreads("Hello from thread " + i).start();
            new Thread(waiter).start();
        }
        new Thread(notifier).start();
    }
}
