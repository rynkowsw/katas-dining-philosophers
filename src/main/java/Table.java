import java.util.LinkedList;
import java.util.stream.IntStream;

public class Table {

    public LinkedList<Philosopher>  createPhilosophersInTable(int number)
    {
        LinkedList<Philosopher> philosophers = createNEmptyPhilosophers(number);
        addForkEveryPhilosopher(philosophers);
        setSharedForkBetweenLastAndFirstPhilosopher(philosophers);
        return philosophers;
    }

    private void addForkEveryPhilosopher(LinkedList<Philosopher> philosophers) {
        int numberOfPhilosophersWithoutLastOne = philosophers.size()-1;

        IntStream.range(0, numberOfPhilosophersWithoutLastOne)
                .forEach(
                        nbr ->  {
                            Philosopher philosopher = philosophers.get(nbr);
                            Philosopher nextPhilosopher = philosophers.get(nbr+1);

                            Fork fork = new Fork();
                            philosopher.setRightFork(fork, nbr);
                            nextPhilosopher.setLeftFork(fork, nbr+1);
                        });


    }

    private void setSharedForkBetweenLastAndFirstPhilosopher( LinkedList<Philosopher> philosophers ){
        Philosopher first = philosophers.getFirst();
        Philosopher last = philosophers.getLast();

        Fork sharedFork = new Fork();

        first.setLeftFork(sharedFork, 0);
        last.setRightFork(sharedFork, philosophers.size() -1 );

    }

    private  LinkedList<Philosopher> createNEmptyPhilosophers(int number) {

        LinkedList<Philosopher> philosophers = new LinkedList<>();

        IntStream.range(0, number).forEach(nbr ->  philosophers.add(new Philosopher()));

        return philosophers;
    }
}
