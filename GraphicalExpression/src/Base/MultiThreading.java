package Base;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class MultiThreading {
   public static void main(String[] args) throws InterruptedException {

        MThread thread1 = new MThread("First one");
        MThread thread2 = new MThread("Second one");
        MThread thread3 = new MThread("Third one");
        Thread thread4 = new Thread(()-> System.out.println("BLAH, Lambda thing"));
        Thread justANewThread = new Thread("Just a Thread!");
        var sportsmen = new Sportsmen(10, 1000);

        Runnable task1 = ()->{
            sportsmen.swapScores(1,3, new Random().nextInt(100,1000));
        };
        Runnable task2 = ()->sportsmen.swapScores(3,2, new Random().nextInt(1,10));

    thread1.setDaemon(true);
    thread2.setDaemon(true);
       System.out.println("*****"+thread1.getName().toUpperCase(Locale.ROOT)+thread1.getState()+"*****");


        thread1.start();
       System.out.println("*****"+thread1.getName().toUpperCase(Locale.ROOT)+thread1.getState()+"*****");

       thread1.join(3000);
       System.out.println("*****"+thread2.getName().toUpperCase(Locale.ROOT)+thread2.getState()+"*****");
       thread2.start();

       if (thread1.isAlive())
            thread3.start();
        thread4.start();
        new Thread(task1).start();
        new Thread(task2).start();
//        thread2.stop();

    System.out.println("*****"+Thread.currentThread().getName()+Thread.currentThread().getState()+"*****");
    System.out.println("*****"+thread1.getName().toUpperCase(Locale.ROOT)+thread1.getState()+"*****");
    System.out.println("*****"+thread2.getName().toUpperCase(Locale.ROOT)+thread2.getState()+"*****");
    System.out.println("*****"+thread3.getName().toUpperCase(Locale.ROOT)+thread3.getState()+"*****");
    System.out.println("*****"+justANewThread.getName().toUpperCase(Locale.ROOT)+justANewThread.getState()+"*****");
    System.out.println(1/0);

   }
}

class MThread extends Thread{
    MThread(String name){
        this.setName(name);
    }
    public void run() {
        for (int i = 0; i <= 10; ++i) {
            System.out.println("Thread " + this.getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.err.println("Thread " + this.getName() + " is finished");
        System.out.println(Thread.currentThread().getState());
    }
}
class Sportsmen{
   double[] people;
    Sportsmen(int number, double starterScores) {
        people = new double[number];
        Arrays.fill(people, starterScores);
    }
   synchronized public void swapScores(int from, int to, double HowMuch){
        if (people[from] < HowMuch) return;
        System.out.println(Thread.currentThread());
        people[from]-=HowMuch;
        people[to]+=HowMuch;
        System.err.println(HowMuch+" was transferred form player " + from+" to player "+to);
        System.out.println("Player " + from + " has "+people[from]);
        System.out.println("Player " + to + " has "+people[to]);
    }
}