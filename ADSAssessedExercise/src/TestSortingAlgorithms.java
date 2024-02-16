import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TestSortingAlgorithms {

    public static void main(String[] args) {
        // Specify the path to your input file
        String[] Path = {"intBig.txt","int1000.txt","int20k.txt","int500k.txt","dutch.txt","Bad.txt"};

        Path currentPath = Paths.get("").toAbsolutePath();
        Path rootDirectory = currentPath.getRoot();
        String rootDirectoryString = rootDirectory.toString();

        for (String path: Path){
            try {
                int[] data = readNumbersFromFile(rootDirectoryString + path);
                System.out.println("--------------------------------");
                System.out.println("Time taken to sort" + path + ":");

                SelectionSort selectionSort = new SelectionSort();  


                // Test and measure time for QuickSort
                long quickSortStartTime = System.currentTimeMillis();
                QuickSort quickSort = new QuickSort();
                quickSort.sort(Arrays.copyOf(data, data.length),,);
                long quickSortEndTime = System.currentTimeMillis();
                System.out.println("QuickSort Time: " + (quickSortEndTime - quickSortStartTime) + " milliseconds");

                // Test and measure time for MergeSort
                long mergeSortStartTime = System.currentTimeMillis();
                MergeSort mergeSort = new MergeSort();
                mergeSort.sort(Arrays.copyOf(data, data.length),,);
                long mergeSortEndTime = System.currentTimeMillis();
                System.out.println("MergeSort Time: " + (mergeSortEndTime - mergeSortStartTime) + " milliseconds");
                

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to read numbers from a text file
    public static int[] readNumbersFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int count = 0;

        // Count the number of lines in the file
        while (reader.readLine() != null) {
            count++;
        }

        int[] numbers = new int[count];
        reader.close();

        // Read the numbers from the file
        reader = new BufferedReader(new FileReader(filePath));
        for (int i = 0; i < count; i++) {
            line = reader.readLine();
            numbers[i] = Integer.parseInt(line.trim());
        }

        reader.close();
        return numbers;
    }
}