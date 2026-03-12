import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/*
 * Responsible for reading text files and converting them
 * into word frequency maps.
 *
 * Each file is processed and stored as:
 * word -> number of occurrences
 */


public class TextProcessor {
    private HashMap<String, Integer> wordCounts1 = new HashMap<>();
    private HashMap<String, Integer> wordCounts2 = new HashMap<>();

    public TextProcessor(String path1, String path2) {
        wordCounts1 = processFile(path1);
        wordCounts2 = processFile(path2);
    }

    public HashMap<String, Integer> getWordCounts1() {
        return wordCounts1;
    }

    public HashMap<String, Integer> getWordCounts2() {
        return wordCounts2;
    }

    /*
     * Reads a text file and returns a HashMap containing
     * word and its frequencies in the file.
     */
    public HashMap<String, Integer> processFile(String path) {
        String[] words;
        HashMap<String, Integer> temp = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                //Converts all words to lowercase so they are treated the same
                line = line.toLowerCase();
                //Removes everything that isn't a word
                line = line.replaceAll("[^a-z0-9\\s]", "");
                words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isBlank()) {
                        if (temp.containsKey(word)) {
                            temp.put(word, temp.get(word) + 1);
                        } else {
                            temp.put(word, 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }
}
