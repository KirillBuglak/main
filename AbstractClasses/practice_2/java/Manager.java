public class Manager extends AbstractEmployee {
    private int earned = (int) (140_000 - (Math.random() * 25_000));

    private int bonus;

    @Override
    public int getMonthSalary() {
        return getFixedAmount()+getBonus();
    }

    private int getBonus() {
        bonus = (int) (earned * 0.05);
        return bonus;
    }
}