package assignments.manfred.task2;

public class THREADS_main {
    static class MyThread implements Runnable {
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
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("s");
        MyThread myThread2 = new MyThread("t");

        // transfer myThread object to thread class instance
        Thread s = new Thread(myThread1);
        Thread t = new Thread(myThread2);

        System.out.println("starting run method call...");
        s.run();
        t.run();

        System.out.println("starting start method call...");
        s.start();
        t.start();

        /*
         When a program calls the start() method, a new thread is created and then the run() method is executed.
         But if we directly call the run() method then no new thread will be created and run() method will be executed as a normal method call on the current calling
         thread itself and no multi-threading will take place
         */
    }
}
