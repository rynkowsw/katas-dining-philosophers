/**
 * Created by wojciech on 23.07.17.
 */
public class Philosopher implements Runnable {

    private int number;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(Fork leftFork, Fork rightFork, int number) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.number = number;
    }

    private void sayWhatYouAreDoing(String action) throws InterruptedException {
        System.out.println( "Philosopher " + this.number + action );
        Thread.sleep(((int) (Math.random() * 100)));
    }

    @Override
    public void run() {
        try {
            while (true) {
                sayWhatYouAreDoing("I'm thinking");

                synchronized (leftFork) {

                    sayWhatYouAreDoing(" I picked up left fork");

                    synchronized (rightFork) {

                        sayWhatYouAreDoing("I picked up right fork");
                        sayWhatYouAreDoing("I'm eating");
                        sayWhatYouAreDoing("I'm putting down right fork");

                    }

                    sayWhatYouAreDoing("I'm backing to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}