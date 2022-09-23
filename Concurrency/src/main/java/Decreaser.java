public class Decreaser implements Runnable{
    private MyStorage myStorage;

    public Decreaser(MyStorage myStorage) {
        this.myStorage = myStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            myStorage.minus();
        }
    }
}
