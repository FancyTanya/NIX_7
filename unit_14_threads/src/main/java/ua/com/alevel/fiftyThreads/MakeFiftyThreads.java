package ua.com.alevel.fiftyThreads;


public class MakeFiftyThreads extends Thread {

    public MakeFiftyThreads(String name) {
        super(name);
    }


    @Override
    public synchronized void run() {
        System.out.println(getName());
        }

}
