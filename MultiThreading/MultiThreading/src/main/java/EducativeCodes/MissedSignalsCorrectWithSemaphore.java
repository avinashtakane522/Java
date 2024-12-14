package EducativeCodes;

import java.util.concurrent.Semaphore;

public class MissedSignalsCorrectWithSemaphore {
    private static final Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) {
        Thread waiter = new Thread(() -> {
            try {
                System.out.println("Waiter: Waiting for signal...");
                semaphore.acquire();  // Wait for signal
                System.out.println("Waiter: Signal received!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread signaller = new Thread(() -> {
            System.out.println("Signaller: Sending signal...");
            semaphore.release();  // Send signal
        });

        waiter.start();
        signaller.start();
    }
}
