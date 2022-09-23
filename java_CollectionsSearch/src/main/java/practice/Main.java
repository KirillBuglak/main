package practice;

import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {

        List<String> list = CoolNumbers.generateCoolNumbers();
        HashSet<String> hash = new HashSet<>();
        TreeSet<String> tree = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (int i = 0; i < list.size(); i++) {
            hash.add(list.get(i));
            tree.add(list.get(i));
        }
        long bruteStart = System.currentTimeMillis();
        CoolNumbers.bruteForceSearchInList(list, input);
        long bruteTime = System.currentTimeMillis() - bruteStart;
        System.out.println(list.contains(input));
        System.out.println("bruteTime = " + bruteTime);

        Collections.sort(list);
        long binaryStart = System.currentTimeMillis();
        CoolNumbers.binarySearchInList(list, input);
        long binaryTime = System.currentTimeMillis() - binaryStart;
        System.out.println(list.contains(input));
        System.out.println("binaryTime = " + binaryTime);

        long hashStart = System.currentTimeMillis();
        CoolNumbers.searchInHashSet(hash, input);
        long hashTime = System.currentTimeMillis() - hashStart;
        System.out.println(hash.contains(input));
        System.out.println("hashTime = " + hashTime);

        long treeStart = System.currentTimeMillis();
        CoolNumbers.searchInTreeSet(tree, input);
        long treeTime = System.currentTimeMillis() - treeStart;
        System.out.println(tree.contains(input));
        System.out.println("treeTime = " + treeTime);

        System.out.println("The minimum time" + Math.min(Math.min(bruteTime, binaryTime),
                Math.min(hashTime, treeTime)));

    }
}