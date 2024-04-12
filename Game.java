import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    //window properties
    JFrame window;
    JLabel titleNameLabel;
    JPanel titleNamePanel, startButtonPanel;
    JButton startButton;
    Container con;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

    //game properties
    private ArrayList<Card> deck;

    public Game() {
        
        //create UI window
        window = new JFrame();
        window.setSize(1600, 1200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        //"SET"
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(475, 200, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("SET");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        con.add(titleNamePanel);


        //Start button (Doesn't work yet)
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(670, 800, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);

        startButtonPanel.add(startButton);
        titleNamePanel.add(titleNameLabel);

        con.add(startButtonPanel);
        window.setVisible(true);

        //create card deck
        this.deck = Card.makeDeck();
        Collections.shuffle(this.deck);
    }

    public ArrayList<Card> generateCards() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            cards.add(this.deck.remove(0));
        }
        return cards;
    }

    public static void main(String[] args) {
        Game game = new Game();
        ArrayList<Card> cards = game.generateCards();

        System.out.println("Generated Cards:");
        for (Card card : cards) {
            System.out.println(card);
        }
    }



}


