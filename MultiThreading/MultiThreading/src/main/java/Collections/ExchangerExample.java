package Collections;

import java.util.*;
import java.util.concurrent.Exchanger;

class FirstSchool implements Runnable {
    private List<String> name;
    private Exchanger<String> exchanger;

    public FirstSchool(List<String> name ,Exchanger<String> exchanger) {
        this.name = name;
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
            System.out.println("First School transffer first student "+name);
            int fcount = name.size();
            try {
                for (int i = 0; i < fcount; i++) {
                    String exchangedName = exchanger.exchange(name.get(i));
                    System.out.println("First School exchanged: " + name.get(i) + " with " + exchangedName);
                    name.add(exchangedName);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("After First School transffer students "+name);
            }
        }
    public void showChanges(){
        name.stream().forEach(System.out::print);
    }
}

class SecondSchool implements Runnable {
    private List<String> name;
    private Exchanger<String> exchanger;

    public SecondSchool(List<String> name ,Exchanger<String> exchanger) {
        this.name = name;
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
            System.out.println("Second School transffer first student "+name);
            int scount = name.size();
            try {
                for (int i = 0; i < scount; i++) {
                    String exchangedName = exchanger.exchange(name.get(i));
                    System.out.println("Second School exchanged: " + name.get(i) + " with " + exchangedName);
                    name.add(exchangedName);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("After Second School transffer students "+name);
            }
        }
    public void showChanges(){
        name.stream().forEach(System.out::print);
    }
}

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        List<String> s1 = new ArrayList<>(List.of("S1_Akash", "S1_Bhavesh", "S1_Cheery"));
        List<String> s2 = new ArrayList<>(List.of("S2_Satish", "S2_Hari", "S2_Jatin"));

        FirstSchool fs = new FirstSchool(s1,exchanger);
        SecondSchool ss = new SecondSchool(s2,exchanger);

        new Thread(fs).start();
        new Thread(ss).start();
    }
}
