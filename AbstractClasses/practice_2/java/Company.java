import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Company {
    private int income;
    private List<AbstractEmployee> employees = new ArrayList<>();

    public void hire(AbstractEmployee employee) {
        employees.add(employee);
    }

    public void hireAll(Collection<AbstractEmployee> employes) {
        employees.addAll(employes);
    }

    public void fire(AbstractEmployee employee) {
        employees.remove(employee);
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public List<AbstractEmployee> getEmployees() {
        return employees;
    }

    public ArrayList<AbstractEmployee> getTopSalaryStaff(int count) {

        ArrayList<AbstractEmployee> list = null;
        if (count <= employees.size() && count >= 0) {
            list = new ArrayList<>();
            Collections.sort(employees, Collections.reverseOrder());
            for (int i = 0; i < count; i++) {
                list.add(employees.get(i));
            }
        }
        return list;
    }

    public ArrayList<AbstractEmployee> getLowestSalaryStaff(int count) {

        ArrayList<AbstractEmployee> list = null;
        if (count <= employees.size() && count >= 0) {
            list = new ArrayList<>();
            Collections.sort(employees);
            for (int i = 0; i < count; i++) {
                list.add(employees.get(i));
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "Company{" +
                "income=" + income +
                '}';
    }
}