public class Arithmetic {

    private int x;
    private int y;

    public Arithmetic(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int sum(int x, int y) {
        return x + y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int max(int x, int y) {
        return Math.max(x, y);
    }

    public int min(int x, int y) {
        return Math.min(x, y);
    }
}