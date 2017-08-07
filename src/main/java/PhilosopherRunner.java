/**
 * Created by wojciech on 23.07.17.
 */
public class PhilosopherRunner extends Philosopher implements Runnable {

    private int identificationId;

    public PhilosopherRunner(Philosopher philosopher, int identificationId) {
        super(
                philosopher.getMainFork(),
                philosopher.getSupportedFork()
        );

        this.identificationId = identificationId;
    }

    private void sayWhatYouAreDoing(String action) throws InterruptedException {
        System.out.println( "Philosopher " + this.identificationId + " " + action );
        Thread.sleep(((int) (Math.random() * 100)));
    }

    @Override
    public void run() {
        try {
            while (true) {
                sayWhatYouAreDoing("I'm thinking");

                synchronized (mainFork) {

                    sayWhatYouAreDoing(" I picked up main fork");

                    synchronized (supportedFork) {

                        sayWhatYouAreDoing("I picked up supported fork");
                        sayWhatYouAreDoing("I'm eating");
                        sayWhatYouAreDoing("I'm putting supported fork");

                    }
                    sayWhatYouAreDoing("I'm putting down main fork");
                    sayWhatYouAreDoing("I'm backing to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

}
