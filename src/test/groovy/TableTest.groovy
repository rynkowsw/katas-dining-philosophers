import spock.lang.Specification

class TableTest extends Specification {

    int EVEN_NUMBER_OF_PHILOSOPHERS = 6

    def "Creator create defined number of philosophers"(){
        given:
            Table philosopherCreator = new Table()
        when:
            LinkedList<Philosopher> philosophers = philosopherCreator.createPhilosophersInTable(EVEN_NUMBER_OF_PHILOSOPHERS)
        then:
            philosophers.size() == EVEN_NUMBER_OF_PHILOSOPHERS
    }

    def "Left fork (supported) of first philosopher is right (supported) of last one"(){
        given:
            Table table = new Table()
        when:
            LinkedList<Philosopher> philosophers = table.createPhilosophersInTable(EVEN_NUMBER_OF_PHILOSOPHERS)
            Philosopher firstPhilosopher = philosophers.first
            Philosopher lastPhilosopher = philosophers.last
        then:
            firstPhilosopher.supportedFork != null
            lastPhilosopher.supportedFork != null

            firstPhilosopher.supportedFork == lastPhilosopher.supportedFork
    }


    def "All philosophers had their too forks" (){
        given:
            Table table = new Table()
        when:
            LinkedList<Philosopher> philosophers = table.createPhilosophersInTable(EVEN_NUMBER_OF_PHILOSOPHERS)
        then:
            everyPhilosophersHasTooForks(philosophers) == true

    }

    private boolean everyPhilosophersHasTooForks (LinkedList<Philosopher> philosophers){

        boolean result = true

        philosophers.forEach({
            if(it.supportedFork == null || it.mainFork == null ) {
                result = false
            }
        })

        return result
    }




}
