public class Task implements Runnable {

    private long counter;
    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning) {
            counter++;
        }
        System.out.println("Counter Task - " + counter);
    }

    public long getCounter() {
        return counter;
    }

    public void stop() {
        isRunning = false;
    }
}
