import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Leader {
    String userName;
    int userXP;

    public Leader(String userName, int userXP) {
        this.userName = userName;
        this.userXP = userXP;
    }
}

public class Leaderboard {
    static String CSV_FILE = Login_System.CSV_FILE;

    public static void Leaderboard() {
        List<Leader> leaders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    int userXP = Integer.parseInt(parts[6]);
                    String userName = parts[5];
                    leaders.add(new Leader(userName, userXP));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(leaders, Comparator.comparingInt((Leader l) -> l.userXP).reversed());

        int n = 1;
        System.out.println("|ARABIC LEADERBOARD|");
        for (Leader leader : leaders) {
            System.out.println(n + ") " + leader.userName + " | XP: " + leader.userXP);
            n++;
        }
    }
}
