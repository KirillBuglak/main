public class Operator extends AbstractEmployee{

    @Override
    public int getMonthSalary() {
        return getFixedAmount();
    }
}
