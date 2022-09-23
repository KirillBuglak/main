package practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 28;
        int month = 12;
        int year = 1996;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        String message = "";

        LocalDate birthday = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" - dd.MM.yyyy - E").localizedBy(new Locale("us"));
        long now = System.currentTimeMillis();
        LocalDate today = LocalDateTime.ofEpochSecond(now / 1000, 0, ZoneOffset.ofHours(3)).toLocalDate();

        int years = today.getYear() - birthday.getYear();

        for (int i = 0; i <= years; ++i) {

            if (today.isAfter(birthday) || today.isEqual(birthday)) {
                message += i + birthday.format(formatter) + System.lineSeparator();
                birthday = birthday.plusYears(1);
            } else {
                break;
            }
        }

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        return message;
    }
}