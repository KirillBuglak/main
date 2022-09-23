package ListOrArraListGenericsMyTurn;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <String> list = new ArrayList<>();
        list.add("Disk");
        list.add("mask");
        list.add("Fusk");
        String str1 = list.get(2);
        System.out.println(str1);
    }
}
