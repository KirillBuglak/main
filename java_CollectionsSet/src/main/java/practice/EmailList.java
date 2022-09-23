package practice;

import java.util.*;

public class EmailList {
    Set<String> emailSet = new TreeSet<>();
    List<String> emailList = new ArrayList<>();

    public static final String LET_NUMS = "[A-Za-z0-9]";

    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
        email = email.toLowerCase();

        String regex = LET_NUMS + "+@{1}" + LET_NUMS + "+\\.{1}" + LET_NUMS + "+";
        boolean valid = email.matches(regex)
                && !emailList.contains(email);
        if (valid) {
            emailSet.add(email);
        } else {
            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке

        return converting();
    }

    private List<String> converting() {
        Iterator<String> iter = emailSet.iterator();
        for (int i = 0; i< emailSet.size();i++){
            emailList.add(i, iter.next());
        }
        return emailList;
    }
}