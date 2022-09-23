package practice.reverseArray;

public class Main {

    // используя данный метод, вы можете использовать ваши методы, и проверить их работу на разных
    // значений для проверки и отладки
    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String regex = ",?\\s+";
        String[] array = line.split(regex);
        for (String a : ReverseArray.reverse(array)) {
            System.out.println(a);
        }
    }
}
