public class MyStorage {

    private int size = 500;
    private int value = 0;

    public synchronized void plus(){
        if (value == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value++;
        System.out.println("Plus, size = " + (size - value));
        notify();
    }
    public synchronized void minus(){
        if (value == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value--;
        System.out.println("Minus, size = " + (size - value));
        notify();
    }
}
