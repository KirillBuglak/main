public class Increaser implements Runnable {
    private MyStorage myStorage;

    public Increaser(MyStorage myStorage) {
        this.myStorage = myStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            myStorage.plus();
        }
    }
}
