package EducativeCodes.InterviewQuestions.Dining_Philosopher;

import java.util.Random;

public class Philosopher implements Runnable {
    private int id;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;
    private Random random;
    private boolean full;
    private int counter=0;

    public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        random = new Random();
    }

    @Override
    public void run() {
        while(!full){
            try {
                think();
                if (leftChopstick.pickUp(this, State.LEFT)){
                    if(rightChopstick.pickUp(this, State.RIGHT)){
                        eat();
                        rightChopstick.putDown(this, State.RIGHT);
                    }
                    leftChopstick.putDown(this, State.LEFT);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void think() throws InterruptedException {
        System.out.println(this+" philosopher think");
        Thread.sleep(random.nextInt(500));
    }

    public void eat() throws InterruptedException {
        System.out.println(this+" eating.");
        counter++;
        Thread.sleep(random.nextInt(500));
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public boolean isFull() {
        return full;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString(){
        return "Philosopher" + id;
    }
}
