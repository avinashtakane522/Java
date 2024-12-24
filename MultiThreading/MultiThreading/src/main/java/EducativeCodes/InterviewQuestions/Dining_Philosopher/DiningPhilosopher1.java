package EducativeCodes.InterviewQuestions.Dining_Philosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiningPhilosopher1 {
    public static void main(String[] args) throws InterruptedException {
        Philosopher[] philosophes = null;
        Chopstick[] chopsticks = null;
        ExecutorService service = null;

        try{
            philosophes = new Philosopher[5];
            chopsticks = new Chopstick[5];

            for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICK; i++) {
                chopsticks[i] = new Chopstick(i);
            }

            service = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);
            for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHERS; i++) {
                philosophes[i] = new Philosopher(i, chopsticks[i], chopsticks[(i+1)%Constants.NUMBER_OF_CHOPSTICK]);
                service.execute(philosophes[i]);
            }

            Thread.sleep(Constants.SIMULATION_TIMING);

            for(Philosopher philosopher : philosophes){
                philosopher.setFull(true);
            }

        } finally {
            service.shutdown();

            while(!service.isTerminated()){
                Thread.sleep(1000);
            }

            for (Philosopher philosopher : philosophes) {
                System.out.println(philosopher.getCounter());
            }
        }
    }
}
