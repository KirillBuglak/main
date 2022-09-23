public abstract class AbstractEmployee implements Comparable, Employee {

    private int fixedAmount;
    private Company company;

    protected void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public int getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(int fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    @Override
    public int compareTo(Object o) {
        Employee employee = (Employee) o;
        return (Double.compare(getMonthSalary(), employee.getMonthSalary()));
    }

    @Override
    public String toString() {
        return getMonthSalary() +
                " руб.";
    }
}