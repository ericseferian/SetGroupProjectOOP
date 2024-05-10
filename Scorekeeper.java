import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Scorekeeper {
    public static final String databasePath = "highscore.txt";
    private int highScore;
    public Scorekeeper() {
        load();
    }

    public void load() {

        try {
            Scanner sc = new Scanner(new FileInputStream(databasePath));
            this.highScore = sc.nextInt();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void save() {
        try {
            PrintWriter pw = new PrintWriter(databasePath);
            if (Game.points > highScore){
                pw.println(Game.points);
            }
            else pw.println("100");
            pw.close();

        } catch (FileNotFoundException e) {
            System.out.println("Cannot save into the database file.");
            System.exit(0);
        }
    }
}
