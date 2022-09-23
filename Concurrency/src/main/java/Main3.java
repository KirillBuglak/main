public class Main3 {
    public static void main(String[] args) {
        MyStorage myStorage = new MyStorage();

        Thread thread1 = new Thread(new Increaser(myStorage));
        Thread thread2 = new Thread(new Decreaser(myStorage));

        thread1.start();
        thread2.start();
    }
}
