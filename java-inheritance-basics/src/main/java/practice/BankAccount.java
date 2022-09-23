package practice;

public class BankAccount {

    private double money = 0;

    public double getAmount() {
        return money;
    }

    public void put(double amountToPut) {
        if (amountToPut >= 0) {
            money += amountToPut;
        }
    }

     public void take(double amountToTake) {
        if (amountToTake <= money) {
            money -= amountToTake;
        }
    }
}