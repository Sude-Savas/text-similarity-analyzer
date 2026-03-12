import java.util.HashMap;
/*
 * Calculates similarity between two text files
 * based on their word frequency maps.
 */
public class SimilarityCalculator {
    private int intersection= 0;
    private double similarityRate;

    public SimilarityCalculator(HashMap<String,Integer> map1,HashMap<String,Integer> map2){
        similarityRate=calculateSimilarity(map1,map2);
    }

    public int getIntersection() {
        return intersection;
    }

    public double getSimilarityRate() {
        return similarityRate;
    }

    public int calculateSimilarity(HashMap<String,Integer> map1,HashMap<String,Integer> map2){

    }
}
