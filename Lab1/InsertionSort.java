public class InsertionSort implements SortStrategy {
    long totalTime;
    long startTime;
    long endTime;

    public long[] sort(long[] population) {
        startTime = System.currentTimeMillis();
        int len = population.length;
        for( int i=1; i<len; i++) {
            long index= population[i]; int j=i;
            while( j>0&&population[j-1]>index ) {
                population[j] = population[j-1];
                j--;
            }
            population[j] = index;
        }
        endTime = System.currentTimeMillis();
        return population;
    }

    public long getSortTime() {
        return totalTime = endTime - startTime;
    }

    public String strategyName() {
        return "Insertion Sort";
    }
}