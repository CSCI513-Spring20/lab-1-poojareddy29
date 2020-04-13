import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class WorldPopulation {

	SortStrategy sortStrategy;
	long[] population = new long[13484]; // Because we already know the number of records!

	public WorldPopulation() {
		sortStrategy = new BubbleSort();  // sets default strategy
	}

	public void readInputFile(String inputFile) {
		population = readPopulationFile(inputFile);
	}

	public void setStrategy(SortStrategy strategy) {
		sortStrategy = strategy;
	}

	// Reads in the WorldPopulation.csv
	// Extracts ONLY the numbers and stores them into population[]
	public long[] readPopulationFile(String fileName) {
		int index = 0;
		try {
			FileReader inputFile = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(inputFile);
			String line;
			// reads each line
			while((line = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				String countryName = tokenizer.nextToken();
				String year = tokenizer.nextToken();
				String pop = tokenizer.nextToken();
				long popCount = Long.parseLong(pop);
				population[index++]=popCount;
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return population;
	}

	public void sortPopulation() {
		sortStrategy.sort(population);
		System.out.println("Sorted using " + sortStrategy.strategyName() + " in " + sortStrategy.getSortTime() + " milliseconds.");
	}

	public void computeTotalPopulation() {
		System.out.println("dd");
	}

	public static void main(String[] args) {
		String fileName = "Lab1\\WorldPopulation.csv";
		if (args.length > 0) {
			if (!args[0].equals("")){
				fileName = args[0];
			}
		}
		System.out.println("input filename: "+ fileName);
		WorldPopulation worldPopulation = new WorldPopulation();
		worldPopulation.readInputFile(fileName);
		worldPopulation.setStrategy(new InsertionSort());
		worldPopulation.sortPopulation();
		worldPopulation.readInputFile(fileName);
		worldPopulation.setStrategy(new SelectionSort());
		worldPopulation.sortPopulation();
		worldPopulation.readInputFile(fileName);
		worldPopulation.setStrategy(new BubbleSort());
		worldPopulation.sortPopulation();

		// calling the sort methods for sorted
		System.out.println("\ncalling sort methods on sorted population:");
		worldPopulation.sortPopulation();
		worldPopulation.setStrategy(new SelectionSort());
		worldPopulation.sortPopulation();
		worldPopulation.setStrategy(new InsertionSort());
		worldPopulation.sortPopulation();
	}
}
