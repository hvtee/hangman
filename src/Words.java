import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Words {
    private final String word;
    public final String definition;
    public Map<String, String> wordsHashMap = Parser.getAllWords();


    public Words() {
        this.word = getRandomKeyFromHashMap((HashMap<String, String>) wordsHashMap);
        this.definition = wordsHashMap.get(word);
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public static String getRandomKeyFromHashMap(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            throw new IllegalArgumentException("HashMap is null or empty.");
        }

        Set<String> keySet = hashMap.keySet();
        String[] keys = keySet.toArray(new String[0]);

        Random random = new Random();

        return keys[random.nextInt(keys.length)];
    }
}
