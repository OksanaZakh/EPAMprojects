package textmodifier.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

    public static String readText(String path, String name) throws IOException {
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path + "\\" + name))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            text = sb.toString();
            return text;
        }
    }

    public static boolean isDirectory(String dir) {
        File dirFile = new File(dir);
        return dirFile.isDirectory();
    }

    public static boolean isFileExist(String path, String name) {
        File file = new File(path + "\\" + name);
        return file.exists();
    }
}
