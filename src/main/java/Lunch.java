import java.util.LinkedList;

/**
 * Created by wojciech on 23.07.17.
 */
public class Lunch {

    public static void main(String[] args) throws Exception {

        int numberOfEatingPhilosopgers = 6;

        Table table = new Table();

        LinkedList<Philosopher> philosophers = table.createPhilosophersInTable(numberOfEatingPhilosopgers);

        philosophers.forEach(philosopher -> {
                            Thread t = new Thread(new PhilosopherRunner(philosopher, philosopher.hashCode() ));
                            t.start();
                        }
                );
    }
}
