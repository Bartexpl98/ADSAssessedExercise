import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TestSortingAlgorithms {

    public static void main(String[] args) {
        // Specify the path to your input file
        String[] Path = {"\\ADSAssessedExercise\\int1000.txt", "\\ADSAssessedExercise\\int20k.txt","\\ADSAssessedExercise\\int500k.txt",
        "\\ADSAssessedExercise\\dutch.txt","\\ADSAssessedExercise\\Bad.txt","\\ADSAssessedExercise\\intBig.txt"};

        Path currentPath = Paths.get("").toAbsolutePath();
        String currentPathString =currentPath.toString();
        //System.out.println(currentPath);
      //  Path rootDirectory = currentPath.getRoot();
      //  System.out.println(rootDirectory);
      //  String rootDirectoryString = rootDirectory.toString();


        for (String path: Path){
            try {
                System.out.println(currentPathString+path);
                int[] data7 = readNumbersFromFile(currentPathString + path);
                int[] data1 = readNumbersFromFile(currentPathString + path);
                int[] data2 = readNumbersFromFile(currentPathString + path);
                int[] data3 = readNumbersFromFile(currentPathString + path);
                int[] data4 = readNumbersFromFile(currentPathString + path);
                int[] data5 = readNumbersFromFile(currentPathString + path);
                int[] data6 = readNumbersFromFile(currentPathString + path);
                System.out.println("--------------------------------");
                System.out.println("Time taken to sort" + path + ":");

                // Test and measure time for QuickSort
                long quickSortStartTime = System.currentTimeMillis();
                QuickSort.sort(data1,0, data1.length-1); 
                long quickSortEndTime = System.currentTimeMillis();
                System.out.println("QuickSort Time: " + (quickSortEndTime - quickSortStartTime) + " ms");

                //QuickSortVariant
                long quickSortVariantStartTime = System.currentTimeMillis();
                QuickSortVariant.sort(data2,0,data2.length-1,10);
                long quickSortVariantEndTime = System.currentTimeMillis();
                System.out.println("QuickSortVariant Time: " + (quickSortVariantEndTime - quickSortVariantStartTime) + " ms");


                //ThreeWayQuickSort
                long threeWayQuickSortStartTime = System.currentTimeMillis();
                ThreeWayQuickSort.sort(data2,0,data3.length-1);
                long threeWayQuickSortEndTime = System.currentTimeMillis();
                System.out.println("ThreeWayQuickSort Time: " + (threeWayQuickSortEndTime - threeWayQuickSortStartTime) + " ms");

                // Test and measure time for MergeSort
                long mergeSortStartTime = System.currentTimeMillis();
                MergeSort.sort(data4,0,data4.length-1);
                long mergeSortEndTime = System.currentTimeMillis();
                System.out.println("MergeSort Time: " + (mergeSortEndTime - mergeSortStartTime) + " ms");


                //ShellSort
                long shellSortStartTime = System.currentTimeMillis();
                ShellSort.sort(data5);
                long shellSortEndTime = System.currentTimeMillis();
                System.out.println("ShellSort Time:" + (shellSortEndTime-shellSortStartTime) + " ms");
                //SelectionSort
                long selectionSortStartTime = System.currentTimeMillis();
                SelectionSort.sort(data6);
                long selectionSortEndTime = System.currentTimeMillis();
                System.out.println("SelectionSort Time:" + (selectionSortEndTime-selectionSortStartTime) + " ms");
                //InsertionSort
                long insertionSortStartTime = System.currentTimeMillis();
                SelectionSort.sort(data7);
                long insertionSortEndTime = System.currentTimeMillis();
                System.out.println("InsertionSort Time:" + (insertionSortEndTime-insertionSortStartTime) + " ms");                
                

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int[] readNumbersFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int count = 0;

        while (reader.readLine() != null) {
            count++;
        }

        int[] numbers = new int[count];
        reader.close();

        reader = new BufferedReader(new FileReader(filePath));
        for (int i = 0; i < count; i++) {
            line = reader.readLine();
            numbers[i] = Integer.parseInt(line.trim());
        }

        reader.close();
        return numbers;
    }
}