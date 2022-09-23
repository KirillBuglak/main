import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static long accountsSum;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        Map<String, Account> accounts = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Account account = new Account();
            account.setAccNumber(String.valueOf(i));
            account.setMoney(new Random().nextLong(51000, 100000));
            accounts.put(account.getAccNumber(), account);
        }

        accounts.values().forEach(e -> accountsSum += e.getMoney());
        System.out.println(accountsSum);

        Bank bank = new Bank();
        bank.setAccounts(accounts);


        for (int i = 0; i < 100; i++) {
            String s1 = String.valueOf(new Random().nextInt(0, 5));
            String s2 = String.valueOf(new Random().nextInt(0, 5));
            String accNumber = String.valueOf(new Random().nextInt(0, 10));
            if (i < 5) {
                threads.add(new Thread(() -> bank.transfer(s1, s2, 51000)));
            } else {
                threads.add(new Thread(() -> bank.transfer(s1, s2, new Random()
                        .nextInt(10000, 50000))));
                threads.add(new Thread(() -> System.out.println("\t Account **"
                        + accNumber + "** has - " + bank.getBalance(accNumber))));
            }
        }
        threads.forEach(Thread::start);

        scanner.nextLine();

        if (bank.getSumAllAccounts() == accountsSum) System.out.println("\t\tAmount in the bank hasn't changed");
        else System.err.println("Failure");
    }
}