import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtility {
    public static void main(String[] args) {
        String path = "src";
        displayFilesRec(path);
    }

    public static List<String> readFile(String path) {
        File f = new File(path);
        List<String> lines = new ArrayList<String>();

        try {
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lines.add(line);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            return lines;
        }
    }

    public static void writeFile(String path, List<String> lines, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(path, append);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            String content = "";
            int count = 0;
            for (String line : lines) {
                content += line;
                if (count < lines.size() - 1)
                    content += "\n"; // only add if not last line
                count++;
            }
            System.out.println("write: " + content);
            writer.write(content);
            writer.close();
        } catch (Exception e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void displayFilesRec(String path) {

        displayFilesRec(new File(path), 0);
    }

    public static void displayFilesRec(File f, int depth) {
        if (f.exists()) {
            System.out.println("-".repeat(depth) + f.getName());

            if (f.isDirectory()) {
                for (File subs : f.listFiles()) {
                    displayFilesRec(subs, depth + 1);
                }
            }
        }
    }
}
