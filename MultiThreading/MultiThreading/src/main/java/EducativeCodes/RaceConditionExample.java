package EducativeCodes;

class BankAccount {
    private int balance = 100;

    //To avoid this synchronize the withdraw method.
    //public synchronized void withdraw(int amount)
    public void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount; // Deduct amount
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " cannot withdraw. Insufficient balance!");
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class RaceConditionExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Two threads trying to withdraw money simultaneously
        Thread t1 = new Thread(() -> account.withdraw(80), "Thread 1");
        Thread t2 = new Thread(() -> account.withdraw(50), "Thread 2");

        t1.start();
        t2.start();
    }
}

