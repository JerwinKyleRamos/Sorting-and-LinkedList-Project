/**
 * Group MixAndMatch
 * Class Code and Course Number: 9342 - CS 211
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     COLOMA, Stephen M.- 2232847@slu.edu.ph
 *     GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 *     NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 *     RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 *     RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 *     ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 *     SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 * </p>
 */
import util.CSVReader;
import java.util.ArrayList;

public class SelectionSort {
    public static void main(String[] args) {
        /*ALGORITHM:
         * 1. Initiate the 2D array of length 5 by 3.
         * 2. The row will be the size variant (10k,50k,200k,500k,1M)
         * 3. The column will be the type arrangement variant (Best, Worst, Average)
         * 4. Create a list of strings that stores the file path above. Follow format BEST-WORST-AVERAGE
         * 5. Initiate variable int fileNumber = 0, it is the position of Best10k in the list
         * 6. Create a double for loop that populates the 2D array.
         * 7. Call the displayCount method and pass in the 2D array.
         * */

        int sizeVariants = 5;
        int arrangementVariants = 3;

        long[][] results = new long[sizeVariants][arrangementVariants];

        ArrayList<String> filePathInList= createFilePathInList();

        int fileNumber = 0;

        for (int i = 0; i < sizeVariants; i++) {
            for (int j = 0; j < arrangementVariants; j++) {
                results[i][j] = selectionSort(filePathInList.get(fileNumber));
                fileNumber++;
                System.out.println("File: " + fileNumber);
            }
        }
        displayCounts(results);
    }

    private static ArrayList<String> createFilePathInList() {
        String Best10K = "src/dataset/TenThousand/10K-BestCase.csv";
        String Worst10K = "src/dataset/TenThousand/10K-WorstCase.csv";
        String Avg10K = "src/dataset/TenThousand/10K-AverageCase.csv";

        String Best50K = "src/dataset/FiftyThousand/50K-BestCase.csv";
        String Worst50K = "src/dataset/FiftyThousand/50K-WorstCase.csv";
        String Avg50K = "src/dataset/FiftyThousand/50K-AverageCase.csv";

        String Best200K = "src/dataset/TwoHundredThousand/200K-BestCase.csv";
        String Worst200K = "src/dataset/TwoHundredThousand/200K-WorstCase.csv";
        String Avg200K = "src/dataset/TwoHundredThousand/200K-AverageCase.csv";

        String Best500K = "src/dataset/FiveHundredThousand/500K-BestCase.csv";
        String Worst500K = "src/dataset/FiveHundredThousand/500K-WorstCase.csv";
        String Avg500K = "src/dataset/FiveHundredThousand/500K-AverageCase.csv";

        String Best1M = "src/dataset/OneMillion/1M-BestCase.csv";
        String Worst1M = "src/dataset/OneMillion/1M-WorstCase.csv";
        String Avg1M = "src/dataset/OneMillion/1M-AverageCase.csv";


        ArrayList<String> filePathsInList = new ArrayList<String>();

        filePathsInList.add(Best10K);
        filePathsInList.add(Worst10K);
        filePathsInList.add(Avg10K);

        filePathsInList.add(Best50K);
        filePathsInList.add(Worst50K);
        filePathsInList.add(Avg50K);

        filePathsInList.add(Best200K);
        filePathsInList.add(Worst200K);
        filePathsInList.add(Avg200K);

        filePathsInList.add(Best500K);
        filePathsInList.add(Worst500K);
        filePathsInList.add(Avg500K);

        filePathsInList.add(Best1M);
        filePathsInList.add(Worst1M);
        filePathsInList.add(Avg1M);

        return filePathsInList;
    }

    /**
     * Sorts the given array using the Selection Sort algorithm.
     * @param arr Array of Strings to be sorted.
     * @return int count of statements executed in the method.
     */
    public static long selectionSort(String arr) {
       /*
            ALGORITHM:
            1. Read data from the CSV file into an array.
            2. Initialize statementCount to 0.
            3. Iterate through the array using Bubble Sort algorithm
            4. Return the statementCount variable.
        */

        String[] array = CSVReader.readDataFromFile(arr);
        long statementCount = 0;

        for(int i=0; i < array.length-1; i++){
            statementCount += 4;
            int minIndex = i;
            statementCount++;

            for (int j=i+1; j < array.length; j++){
                statementCount += 4;
                if (array[j].compareToIgnoreCase(array[minIndex]) < 0) {
                    statementCount ++;
                    minIndex = j;
                    statementCount++;
                }
            }
            String temp = array[minIndex];
            statementCount++;
            array [minIndex] = array[i];
            statementCount ++;
            array[i] = temp;
            statementCount++;
        }
        return statementCount;
    } // end of selectionSort method




    public static void displayCounts(long[][] results){
        String[] sizes = {"10 thousand", "50 thousand", "200 thousand", "500 thousand", "1 million"};

        System.out.printf("%-40S%-30S%-30S%-30S","SELECTION SORT RESULTS","BEST CASE","WORST CASE","AVERAGE CASE");
        System.out.println();
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j<1; j++) {
                System.out.printf("%-40s%,-30d%,-30d%,-30d",sizes[i],results[i][j],results[i][j+1],results[i][j+2]);
                System.out.println();
            }
        }
    }
} // end of SelectionSort class

