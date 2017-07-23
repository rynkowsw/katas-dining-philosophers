import java.util.ArrayList;

public class Table {

    ArrayList<Philosopher> philosophers;


    public Table() {
        createPhilosophers(5);
    }

    private void createPhilosophers(int number) {

        ArrayList<Fork> forks = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            forks.add(new Fork());
        }

        ArrayList<Philosopher> philosophers = new ArrayList<>();

        for (int i = 0; i < forks.size(); i++) {

            Fork leftFork = forks.get(i);
            Fork rightFork = forks.get((i + 1) % number);

            Philosopher philosopher = new Philosopher(rightFork, leftFork, i);
            if (i % 2 == 0 ) {
                philosopher = new Philosopher(leftFork, rightFork, i);
            }

            philosophers.add(philosopher);
        }


        this.philosophers = philosophers;
    }

    public void eatingPhilosophers() {
        philosophers.forEach(philosopher -> {
            Thread t = new Thread(philosopher);
            t.start();
        });
    }


    public static void main(String[] args) throws Exception {

        Table table = new Table();
        table.eatingPhilosophers();

    }

}
