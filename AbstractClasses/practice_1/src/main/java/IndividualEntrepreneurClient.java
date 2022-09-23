public class IndividualEntrepreneurClient extends Client {
    @Override
    protected String getName() {
        return "Индивидуальный предприниматель";
    }

    @Override
    public void put(double amount) {
        double putCharge1 = 0.01;
        double putCharge05 = 0.005;
        if (amount < 1000) {
            super.put(amount - amount * putCharge1);
        } else {
            super.put(amount - amount * putCharge05);
        }
    }
}