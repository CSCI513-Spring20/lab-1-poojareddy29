public class SelectionSort implements SortStrategy {
    long totalTime;
    long startTime;
    long endTime;

    public long[] sort(long[] population) {
        startTime = System.currentTimeMillis();
        int len = population.length;
        for(int i=0; i<len-1; i++) {
            int min = i;
            for (int j = i+1; j<len; j++) {
                if (population[j] < population[min]) {
                    min = j;
                }
            }
            long temp = population[i];
            population[i] = population[min];
            population[min] = temp;
        }
        endTime = System.currentTimeMillis();
        return population;
    }

    public long getSortTime() {
        return totalTime = endTime - startTime;
    }

    public String strategyName() {
        return "Selection Sort";
    }
}
