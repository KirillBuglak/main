package practice;

public class CardAccount extends BankAccount {
    private double charges = 0.01;

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake + amountToTake * charges);
    }
}