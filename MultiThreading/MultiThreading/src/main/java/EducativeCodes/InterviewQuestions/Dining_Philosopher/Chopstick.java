package EducativeCodes.InterviewQuestions.Dining_Philosopher;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private int id;
    private Lock lock;

    public Chopstick(int id) {
        this.id = id;
        lock = new ReentrantLock();
    }

    public boolean pickUp(Philosopher philosopher, State state) {
        if (lock.tryLock()) {
            System.out.println("Philosopher " + philosopher + " picked up "+ state +" chopstick: "+this.id);
            return true;
        }
        return false;
    }

    public void putDown(Philosopher philosopher, State state) {
        lock.unlock();
    }

    @Override
    public String toString() {
        return "Id: "+ id;
    }
}
