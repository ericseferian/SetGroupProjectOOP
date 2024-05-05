import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class Game {
    //window properties
    static JFrame window;
    JLabel titleNameLabel, difNameLabel;
    static JPanel titleNamePanel, pointsPanel, cardPanel, difNamePanel, rulesPanel;
    static JPanel startButtonPanel, rulesButtonPanel, exitButtonPanel, easyButtonPanel, mediumButtonPanel, hardButtonPanel, backButtonPanel, checkSetButtonPanel, mmButtonPanel, gameOverPanel, youWonPanel;
    JButton startButton, rulesButton, exitButton, easyButton, mediumButton, hardButton, backButton, checkSetButton, mmButton;
    static Container con;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    BackHandler bbHandler = new BackHandler();
    StartHandler sbHandler = new StartHandler();
    RulesHandler rbHandler = new RulesHandler();
    ExitHandler ebHandler = new ExitHandler();
    EasyHandler ezHandler = new EasyHandler();
    MediumHandler mdHandler = new MediumHandler();
    HardHandler hdHandler = new HardHandler();
    CheckSetHandler chHandler = new CheckSetHandler();
    MMHandler mmHandler = new MMHandler();
    static int points = 100; // Placeholder
    static boolean isEasy;
    static boolean isMedium;
    static boolean isHard;



    static JTextArea pointsArea;
    ImageIcon originalIcon = new ImageIcon("C:\\Users\\Mompas\\Downloads\\cover.png");

    // Calculate the desired width and height for the scaled image
    static int cardWidth = 400;  // Adjust as needed
    static int cardHeight = 300;  // Adjust as needed

    private static final ArrayList<Card> selectedCards = new ArrayList<>();
    private static ArrayList<JPanel> cardPanels = new ArrayList<>();



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
        startButton = new JButton("PLAY");
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



        //Easy
        easyButtonPanel = new JPanel();
        easyButtonPanel.setBounds(670, 725, 200, 50);
        easyButtonPanel.setBackground(Color.black);
        easyButton = new JButton("Easy");
        easyButton.setBackground(Color.black);
        easyButton.setForeground(Color.white);
        easyButton.setFont(normalFont);
        easyButton.setFocusPainted(false);
        easyButton.addActionListener(ezHandler);
        easyButtonPanel.setVisible(false);

        //Medium
        mediumButtonPanel = new JPanel();
        mediumButtonPanel.setBounds(670, 790, 200, 50);
        mediumButtonPanel.setBackground(Color.black);
        mediumButton = new JButton("Medium");
        mediumButton.setBackground(Color.black);
        mediumButton.setForeground(Color.white);
        mediumButton.setFont(normalFont);
        mediumButton.setFocusPainted(false);
        mediumButton.addActionListener(mdHandler);
        mediumButtonPanel.setVisible(false);

        //Hard
        hardButtonPanel = new JPanel();
        hardButtonPanel.setBounds(670, 855, 200, 50);
        hardButtonPanel.setBackground(Color.black);
        hardButton = new JButton("Hard");
        hardButton.setBackground(Color.black);
        hardButton.setForeground(Color.white);
        hardButton.setFont(normalFont);
        hardButton.setFocusPainted(false);
        hardButton.addActionListener(hdHandler);
        hardButtonPanel.setVisible(false);

        //Back
        backButtonPanel = new JPanel();
        backButtonPanel.setBounds(670, 1000, 200, 50);
        backButtonPanel.setBackground(Color.black);
        backButton = new JButton("Back");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setFont(normalFont);
        backButton.setFocusPainted(false);
        backButton.addActionListener(bbHandler);
        backButtonPanel.setVisible(false);

        //"Select Difficulty"
        difNamePanel = new JPanel();
        difNamePanel.setBounds(300, 300, 1000, 150);
        difNamePanel.setBackground(Color.black);
        difNameLabel = new JLabel("Select Difficulty");
        difNameLabel.setForeground(Color.white);
        difNameLabel.setFont(titleFont);
        difNamePanel.setVisible(false);
        difNamePanel.add(difNameLabel);

        con.add(difNamePanel);

        //Check Set button
        checkSetButtonPanel = new JPanel();
        checkSetButtonPanel.setBounds(1300, 100, 200, 100);
        checkSetButtonPanel.setBackground(Color.GRAY);
        checkSetButton = new JButton("SET!");
        checkSetButton.setBackground(Color.green);
        checkSetButton.setForeground(Color.black);
        checkSetButton.setFont(normalFont);
        checkSetButton.setFocusPainted(false);
        checkSetButton.addActionListener(chHandler);
        checkSetButtonPanel.setVisible(false);

        //Main Menu Button
        mmButtonPanel = new JPanel();
        mmButtonPanel.setBounds(100, 100, 300, 100);
        mmButtonPanel.setBackground(Color.GRAY);
        mmButton = new JButton("Main Menu");
        mmButton.setBackground(Color.DARK_GRAY);
        mmButton.setForeground(Color.black);
        mmButton.setFont(normalFont);
        mmButton.setFocusPainted(false);
        mmButton.addActionListener(mmHandler);
        mmButtonPanel.setVisible(false);


        //////////////
        rulesButtonPanel.add(rulesButton);
        startButtonPanel.add(startButton);
        exitButtonPanel.add(exitButton);
        titleNamePanel.add(titleNameLabel);
        easyButtonPanel.add(easyButton);
        mediumButtonPanel.add(mediumButton);
        hardButtonPanel.add(hardButton);
        backButtonPanel.add(backButton);
        checkSetButtonPanel.add(checkSetButton);
        mmButtonPanel.add(mmButton);

        con.add(rulesButtonPanel);
        con.add(startButtonPanel);
        con.add(exitButtonPanel);
        con.add(easyButtonPanel);
        con.add(mediumButtonPanel);
        con.add(hardButtonPanel);
        con.add(backButtonPanel);
        con.add(checkSetButtonPanel);
        con.add(mmButtonPanel);
        window.setVisible(true);
        //////////////


        //create card deck
        this.deck = Card.makeDeck();
        Collections.shuffle(this.deck);
    }

    public static void createDifMenu() {
        easyButtonPanel.setVisible(true);
        mediumButtonPanel.setVisible(true);
        hardButtonPanel.setVisible(true);
        exitButtonPanel.setVisible(false);
        rulesButtonPanel.setVisible(false);
        startButtonPanel.setVisible(false);
        difNamePanel.setVisible(true);
        titleNamePanel.setVisible(false);
        backButtonPanel.setVisible(true);
        checkSetButtonPanel.setVisible(false);

    }

    public static void hideDifMenu() {
        easyButtonPanel.setVisible(false);
        mediumButtonPanel.setVisible(false);
        hardButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(true);
        rulesButtonPanel.setVisible(true);
        startButtonPanel.setVisible(true);
        difNamePanel.setVisible(false);
        titleNamePanel.setVisible(true);
        backButtonPanel.setVisible(false);
        checkSetButtonPanel.setVisible(false);
        if(rulesPanel != null) rulesPanel.setVisible(false);


    }

    public static void createMainMenu() {
        startButtonPanel.setVisible(true);
        titleNamePanel.setVisible(true);
        rulesButtonPanel.setVisible(true);
        exitButtonPanel.setVisible(true);
        easyButtonPanel.setVisible(false);
        mediumButtonPanel.setVisible(false);
        hardButtonPanel.setVisible(false);
        difNamePanel.setVisible(false);
        backButtonPanel.setVisible(false);
        mmButtonPanel.setVisible(false);
        cardPanel.setVisible(false);
        window.getContentPane().setBackground(Color.BLACK);
        checkSetButtonPanel.setVisible(false);
        pointsPanel.setVisible(false);
        if(gameOverPanel != null) gameOverPanel.setVisible(false);
        if(youWonPanel != null) youWonPanel.setVisible(false);

    }

    public static void createEasyGame() {

        isEasy = true;
        isMedium = false;
        isHard = false;
        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);
        rulesButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
        easyButtonPanel.setVisible(false);
        mediumButtonPanel.setVisible(false);
        hardButtonPanel.setVisible(false);
        difNamePanel.setVisible(false);
        backButtonPanel.setVisible(false);
        mmButtonPanel.setVisible(true);


        window.getContentPane().setBackground(Color.GRAY);

        pointsPanel = new JPanel();
        pointsPanel.setBounds(650,50, 800,400);
        pointsPanel.setSize(200,30);
        pointsPanel.setVisible(true);
        pointsPanel.setBackground(Color.WHITE);
        con.add(pointsPanel);


        cardPanel = new JPanel();
        cardPanel.setBounds(150, 300, 1200, 520);
        cardPanel.setLayout(new GridLayout(3, 4, 200, 100)); // 3 rows, 4 columns
        cardPanel.setBackground(Color.GRAY);


        // Generate and add 12 cards to the panel
        ArrayList<Card> cards = generateCards(deck);
        for (Card card : cards) {
            JPanel cardRect = new JPanel();
            addMouseListenerToCardWithConfetti(cardRect, selectedCards, card);
            cardRect.setPreferredSize(new Dimension(300, 200)); // Set size of each rectangle (Doesn't work and idk why)
            cardRect.setBackground(Color.DARK_GRAY);


            ImageIcon cardImage = new ImageIcon(card.imagePath());
            JLabel cardLabel = new JLabel(cardImage);
            cardLabel.setBounds(0, 0, 500, 200);

            cardRect.add(cardLabel);
            cardPanel.add(cardRect);
        }


        con.add(cardPanel);



        JTextArea textArea = new JTextArea(" POINTS: " + points);
        textArea.setBounds(0,200,800,400);
        textArea.setLayout(null);
        textArea.setSize(1000,2000);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setVisible(true);
        //textArea.setLineWrap(true);
        pointsPanel.add(textArea);



    }

    public static void createMediumGame() {
        isMedium = true;
        isEasy = false;
        isHard = false;
        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);
        rulesButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
        easyButtonPanel.setVisible(false);
        mediumButtonPanel.setVisible(false);
        hardButtonPanel.setVisible(false);
        difNamePanel.setVisible(false);
        backButtonPanel.setVisible(false);
        checkSetButtonPanel.setVisible(true);
        mmButtonPanel.setVisible(true);

        window.getContentPane().setBackground(Color.GRAY);

        pointsPanel = new JPanel();
        pointsPanel.setBounds(650,50, 800,400);
        pointsPanel.setSize(200,30);
        pointsPanel.setVisible(true);
        pointsPanel.setBackground(Color.WHITE);
        con.add(pointsPanel);


        cardPanel = new JPanel();
        cardPanel.setBounds(150, 300, 1200, 520);
        cardPanel.setLayout(new GridLayout(3, 4, 200, 100)); // 3 rows, 4 columns
        cardPanel.setBackground(Color.GRAY);

        //ImageIcon cardImage = new ImageIcon(Card.getImagePath());

        // Generate and add 12 cards to the panel
        ArrayList<Card> cards = generateCards(deck);
        for (Card card : cards) {
            JPanel cardRect = new JPanel();
            addMouseListenerToCardWithoutConfetti(cardRect, selectedCards, card);
            cardRect.setPreferredSize(new Dimension(300, 200)); // Set size of each rectangle (Doesn't work and idk why)
            cardRect.setBackground(Color.DARK_GRAY); // Set background color for the rectangle


            ImageIcon cardImage = new ImageIcon(card.imagePath());
            JLabel cardLabel = new JLabel(cardImage);
            cardLabel.setBounds(0, 0, 500, 200); // Set bounds for the image label

            cardRect.add(cardLabel); // Add image label to rectangle panel
            cardPanel.add(cardRect); // Add rectangle panel to cardPanel
        }


        con.add(cardPanel);


        pointsArea = new JTextArea(" POINTS: " + points);
        pointsArea.setBounds(0,200,800,400);
        pointsArea.setLayout(null);
        pointsArea.setSize(1000,2000);
        pointsArea.setBackground(Color.BLACK);
        pointsArea.setForeground(Color.WHITE);
        pointsArea.setVisible(true);
        //textArea.setLineWrap(true);
        pointsPanel.add(pointsArea);

    }

    public static void createHardGame() {
        isEasy = false;
        isMedium = false;
        isHard = true;

        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);
        rulesButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
        easyButtonPanel.setVisible(false);
        mediumButtonPanel.setVisible(false);
        hardButtonPanel.setVisible(false);
        difNamePanel.setVisible(false);
        backButtonPanel.setVisible(false);
        checkSetButtonPanel.setVisible(true);
        mmButtonPanel.setVisible(true);

        window.getContentPane().setBackground(Color.GRAY);

        pointsPanel = new JPanel();
        pointsPanel.setBounds(650,50, 800,400);
        pointsPanel.setSize(200,30);
        pointsPanel.setVisible(true);
        pointsPanel.setBackground(Color.WHITE);
        con.add(pointsPanel);


        cardPanel = new JPanel();
        cardPanel.setBounds(150, 300, 1200, 520);
        cardPanel.setLayout(new GridLayout(3, 4, 200, 100)); // 3 rows, 4 columns
        cardPanel.setBackground(Color.GRAY);

        //ImageIcon cardImage = new ImageIcon(Card.getImagePath());

        // Generate and add 12 cards to the panel
        ArrayList<Card> cards = generateCards(deck);
        for (Card card : cards) {
            JPanel cardRect = new JPanel();
            addMouseListenerToCardWithoutConfetti(cardRect, selectedCards, card);
            cardRect.setPreferredSize(new Dimension(300, 200)); // Set size of each rectangle (Doesn't work and idk why)
            cardRect.setBackground(Color.DARK_GRAY); // Set background color for the rectangle


            ImageIcon cardImage = new ImageIcon(card.imagePath());
            JLabel cardLabel = new JLabel(cardImage);
            cardLabel.setBounds(0, 0, 500, 200); // Set bounds for the image label

            cardRect.add(cardLabel); // Add image label to rectangle panel
            cardPanel.add(cardRect); // Add rectangle panel to cardPanel

        }


        con.add(cardPanel);


        JTextArea textArea = new JTextArea(" POINTS: " + points);
        textArea.setBounds(0,200,800,400);
        textArea.setLayout(null);
        textArea.setSize(1000,2000);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setVisible(true);
        //textArea.setLineWrap(true);
        pointsPanel.add(textArea);

    }

    public static void createRulesPage() {
        // Hide unnecessary panels
        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);
        rulesButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
        backButtonPanel.setVisible(true);

        // Set the background color of the content pane
        window.getContentPane().setBackground(Color.BLACK);

        // Create a main panel for the rules content
        rulesPanel = new JPanel();
        rulesPanel.setLayout(null);
        rulesPanel.setBounds(100, 50, 1500, 800);
        rulesPanel.setBackground(Color.WHITE);
        window.add(rulesPanel);

        // Create a scroll pane for the rules text
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 50, 1300, 900);
        rulesPanel.add(scrollPane);

        // Create a JTextArea for the rules text
        JTextArea rulesTextArea = new JTextArea();
        rulesTextArea.setText(" In the game, certain combinations of three cards are said to make up a \"set\". " +
                " For each one of the four categories of features: Color, number, shape, and shading. The three cards " +
                " must display that feature as either a) all the same, or b) all different. Put another way: For each " +
                " feature the three cards must avoid having two cards showing one version of the feature and the remaining " +
                " card showing a different version.\n\n" +
                " For example, 3 solid red diamonds, 2 solid green squiggles, and 1 solid purple oval form a set, because " +
                " the shadings of the three cards are all the same, while the numbers, the colors, and the shapes among " +
                " the three cards are all different.\n\n" +
                " For any set, the number of features that are constant (the same on all three cards) and the number of " +
                " features that differ (different on all three cards) may break down as: all 4 features differing; or 1 " +
                " feature being constant and 3 differing; or 2 constant and 2 differing; or 3 constant and 1 differing. " +
                " (All 4 features being constant would imply that the three cards in the set are identical, which is " +
                " impossible since no cards in the Set deck are identical.)\n\n" +
                " There are three difficulties. Easy, Medium, and Hard.\n\n" +
                " Easy: Automatic set detection, therefore no incorrect set penalty.\n" +
                " +25 Points per each correct set.\n\n" +
                " Medium: Manual set detection, but no penalty for incorrect sets.\n" +
                " +15 Points per each correct set.\n\n" +
                " Hard: Manual set detection, with penalty for each incorrect set.\n" +
                " +5 Points per each correct set.\n" +
                " -15 per each incorrect set");
        rulesTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        rulesTextArea.setWrapStyleWord(true);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setEditable(false);
        scrollPane.setViewportView(rulesTextArea);

        rulesPanel.setVisible(true);
    }

    public static void createGameOverScreen() {
        // Hide unnecessary panels
        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);
        rulesButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
        backButtonPanel.setVisible(false);
        cardPanel.setVisible(false);
        pointsPanel.setVisible(false);
        checkSetButtonPanel.setVisible(false);
        mmButtonPanel.setVisible(false);

        // Set the background color of the content pane
        window.getContentPane().setBackground(Color.BLACK);

        // Create a main panel for the game over screen content
        gameOverPanel = new JPanel();
        gameOverPanel.setLayout(null);
        gameOverPanel.setBounds(100, 66, 1400, 1000);
        gameOverPanel.setBackground(Color.RED);
        window.add(gameOverPanel);

        // Create a JLabel for the game over message
        JLabel gameOverLabel = new JLabel("Game Over!");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gameOverLabel.setForeground(Color.WHITE);
        gameOverLabel.setBounds(600, 150, 200, 50);
        gameOverPanel.add(gameOverLabel);

        // Create a JButton for returning to the main menu
        JButton returnButton = new JButton("Return to Main Menu");
        returnButton.setFocusPainted(false);
        returnButton.setFont(new Font("Arial", Font.PLAIN, 16));
        returnButton.setBounds(600, 400, 200, 50);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createMainMenu();
            }
        });
        gameOverPanel.add(returnButton);

        // Make the game over screen visible
        gameOverPanel.setVisible(true);

    }

    public static void createYouWonScreen() {
        // Hide unnecessary panels
        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);
        rulesButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
        backButtonPanel.setVisible(false);
        cardPanel.setVisible(false);
        pointsPanel.setVisible(false);
        checkSetButtonPanel.setVisible(false);
        mmButtonPanel.setVisible(false);

        // Set the background color of the content pane
        window.getContentPane().setBackground(Color.WHITE);

        // Create a main panel for the game over screen content
        youWonPanel = new JPanel();
        youWonPanel.setLayout(null);
        youWonPanel.setBounds(100, 66, 1400, 1000);
        youWonPanel.setBackground(Color.GREEN);
        window.add(youWonPanel);

        // Create a JLabel for the game over message
        JLabel youWonLabel = new JLabel("You Won!");
        youWonLabel.setFont(new Font("Arial", Font.BOLD, 30));
        youWonLabel.setForeground(Color.WHITE);
        youWonLabel.setBounds(625, 150, 200, 50);
        youWonPanel.add(youWonLabel);

        // Create a JButton for returning to the main menu
        JButton returnButton = new JButton("Return to Main Menu");
        returnButton.setFocusPainted(false);
        returnButton.setFont(new Font("Arial", Font.PLAIN, 16));
        returnButton.setBounds(600, 400, 200, 50);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createMainMenu();
            }
        });
        youWonPanel.add(returnButton);

        // Make the game over screen visible
        youWonPanel.setVisible(true);

    }


    public static void exitGame() {
        window.setVisible(false);
        System.exit(0);

    }

    public static class StartHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            createDifMenu();
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
    public static class BackHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            hideDifMenu();
        }
    }

    public static class EasyHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            createEasyGame();
        }
    }
    public static class MediumHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            createMediumGame();
        }
    }
    public static class HardHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            createHardGame();
        }
    }
    public static class CheckSetHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            correctSetConfetti();
        }
    }
    public static class MMHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            createMainMenu();
        }
    }


    public static void addMouseListenerToCardWithoutConfetti(JPanel cardRect, ArrayList<Card> selectedCards, Card card) {
        cardRect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                    if (cardRect.getBackground() == Color.DARK_GRAY) {
                        cardRect.setBackground(Color.YELLOW); // Change to yellow on click
                        selectedCards.add(card); // Add the clicked card to the selected cards list
                    } else if (cardRect.getBackground() == Color.YELLOW) {
                        cardRect.setBackground(Color.DARK_GRAY); // Change back to gray if already yellow
                        selectedCards.remove(card); // Remove the un-clicked card from the selected cards list
                    }


            }
        });
    }

    public static void addMouseListenerToCardWithConfetti(JPanel cardRect, ArrayList<Card> selectedCards, Card card) {
        cardRect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (cardRect.getBackground() == Color.DARK_GRAY) {
                    cardRect.setBackground(Color.YELLOW); // Change to yellow on click
                    selectedCards.add(card); // Add the clicked card to the selected cards list
                } else if (cardRect.getBackground() == Color.YELLOW) {
                    cardRect.setBackground(Color.DARK_GRAY); // Change back to gray if already yellow
                    selectedCards.remove(card); // Remove the un-clicked card from the selected cards list
                }
                // Check for a set when three cards are selected
                if(selectedCards.size() <= 3) {
                    if (selectedCards.size() == 3) {
                        if (Board.confirmSet(selectedCards.get(0), selectedCards.get(1), selectedCards.get(2))) {
                            System.out.println("SET!");
                            if(isEasy) points += 25;
                            else if(isMedium) points += 15;
                            else if(isHard) points += 5;
                            if (points >= 200) createYouWonScreen();

                            for (Component panel : cardPanel.getComponents()) {
                                if (panel.getBackground() == Color.YELLOW) {
                                    panel.setBackground(Color.GREEN); // Highlight selected set in green
                                }
                            }
                        } else System.out.println("Not Set.");
                        selectedCards.clear(); // Clear the selected cards list after checking for a set
                    }
                }


            }
        });
    }





    public static void correctSetConfetti(){

        // Check for a set when three cards are selected
        if(selectedCards.size() <= 3) {
            if (selectedCards.size() == 3) {
                if (Board.confirmSet(selectedCards.get(0), selectedCards.get(1), selectedCards.get(2))) {
                    System.out.println("SET!");

                    if(isEasy) points += 25;
                    else if(isMedium) points += 15;
                    else if(isHard) points += 5;
                    if (points >= 200) createYouWonScreen();
                    JTextArea textArea = new JTextArea(" POINTS: " + points);
                    for (Component panel : cardPanel.getComponents()) {
                        if (panel.getBackground() == Color.YELLOW) {
                            panel.setBackground(Color.GREEN); // Highlight selected set in green
                        }
                    }
                } else {
                    if (isHard) {
                        points -= 15;
                        if (points <= 0) createGameOverScreen();
                    }
                    System.out.println(points);
                    System.out.println("Not Set.");
                }
                selectedCards.clear(); // Clear the selected cards list after checking for a set
            }
        }
    }


    public static ArrayList<Card> generateCards(ArrayList<Card> deck) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            cards.add(deck.remove(0));
        }
        return cards;
    }




    //////////////////////////////////////////  EASTER EGG  //////////////////////////////////////////

    private static boolean konamiCodeEntered = false;
    private static Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE};
    private static int colorIndex = 0;
    private static Timer colorTimer;


    private static final int[] konamiCode = {
            KeyEvent.VK_UP, KeyEvent.VK_UP,
            KeyEvent.VK_DOWN, KeyEvent.VK_DOWN,
            KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT,
            KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT,

    };
    private static int konamiIndex = 0;


    private static KeyListener konamiKeyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == konamiCode[konamiIndex]) {
                konamiIndex++;
                if (konamiIndex == konamiCode.length) {
                    konamiCodeEntered = true;
                    startColorTimer();
                }
            } else {
                konamiIndex = 0;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };


    private static void startColorTimer() {
        colorTimer = new Timer();
        colorTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (konamiCodeEntered) {
                    if (colorIndex < colors.length - 1) {
                        colorIndex++;
                    } else {
                        colorIndex = 0;
                    }
                    window.getContentPane().setBackground(colors[colorIndex]);
                } else {
                    colorTimer.cancel();
                    colorTimer.purge();
                }
            }
        }, 0, 250);
    }

    private static void addKonamiKeyListener() {
        titleNamePanel.addKeyListener(konamiKeyListener);
        titleNamePanel.setFocusable(true);
        titleNamePanel.requestFocusInWindow();
    }

    ////////////////////////////////////////// End Of Easter Egg //////////////////////////////////////////






    public static void main(String[] args) {
        Game game = new Game();
        addKonamiKeyListener();
        }
    }






