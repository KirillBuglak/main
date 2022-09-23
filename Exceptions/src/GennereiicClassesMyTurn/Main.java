package GennereiicClassesMyTurn;

public class Main {
    public static void main(String[] args) {

        Class1<Integer, Double, ?> class1 = new Class1<>(15, 20.5);
        Class1<Double, Integer, String> class11 = new Class1<Double, Integer, String>(12.2, 8);
        class1.doSmth();
        class11.doSmth();

        class1.getSecond(1,45,3);

    }
}
