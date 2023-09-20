import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class UseKey {
    public void readFile(Map<Integer, String> readTo) {
        try {
            FileReader f = new FileReader("src/key.txt");
            BufferedReader br = new BufferedReader(f);
            String line;
            String[] splitLine;
            while ((line = br.readLine()) != null) {
                splitLine = line.split(",");
                readTo.put(Integer.parseInt(splitLine[0]), splitLine[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
