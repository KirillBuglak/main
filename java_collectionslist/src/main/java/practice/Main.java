package practice;

import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        Scanner scanner = new Scanner(System.in);
        String insert = scanner.nextLine();
        String deleteRegex = "DELETE\\s+0-9+";
        String indexAddRegex = "ADD\\s+0-9+A-z*";
        int startIndex = insert.indexOf(' ');
        int endIndex = insert.indexOf(' ', startIndex + 1);
        while (true) {
            if (insert == "exit") {
                break;
            }
            if (insert.matches(deleteRegex)) {
                todoList.delete(startIndex);
            } else if (insert.matches(indexAddRegex)) {
                todoList.add(insert.substring(startIndex, endIndex));
            } else if (insert.equals("LIST")) {
                for (String s : todoList.getTodos()) {
                    System.out.println(s);
                }
            } else {
                todoList.add(insert.substring(startIndex));
            }
        }
    }
}
