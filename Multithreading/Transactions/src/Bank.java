import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private AtomicLong sum = new AtomicLong();

    private volatile Map<String, Account> accounts;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        synchronized (accounts) {
            if (fromAccountNum.equals(toAccountNum)) {
                System.err.println("Can't transfer within an account - " + fromAccountNum);
                if (accounts.get(fromAccountNum).isBlocked()) {
                    System.err.println("Account " + fromAccountNum +
                            " has been blocked - FROM");
                }
                if (accounts.get(toAccountNum).isBlocked()) {
                    System.err.println("Account " + toAccountNum +
                            " has been blocked - TO");
                }
                return;
            }

            if (accounts.get(fromAccountNum).getMoney() - amount < 0) {
                System.out.println("Not enough money in account **" + fromAccountNum + "** - "
                        + getBalance(fromAccountNum) + "...");
                try {
                    accounts.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                accounts.get(fromAccountNum).setMoney(getBalance(fromAccountNum) - amount);
                accounts.get(toAccountNum).setMoney(getBalance(toAccountNum) + amount);
                System.out.println(amount + " has been transferred from **" + fromAccountNum + "** - "
                        + getBalance(fromAccountNum) + " to **" + toAccountNum + "** - " + getBalance(toAccountNum));
                if (amount > 50000) {
                    try {
                        if (isFraud(fromAccountNum, toAccountNum, amount)) {
                            accounts.get(fromAccountNum).setBlocked(true);
                            accounts.get(toAccountNum).setBlocked(true);
                            System.out.println("Accounts **" + fromAccountNum + "** and **"
                                    + toAccountNum + "** have been blocked, amount = " + amount);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            accounts.notify();
        }
        /** Just to test multithreading    System.out.println("\t" + Thread.currentThread().getName());*/
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        accounts.values().forEach(e -> sum.getAndAdd(e.getMoney()));
        return sum.get();
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
}