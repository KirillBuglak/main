package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {

    private String ph;
    private String na;


    private Map<String, String> phoneBook = new HashMap<>();

    public static final String ONE_PHONE_REGEX = "[0-9]{11}";
    public static final String TWO_PHONE_REGEX = "[0-9]{11}[,]+\\s?[0-9]{11}";
    public static final String NAME_REGEX = "[A-zЁ-ё]+";

    //    todo: if (!phone.matches(ONE_PHONE_REGEX) && !name.matches(NAME_REGEX)) {
//            System.out.println("Неверный формат ввода");
//        } else if (phoneBook.isEmpty()) {
//            phoneBook.put(name, phone);
//        } else for (Map.Entry<String, String> entry : phoneBook.entrySet()){
//            String key = entry.getKey();
//            String value = entry.getValue();
//            ................................
//            ................................
//        }
    private void doubleNumberAndReplacement(String name, String phone) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            //todo: Добавление контактов с одинаковым номером, владелец должен быть перезаписан
            if (!name.equals(key) && phone.equals(value)) {
                phoneBook.remove(key, value);
                phoneBook.put(name, value);
            //todo: Добавление контакта, владеющий двумя номерами
            } else if (name.equals(key) && !phone.equals(value)) {
                phoneBook.put(key, value + ", " + phone);
            } else {
                phoneBook.put(name, phone);
            }
        }
    }


    public void addContact(String phone, String name) {

        if (!phone.matches(ONE_PHONE_REGEX) || !name.matches(NAME_REGEX)) {
            System.out.println("Неверный формат ввода");

        } else if (!phoneBook.isEmpty()) {
            doubleNumberAndReplacement(name, phone);
        } else {
            phoneBook.put(name, phone);
        }
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String string = "";
        if (!phoneBook.containsValue(phone)) {
            string = "";
        } else {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (entry.getValue().equals(phone)) {
                    String key = entry.getKey();
                    String value = entry.getValue();

                    string = key + " - " + value;
                }
            }
        }
        return string;
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        Set<String> contact = new TreeSet<>();
        String string = "";
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (name.equals(key)) {
                string = key + " - " + value;
            }
        }
        contact.add(string);
        return contact;
    }


    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        Set<String> contacts = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            contacts.add(key + " - " + value);
        }
        return contacts;
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}