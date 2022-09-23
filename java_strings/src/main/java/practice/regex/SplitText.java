package practice.regex;

public class SplitText {

    public static void main(String[] args) {

        String text = "Представьте, что у вас есть строки подобного вида и вам нужно\n" +
                "создать метод, который будет вычленять из таких строк названия\n" +
                "кодировок: UTF-8, Windows-1251, ISO-8859-1 и так далее. Как это\n" +
                "можно сделать? Можно сначала воспользоваться специальными методами, которые\n" +
                "нам позволят определить позицию подстрок — “charset=” и точка с\n" +
                "запятой, следующие после “charset=”, и затем вычленить ту\n" +
                "подстроку, которая находится между этими двумя подстроками.\n" +
                "Давайте по шагам применим эти методы. Теперь нас будет интересовать позиция символа «;». Добавляем\n" +
                "ещё одну переменную, указывая в качестве второго параметра\n" +
                "отступ — это номер символа, после которого необходимо искать «;».\n" +
                "В данном случае это номер символа start. Обратите ещё раз внимание и запомните, что метод substring в\n" +
                "качестве второго параметра принимает номер символа, до которого\n" +
                "нужно извлечь подстроку, не включая символ end. Теперь представьте, что в метод попадут вот такие строки (см. скрин\n" +
                "выше) без указания кодировки. В первой строке нет слова charset;\n" +
                "во второй оно есть, но только со знаком равно; в третьей есть и\n" +
                "charset со знаком равно, и точка с запятой. Очевидно, метод\n" +
                "GetEncoding в таком случае работать не будет.\n" +
                "Давайте сделаем так, чтобы метод работал правильно. В первом\n" +
                "случае подстрока charset не будет найдена, и метод indexOf вернёт\n" +
                "значение, равное (-1), что будет означать, что переданная ему в\n" +
                "качестве параметра подстрока отсутствует в строке. Давайте, чтобы\n" +
                "проверять значение переменной start, уберём из её строки значение\n" +
                "длины и перенесём значение длины в строку String encoding.";
        System.out.println(splitTextIntoWords(text));
    }

    public static String splitTextIntoWords(String text) {

        StringBuilder stringBuilder = new StringBuilder();
//        String regex = "[\s!?.,;:'0-9]+";
        String regex = "[^A-zЁ-ё]+";
        String[] words = text.split(regex);
        if (words.length < 100) {
            return "";
        } else {

            for (String word : words) {
                if (word.equals(words[words.length - 1])) {
                    stringBuilder.append(word);
                } else {
                    stringBuilder.append(word).append(System.lineSeparator());
                }
            }
            return stringBuilder.toString();
        }
    }
}