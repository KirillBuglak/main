public abstract class Client {

    double amount;

    public double getAmount() {

        return amount;
    }

    public void put(double amount) {
        if (amount >= 0) {
            this.amount += amount;
        }
    }

    public void take(double amount) {
        if (amount <= this.amount) {
            this.amount -= amount;}
    }

    protected abstract String getName();

}
