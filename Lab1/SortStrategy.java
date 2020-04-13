public interface SortStrategy {
    long[] sort(long[] numbers);
    long getSortTime();
    String strategyName();
}