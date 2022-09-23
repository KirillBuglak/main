package practice;

public class Main {
    public static void main(String[] args) {
        String s = "79001234567, 79007654321";
        System.out.println(s.matches(PhoneBook.TWO_PHONE_REGEX));
    }
}
