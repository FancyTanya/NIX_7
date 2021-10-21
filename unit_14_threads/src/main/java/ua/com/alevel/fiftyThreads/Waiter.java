package ua.com.alevel.fiftyThreads;

public class Waiter implements Runnable{

    private final MakeFiftyThreads make;

    public Waiter(MakeFiftyThreads make) {
        this.make = make;
    }

    @Override
    public void run() {
        synchronized (make) {
            try {
                make.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
