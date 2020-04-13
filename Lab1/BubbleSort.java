public class BubbleSort implements SortStrategy {
    long totalTime;
    long startTime;
    long endTime;

    public long[] sort(long[] population) {
        startTime = System.currentTimeMillis();
        for( int i=(population.length-1); i>=0; i-- ) {
            for( int j=1; j<=i; j++ ) {
                if( population[j-1] > population[j] ) {
                    long temp = population[j-1];
                    population[j-1] = population[j];
                    population[j] = temp;
                }
            }
        }
        endTime = System.currentTimeMillis();
        return population;
    }

    public long getSortTime() {
        return totalTime = endTime-startTime;
    }

    public String strategyName() {
        return "Bubble Sort";
    }

}
