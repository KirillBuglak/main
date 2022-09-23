package practice;

import java.util.*;

public class CoolNumbers {
    private static String lets = "[АВЕКМНОРСТУХ]";
    //    регион (от 01 до 199)
    private static String REGEX = lets + "[0-9]{3}" + lets + lets;
    static List<String> arrayList = new ArrayList<>();

    private static String myRandomNumber() {
        String letters = "АВЕКМНОРСТУХ";
        String region;
        int d = (int) (199 - Math.round(Math.random() * 199));
        if (String.valueOf(d).length() == 1) {
            region = "0" + d;
        } else {
            region = String.valueOf(d);
        }
        int digit = (int) (9 - Math.round(Math.random() * 9));
        int index1 = (int) ((letters.length() - 1) - Math.round(Math.random() * (letters.length() - 1)));
        char ch1 = letters.charAt(index1);
        int index2 = (int) ((letters.length() - 1) - (Math.round(Math.random() * (letters.length() - 1))));
        char ch2 = letters.charAt(index2);
        int index3 = (int) ((letters.length() - 1) - (Math.round(Math.random() * (letters.length() - 1))));
        char ch3 = letters.charAt(index3);
        String string = String.format("%1$c%2$d%2$d%2$d%3$c%4$c%5$s", ch1, digit, ch2, ch3, region);

        return string;
    }

    public static List<String> generateCoolNumbers() {
        for (int i = 0; arrayList.size() < 2000000; i++) {

            arrayList.add(myRandomNumber());
        }
        return arrayList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
//        Collections.sort(arrayList);
        return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        return treeSet.contains(number);
    }

}
