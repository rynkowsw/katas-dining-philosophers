import spock.lang.Specification

/**
 * Created by wojciech on 23.07.17.
 */
class PhilosopherTest extends Specification {

    def "Philosopher accept only when main fork is present"(){
        given: "Main fork is that fork what Philosopher will firstly try to get from table"
            Fork mainFork = new Fork()
        when:
            new Philosopher(mainFork, null)
        then:
            IllegalArgumentException ex = thrown()
            ex.message == Philosopher.PHILOSOPHER_CAN_NOT_EAT_WITHOUT_TOO_FORKS
    }

    def "Philosopher accept only when supported fork is present"(){
        given: "Supported fork is that fork what Philosopher will try to get from table after he will have main fork"
            Fork supportedFork = new Fork()
        when:
            new Philosopher(null, supportedFork)
        then:
            IllegalArgumentException ex = thrown()
            ex.message == Philosopher.PHILOSOPHER_CAN_NOT_EAT_WITHOUT_TOO_FORKS
    }

    def "Philosopher accept only when left fork is present"(){
        given:
            Philosopher philosopher = new Philosopher()
            int irrelevantNumber =1
        when:
            philosopher.setLeftFork(null,irrelevantNumber)
        then:
            IllegalArgumentException ex = thrown()
            ex.message == Philosopher.PHILOSOPHER_CAN_NOT_EAT_WITHOUT_TOO_FORKS
    }

    def "Philosopher accept only when right fork is present"(){
        given:
            Philosopher philosopher = new Philosopher()
            int irrelevantNumber =1
        when:
            philosopher.setRightFork(null,irrelevantNumber)
        then:
            IllegalArgumentException ex = thrown()
            ex.message == Philosopher.PHILOSOPHER_CAN_NOT_EAT_WITHOUT_TOO_FORKS
    }

    def "If the person has an even seat number, then it is right-handed"(){
        given:
            Philosopher philosopher = new Philosopher()
            int evenNumber =2
            Fork givenFork = new Fork()
        when:
            philosopher.setRightFork(givenFork,evenNumber)
        then:
            philosopher.getMainFork() == givenFork
        when:
            philosopher.setLeftFork(givenFork,evenNumber)
        then:
            philosopher.getSupportedFork() == givenFork
    }


    def "If the person has an even seat number, then it is left-handed"(){
        given:
            Philosopher philosopher = new Philosopher()
            int evenNumber =1
            Fork givenFork = Mock(Fork)
        when:
            philosopher.setLeftFork(givenFork,evenNumber)
        then:
            philosopher.getMainFork() == givenFork
    }

}
