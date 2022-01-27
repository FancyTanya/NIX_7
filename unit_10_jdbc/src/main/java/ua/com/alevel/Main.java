package ua.com.alevel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private final Lock lock = new ReentrantLock();

    private void transfer(BankAccount fromAccount, BankAccount toAccount, int transferAmount) {
        while (true) {

            BankAccount fromAccountTemp = fromAccount;
            BankAccount toAccountTemp = toAccount;


            if (fromAccountTemp.compareTo(toAccountTemp) < 0) {
                fromAccountTemp = toAccountTemp;
                toAccountTemp = fromAccountTemp;
            }

            synchronized(fromAccountTemp){
                synchronized(toAccountTemp){
                    fromAccount.withdraw(transferAmount);
                    toAccount.deposit(transferAmount);
                }
            }
        }

    }

    public static void transfer(BankAccount from, BankAccount to, int transferAmount)
    {
        while(true)
        {
            if(from.lock.tryLock()){
                try {
                    if (to.lock.tryLock()){
                        try{
                            from.withdraw(amount);
                            to.deposit(amount);
                            break;
                        }
                        finally {
                            to.lock.unlock();
                        }
                    }
                }
                finally {
                    from.lock.unlock();
                }

                int n = number.nextInt(1000);
                int TIME = 1000 + n;
                Thread.sleep(TIME);
            }

        }

}
