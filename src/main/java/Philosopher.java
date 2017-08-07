import java.util.Optional;

public class Philosopher {

    static String PHILOSOPHER_CAN_NOT_EAT_WITHOUT_TOO_FORKS = "To eat everyone need too forks";

    protected Fork mainFork, supportedFork;

    public Philosopher(Fork mainFork, Fork supportedFork) {
        validateFork(mainFork);
        validateFork(supportedFork);

        this.mainFork = mainFork;
        this.supportedFork = supportedFork;
    }

    public Philosopher() {
    }

    private void validateFork(Fork fork){
        Optional.ofNullable(fork)
                .orElseThrow(() -> new IllegalArgumentException(PHILOSOPHER_CAN_NOT_EAT_WITHOUT_TOO_FORKS));
    }

    public Fork getMainFork() {
        return mainFork;
    }

    public Fork getSupportedFork() {
        return supportedFork;
    }

    public void setLeftFork(Fork leftFork, int numberInTheTable) {

        validateFork(leftFork);

        if(isRightHanded(numberInTheTable))
            this.supportedFork = leftFork;
        else
            this.mainFork = leftFork;
    }


    public void setRightFork(Fork rightFork, int numberInTheTable) {

        validateFork(rightFork);

        if(isRightHanded(numberInTheTable))
            this.mainFork = rightFork;
        else
            this.supportedFork = rightFork;
    }

    private boolean isRightHanded(int numberInTheTable){
        return numberInTheTable % 2 == 0;
    }
}