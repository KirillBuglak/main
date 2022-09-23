import java.util.*;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }


    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
        Date beforeDate = new GregorianCalendar(year + 1, 0, 1).getTime();
        Date afterDate = new GregorianCalendar(year - 1, 11, 31).getTime();

        Employee employee = staff.stream()
                .filter(e -> e.getWorkStart().before(beforeDate) && e.getWorkStart().after(afterDate))
                .max(Comparator.comparing(Employee::getSalary)).get();
        return employee;
    }
}