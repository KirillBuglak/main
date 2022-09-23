package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private static LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now();
    }

    @Override
    public void take(double amountToTake) {
        if (LocalDate.now().minusMonths(1).isAfter(lastIncome)) {
            super.take(amountToTake);
        }
    }
}