package Collections;

import java.util.concurrent.CopyOnWriteArrayList;

class ReaderThread extends Thread {
    private CopyOnWriteArrayList<String> list;

    public ReaderThread(CopyOnWriteArrayList<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            // Reading elements from the list
            for (String item : list) {
                Thread.sleep(2000); // Simulate some work being done
                System.out.println("Reader Thread: " + item);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WriterThread extends Thread {
    private CopyOnWriteArrayList<String> list;

    public WriterThread(CopyOnWriteArrayList<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            // Modify the list by adding new elements
            list.add("New Element 1");
            System.out.println("Writer Thread: Added 'New Element 1'");
            Thread.sleep(500); // Simulate some delay before next operation
            list.add("New Element 2");
            System.out.println("Writer Thread: Added 'New Element 2'");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CopyOnWriteExample {
    public static void main(String[] args) {
        // Create a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Add initial elements to the list
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        ReaderThread reader = new ReaderThread(list);
        WriterThread writer = new WriterThread(list);

        reader.start();
        writer.start();

        try {
            Thread.sleep(6100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Actual List now: "+list);
    }
}
