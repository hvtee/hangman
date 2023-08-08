import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Parser {
    public static <K, V> Map<K, V> getAllWords() {
        Map<K, V> map = new HashMap<>();
        String filepath = "russian_nouns_with_definition.txt";
        Charset encoding = Charset.forName("Windows-1251");

        try (FileReader fileReader = new FileReader(filepath, encoding);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();
            String[] parts = null;
            while (line != null) {

                parts = line.split(":");
                if (parts.length == 2) {
                    map.put((K) parts[0].trim(), (V) parts[1].trim());
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
