package EducativeCodes.InterviewQuestions;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonCoffeeMachine {
    private static volatile SingletonCoffeeMachine instance;

    private SingletonCoffeeMachine(){}

    public static SingletonCoffeeMachine getInstance(){
        if (instance == null){
            synchronized (SingletonCoffeeMachine.class){
                if (instance == null){
                    instance = new SingletonCoffeeMachine();
                }
            }
        }
        return instance;
    }

    public String getCoffee(){
        return "Your Coffee is ready !!! Have good-day.";
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            int taskId = i;
            service.execute(() -> {
                SingletonCoffeeMachine machine = SingletonCoffeeMachine.getInstance();
                Thread.currentThread().setName("Thread-"+taskId);
                System.out.println(Thread.currentThread().getName() + " "+machine.getCoffee());
            });
        }
        service.shutdown();
    }
}