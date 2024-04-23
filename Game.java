import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    //window properties
    static JFrame window;
    JLabel titleNameLabel;
    static JPanel titleNamePanel, textPanel, cardPanel;
    static JPanel startButtonPanel, rulesButtonPanel, exitButtonPanel;
    JButton startButton, rulesButton, exitButton;
    static Container con;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    StartHandler sbHandler = new StartHandler();
    RulesHandler rbHandler = new RulesHandler();
    ExitHandler ebHandler = new ExitHandler();
    JTextArea textArea;

    static int cardWidth = 400; 
    static int cardHeight = 300;


    //game properties
    private static ArrayList<Card> deck;

    public Game() {

        //create UI window
        window = new JFrame();
        window.setSize(1600, 1200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null); //will change as needed.
        con = window.getContentPane();

        //"SET"
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(475, 200, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("SET");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        con.add(titleNamePanel);


        //Start button
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(670, 800, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(sbHandler);


        //Rules button
        rulesButtonPanel = new JPanel();
        rulesButtonPanel.setBounds(670, 850, 200, 100);
        rulesButtonPanel.setBackground(Color.black);
        rulesButton = new JButton("RULES");
        rulesButton.setBackground(Color.black);
        rulesButton.setForeground(Color.white);
        rulesButton.setFont(normalFont);
        rulesButton.setFocusPainted(false);
        rulesButton.addActionListener(rbHandler);



        //Exit button
        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(670, 950, 200, 100);
        exitButtonPanel.setBackground(Color.black);
        exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.white);
        exitButton.setFont(normalFont);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(ebHandler);

        //////////////
        rulesButtonPanel.add(rulesButton);
        startButtonPanel.add(startButton);
        exitButtonPanel.add(exitButton);
        titleNamePanel.add(titleNameLabel);

        con.add(rulesButtonPanel);
        con.add(startButtonPanel);
        con.add(exitButtonPanel);
        window.setVisible(true);
        //////////////


        //create card deck
        this.deck = Card.makeDeck();
        Collections.shuffle(this.deck);
    }

    public static void createGame() {

        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);
        rulesButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
        window.getContentPane().setBackground(Color.GRAY);

        textPanel = new JPanel();
        textPanel.setBounds(50,50, 800,400);
        textPanel.setSize(200,30);
        textPanel.setVisible(true);
        textPanel.setBackground(Color.WHITE);
        con.add(textPanel);


        cardPanel = new JPanel();
        cardPanel.setBounds(150, 300, 1200, 520);
        cardPanel.setLayout(new GridLayout(3, 4, 200, 100)); // 3 rows, 4 columns
        cardPanel.setBackground(Color.GRAY);


        // Generate and add 12 cards to the panel
        ArrayList<Card> cards = generateCards(deck);
        for (Card card : cards) {
            JPanel cardRect = new JPanel();
            addMouseListenerToCard(cardRect);
            cardRect.setPreferredSize(new Dimension(300, 200)); // Set size of each rectangle (Doesn't work and idk why)
            cardRect.setBackground(Color.DARK_GRAY); // Set background color for the rectangle


            ImageIcon cardImage = new ImageIcon(card.imagePath());
            JLabel cardLabel = new JLabel(cardImage);
            cardLabel.setBounds(0, 0, 500, 200); // Set bounds for the image label

            cardRect.add(cardLabel); // Add image label to rectangle panel
            cardPanel.add(cardRect); // Add rectangle panel to cardPanel
            System.out.println(card.imagePath());
        }


        con.add(cardPanel);

        JTextArea textArea = new JTextArea(" Hello? This is the Game Screen! ");
        textArea.setBounds(0,200,800,400);
        textArea.setLayout(null);
        textArea.setSize(1000,2000);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setVisible(true);
        //textArea.setLineWrap(true);
        textPanel.add(textArea);



    }

    public static void createRulesPage() {

        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);
        rulesButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
        window.getContentPane().setBackground(Color.BLACK);

        textPanel = new JPanel();
        textPanel.setBounds(50,50, 800,400);
        textPanel.setSize(180,30);
        textPanel.setVisible(true);
        textPanel.setBackground(Color.WHITE);
        con.add(textPanel);

        JTextArea textArea = new JTextArea(" Hello? This is the Rules Page! ");
        textArea.setBounds(0,200,800,400);
        textArea.setLayout(null);
        textArea.setSize(1000,2000);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setVisible(true);
        //textArea.setLineWrap(true);
        textPanel.add(textArea);

    }

    public static void exitGame() {
        window.setVisible(false);
        System.exit(0);

    }

    public static class StartHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            createGame();
        }
    }
    public static class RulesHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            createRulesPage();
        }
    }
    public static class ExitHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            exitGame();
        }
    }
    public static void addMouseListenerToCard(JPanel cardRect) {
        cardRect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (cardRect.getBackground() == Color.DARK_GRAY) {
                    cardRect.setBackground(Color.YELLOW); // Change to yellow on click
                } else {
                    cardRect.setBackground(Color.DARK_GRAY); // Change back to gray if already yellow
                }
            }
        });
    }

    public static ArrayList<Card> generateCards(ArrayList<Card> deck) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            cards.add(deck.remove(0));
        }
        return cards;
    }



    public static void main(String[] args) {
        Game game = new Game();
        }
    }


}


