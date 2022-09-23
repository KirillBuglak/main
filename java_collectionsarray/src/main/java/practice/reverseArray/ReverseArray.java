package practice.reverseArray;

public class ReverseArray {

    public static String[] reverse(String[] strings) {
        int lastElementIndex = strings.length - 1;
        String[] reversedStrings = new String[strings.length];

        for (int i = lastElementIndex; i >= 0; i--) {
            reversedStrings[lastElementIndex - i] = strings[i];
        }
        for (int i = 0; i < reversedStrings.length; i++) {
            strings[i] = reversedStrings[i];
        }
        return strings;
    }

}