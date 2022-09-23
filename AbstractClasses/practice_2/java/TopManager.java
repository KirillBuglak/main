public class TopManager extends AbstractEmployee {

    private int bonus;

    private int getEarned() {
        return getCompany().getIncome();
    }

    @Override
    public int getMonthSalary() {
        return getFixedAmount() + getBonus();
    }

//fixme
    private int getBonus() {
        if (getEarned() > 10_000_000) {
            bonus = (int) (getFixedAmount() * 1.5);
        }
        return bonus;
    }
}