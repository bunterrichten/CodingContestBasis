import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        int lvl = 1; // umschreiben für level 2, level 3 etc.

        for (int subLvl = 1; subLvl <= 5; subLvl++) { // 1-5 sublevel - wenn du mehr hast, erhöhe die Zahl z.B. auf 8
            try {
                String path = "lvl" + lvl + "/level" + lvl + "_" + subLvl + ".in";

                List<String> lines = FileUtility.readFile(path);

                List<String> solutions = new ArrayList<>();

                for (int i = 1; i < lines.size(); i++) { // start at 1 to ignore 1st line which is just nr of lines
                    String line = lines.get(i);
                    String[] parts = line.split(" ");


                    // AB HIER BEGINNT DEIN EIGENTLICHER CODE
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);

                    int solution = x / 3 * y;
                    solutions.add(String.valueOf(solution)); // adde zu solutions deine Lösung pro Zeile
                    // ---------------------------------------
                }

                System.out.println(solutions); // DEBUG: damit du siehst was passiert
                FileUtility.writeFile("lvl" + lvl + "/lvl" + lvl + "_" + subLvl + ".out", solutions, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int lineNr = 0;

    }
}
