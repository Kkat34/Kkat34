import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FrequencyCounter_A4 {

    public static void main(String[] args) {
        String inputFileName = "dictionaries_summary.txt";
        String outputFileName = "FrequencyCounter_A4_output.txt";

        Map<String, Integer> wordCounts = new HashMap<>();

        try {
            Scanner scanner = new Scanner(new File(inputFileName));

            while (scanner.hasNext()) {
                String word = scanner.next()
                        .toLowerCase()
                        .replaceAll("[^a-zA-Z0-9]", ""); // Remove punctuation

                if (!word.isEmpty()) {
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFileName);
            return;
        }

        // Sort entries by value (frequency) in descending order
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCounts.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Output to file
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            writer.printf("%-40s%s%n", "Word", "Count");
            writer.println("--------------------------------------------");

            for (Map.Entry<String, Integer> entry : sortedList) {
                writer.printf("%-40s%d%n", entry.getKey(), entry.getValue());
            }

            System.out.println("Output written to " + outputFileName);

        } catch (FileNotFoundException e) {
            System.out.println("Failed to write output file: " + outputFileName);
        }
    }
}