package main.java.com.bobocodeCourseVL;

public class Main {

    public static void main(String[] args) {
        DeadlockImpl job = new DeadlockImpl();
        Thread worker01Thread = new Thread(job, "worker_1");
        Thread worker02Thread = new Thread(job, "worker_2");

        worker01Thread.start();
        worker02Thread.start();
    }
}
