import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryLoader {
    public static Map<String, String> loadFromFile(String path) throws FileNotFoundException {

        Map<String, String> words = new HashMap<>();

        FileInputStream fis = new FileInputStream(path);
        Scanner sc = new Scanner(fis);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // Splitting the line on ,

            int commaPosition = -1;

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    commaPosition = i;
                }
            }

            String key = line.substring(0, commaPosition).strip();
            String value = line.substring(commaPosition + 1, line.length()).strip();

            words.put(key, value);

        }
        sc.close();

        return words;

    }

}
