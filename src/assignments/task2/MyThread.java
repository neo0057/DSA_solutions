package assignments.task2;

public class MyThread implements Runnable {
    public String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            System.out.println(name + " " + (i + 1));
        }
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("s");
        MyThread myThread2 = new MyThread("t");
        Thread s = new Thread(myThread1, "s");
        Thread t = new Thread(myThread2, "t");
        System.out.println("starting run method call...");
        s.run();
        t.run();
        System.out.println("starting start method call...");
        s.start();
        t.start();
    }
}
