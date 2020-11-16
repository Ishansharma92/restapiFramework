import java.io.File;
import java.io.FileWriter;

public class FileIOUtil {

    public static void writeToFile(String names) throws Exception {
        File file = new File("CountryNames.txt");
        FileWriter writer = new FileWriter(file);
        writer.write(names);
        writer.close();
    }
}
