import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        final String PHONE_REGEX = "[+][0-9]{11}";
        final String EMAIL_REGEX = "[A-z,0-9]+@[A-z]+[.]{1}[A-z]+";

        String[] components = data.split("\\s+");
        boolean wrongFormat = components.length != 4 || !components[INDEX_PHONE].matches(PHONE_REGEX)
                || !components[INDEX_EMAIL].matches(EMAIL_REGEX);
        if (wrongFormat) {
            throw new RuntimeException("Wrong format");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));

    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}