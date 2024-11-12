class SequentialRunner1 {
    public void execute() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner1: " + i);
        }
    }
}

class SequentialRunner2{
    public void execute() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner2: " + i);
        }
    }
}

public class Sequential{
    public static void main(String[] args) {
        SequentialRunner1 runner1 = new SequentialRunner1();
        SequentialRunner2 runner2 = new SequentialRunner2();

        runner1.execute();
        runner2.execute();
    }
}