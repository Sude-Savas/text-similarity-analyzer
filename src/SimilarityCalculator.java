import java.util.ArrayList;
import java.util.HashMap;
/*
 * Calculates similarity between two text files
 * based on their word frequency maps.
 */
public class SimilarityCalculator {
    private double similarityRate;
    private int union;
    private int intersection;
    private ArrayList<String> commonWords = new ArrayList<>();

    public SimilarityCalculator(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        this.similarityRate = calculateSimilarity(map1, map2); // Automatically triggers calculation upon object creation
        commonWords.clear();
    }

    public double getSimilarityRate() {
        return similarityRate;
    }

    public int getIntersection() {
        return intersection;
    }

    public int getUnion() {
        return union;
    }

    public ArrayList<String> getCommonWords() {
        return commonWords;
    }

    /*
     * Computes Jaccard similarity by finding
     * the intersection and union of unique words.
     */
    public double calculateSimilarity(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        //Identify common words
        for (String word : map1.keySet()) {
            if (map2.containsKey(word)) {
                commonWords.add(word);
                intersection++;
            }
        }
        //Calculate Union using the formula: size(A) + size(B) - intersection
        union = map1.size() + map2.size() - intersection;
        similarityRate = ((double) intersection / union) * 100;
        return similarityRate;
    }
}
