package practice;

import java.util.ArrayList;

public class TodoList {
    ArrayList<String> arrayList = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        System.out.println("Добавлено дело \"" + todo + "\"");
        arrayList.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        boolean indexInBounds = index > arrayList.size() - 1 || index < 0;
        if (indexInBounds) {
            System.out.println("new todo");
            arrayList.add("new todo");
        } else if (todo.equals("")) {
            System.out.println("new todo");
        } else {
            arrayList.add(index, todo);
        }
    }

    public void edit(int index, String todo) {
        try {
            if (todo.equals("")) {
                todo = "new todo";
            }
            System.out.println("Дело \"" + arrayList.get(index) + " заменено на \"" + todo + "\"");
            arrayList.remove(index);
            arrayList.add(index, todo);
        } catch (Exception e) {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        try {
            System.out.println("Дело \"" + arrayList.get(index) + "\" удалено");
            arrayList.remove(index);
        } catch (Exception e) {
            System.out.println("Дело с таким номером не существует");
        }
    }


    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return arrayList;
    }

}