import java.util.Collections;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, (s1, s2) -> {
            int i = s1.getSalary().compareTo(s2.getSalary());
            if (i == 0) {
                return s1.getName().compareTo(s2.getName());
            } else {
                return i;
            }
        });
    }
}