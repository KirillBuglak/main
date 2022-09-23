import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss dd/MMMM/yy");
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date.format(dateTimeFormatter));
    }
}
//C:\Users\X\.jdks\openjdk-17.0.1\bin\java -jar out/DateAndTime.jar
//C:\Users\X\.jdks\openjdk-17.0.1\bin\java.exe -jar out/DateAndTime.jar
