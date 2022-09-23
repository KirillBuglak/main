import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.setIncome(10000000);
        List<AbstractEmployee> list = new ArrayList<>();

        for (int i = 0; i < 270; i++) {
            if (i < 10) {
                TopManager topManager = new TopManager();
                topManager.setCompany(company);
                topManager.setFixedAmount((int) (4_000 + Math.round(Math.random() * 2_000)));
                list.add(topManager);
            } else if (i >= 10 && i < 80) {
                Manager manager = new Manager();
                manager.setCompany(company);
                manager.setFixedAmount((int) (4_000 + Math.round(Math.random() * 1_000)));
                list.add(manager);
            } else {
                Operator operator = new Operator();
                operator.setCompany(company);
                operator.setFixedAmount((int) (3_000 + Math.round(Math.random() * 1_000)));
                list.add(operator);
            }
        }

        company.hireAll(list);

        System.out.println("Highest salaries before firing\n" + company.getTopSalaryStaff(10) + "\n");
        System.out.println("Lowest salaries before firing\n" + company.getLowestSalaryStaff(30) + "\n");

        for (int i = 0; i<(company.getEmployees().size()/2); i++){
            company.fire(company.getEmployees().get(i));
        }

        System.out.println("Highest salaries after firing\n" + company.getTopSalaryStaff(10) + "\n");
        System.out.println("Lowest salaries after firing\n" + company.getLowestSalaryStaff(30) + "\n");
    }
}