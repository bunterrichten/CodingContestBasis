import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        int lvl = 1;

        for (int subLvl = 1; subLvl <= 5; subLvl++) {
            try {
                String path = "lvl" + lvl + "/level" + lvl + "_" + subLvl + ".in";

                List<String> lines = FileUtility.readFile(path);

                List<String> solutions = new ArrayList<>();

                for (int i = 1; i < lines.size(); i++) { // start at 1 to ignore 1st line which is just nr of lines
                    String line = lines.get(i);
                    String[] parts = line.split(" ");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);

                    int solution = x / 3 * y;
                    solutions.add(String.valueOf(solution));
                }

                System.out.println(solutions);
                FileUtility.writeFile("lvl" + lvl + "/lvl" + lvl + "_" + subLvl + ".out", solutions, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int lineNr = 0;

    }
}
