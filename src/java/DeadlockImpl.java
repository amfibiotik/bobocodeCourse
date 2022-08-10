public class DeadlockImpl implements Runnable {
    private final Object lock01 = new Object();
    private final Object lock02 = new Object();
    Worker worker01 = new Worker01();
    Worker worker02 = new Worker02();

    @Override
    public void run() {
        worker01.doWork();
        worker02.doWork();
    }

    public class Worker01 implements Worker {
        @Override
        public void doWork() {
            synchronized (lock01) {
                System.out.println(Thread.currentThread().getName() + " is doing some work");
                synchronized (lock02) {
                    System.out.println(Thread.currentThread().getName() + " is waiting for lock 02");
                }
            }
        }

    }

    public class Worker02 implements Worker {
        @Override
        public void doWork() {
            synchronized (lock02) {
                System.out.println(Thread.currentThread().getName() + " is doing some work");
                synchronized (lock01) {
                    System.out.println(Thread.currentThread().getName() + " is waiting for lock 01");
                }
            }
        }

    }

}
