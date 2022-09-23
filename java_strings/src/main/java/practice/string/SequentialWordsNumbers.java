package practice.string;

public class SequentialWordsNumbers {
    public static void main(String[] args) {
        String text = "This is, time has come, some text to work with";
        System.out.println(sequentialWordsNumbers(text));
    }

    public static String sequentialWordsNumbers(String text) {
        int spaceCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int spaceIndex = text.indexOf(" ");
        String[] words = new String[]{};

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (i==0){
                spaceCount++;
                stringBuilder.append("(").append(spaceCount).append(")").append(" ").append(symbol);
            }
            else if (Character.isSpaceChar(symbol)) {
                spaceCount++;
                stringBuilder.append(" ").append("(").append(spaceCount).append(")").append(" ");
            }else {
                stringBuilder.append(symbol);
            }
        }
        return stringBuilder.toString();
    }
}
