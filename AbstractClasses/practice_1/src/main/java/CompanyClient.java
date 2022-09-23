public class CompanyClient extends Client {
    @Override
    protected String getName() {
        return "Юридическое лицо";
    }

    @Override
    public void take(double amount) {
        double takeCharge = 0.01;
        super.take(amount+(amount* takeCharge));
    }
}
