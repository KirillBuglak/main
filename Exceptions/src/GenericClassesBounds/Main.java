package GenericClassesBounds;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate[] dates = {
                LocalDate.of(2011,3,2),
                LocalDate.of(2001,9,11),
                LocalDate.of(2017,11,25)
        };

        Class111<LocalDate> locdate = Class1.minmax(dates);
        System.out.println("min = " + locdate.getFirst());
        System.out.println("max = " + locdate.getSecond());



    }
}
