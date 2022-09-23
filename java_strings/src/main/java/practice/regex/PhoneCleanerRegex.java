package practice.regex;

import java.util.Scanner;

public class PhoneCleanerRegex {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }

            String regex = "[^0-9]";
            String changed = input.replaceAll(regex,"");
            char firstSymbol = changed.charAt(0);

            if (changed.length()>11||changed.length()<10) {
                System.out.println("Неверный формат номера");
            } else if (firstSymbol!='7'&&firstSymbol!='8'&&changed.length()==11) {
                System.out.println("Неверный формат номера");
            } else if (changed.length()==10){
                System.out.println("7"+changed);
            } else if (firstSymbol=='8'){
                System.out.println(changed.replaceAll("[8]","7"));
            } else {
                System.out.println(changed);
            }
        }
    }
}
