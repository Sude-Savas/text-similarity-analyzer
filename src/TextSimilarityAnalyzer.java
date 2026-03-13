import java.util.HashMap;
import java.util.Scanner;
/*
 * Entry point of the application.
 * Handles user input and controls the program flow.
 */
class TextSimilarityAnalyzer{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome To The Text Similarity Analyzer");

        // Prompting user for file locations
        System.out.println("Enter first file path: ");
        String file1 = sc.nextLine();
        System.out.println("Enter second file path: ");
        String file2 = sc.nextLine();

        // Create processor that reads and processes both files
        TextProcessor tp = new TextProcessor(file1,file2);

        // Generate frequency maps for each file
        HashMap<String,Integer> m1 = tp.getWordCounts1();
        HashMap<String,Integer> m2 = tp.getWordCounts2();

        // Perform similarity calculation using the generated maps
        SimilarityCalculator sC = new SimilarityCalculator(m1,m2);

        // Display formatted analysis results
        System.out.println("-------------Text Similarity Analysis Results-------------");
        System.out.println("Common words are: "+sC.getCommonWords());
        System.out.println("Intersection Count: "+sC.getIntersection()+"\nUnion Count: "+sC.getUnion());
        System.out.printf("Similarity Rate: %.2f%%%n", sC.getSimilarityRate());
        sc.close();
    }
}