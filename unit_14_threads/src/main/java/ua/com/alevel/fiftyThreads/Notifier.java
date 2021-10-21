package ua.com.alevel.fiftyThreads;

public class Notifier implements Runnable {

    private final MakeFiftyThreads make;

    public Notifier(MakeFiftyThreads make) {
        this.make = make;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        synchronized (make) {
            make.notifyAll();
        }
    }
}
