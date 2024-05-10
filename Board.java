//	•	Deals 12 cards for gameplay
//	•	If no set is present, add 3 additional cards into the game
//	•	Detect when there are no cards left
// removes the used cards from the deck
//potentially interacts with a board object

import java.util.*;

public class Board {

    private Card[][] activeCards;
    private ArrayList<Card> deck;

    //not final because more cards may need to be added as columns
    private int boardWidth = 4;
    private final int BOARD_HEIGHT = 3;

    private final int CARDS_IN_A_SET = 3;

    public ArrayList<Card> twoDArrayToList(Card[][] twoDArray) {
        ArrayList<Card> arrList = new ArrayList<>();
        for (Card[] array : twoDArray) {
            arrList.addAll(Arrays.asList(array));
        }
        return arrList;
    }


    //getters return deep copies
    public ArrayList<Card> getDeck() {
        ArrayList<Card> copy = new ArrayList<>(deck);
        return copy;
    }

    public Card[][] getActiveCards() {
        Card[][] copy = new Card[boardWidth][BOARD_HEIGHT];
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                copy[i][j] = activeCards[i][j];
            }
        }
        return copy;
    }

    public void setActiveCards(Card[][] activeCards) {
        this.activeCards = activeCards;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public void addColumn() {
        if (!isSetPresent(this.activeCards)) {
            this.boardWidth += 1;
        }
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            activeCards[boardWidth][i] = deck.removeFirst();
        }
    }


    public boolean isSetPresent(Card[][] activeCards) {
        // Get a single array representation of the active cards on the board
        Card[] cards = cardSingleArray(activeCards);

        // Iterate over all combinations of three cards
        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    // Check if the current combination forms a valid set
                    if (confirmSet(new Card[]{cards[i], cards[j], cards[k]})) {
                        return true; // Found a valid set
                    }
                }
            }
        }
        return false; // No valid set found
    }

    //changes a 2D board array into a regular array
    public Card[] cardSingleArray(Card[][] twoDimArr) {
        Card[] cards = new Card[boardWidth * BOARD_HEIGHT];
        int index = 0;
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                cards[index] = twoDimArr[i][j];
                index++;
            }
        }
        return cards;
    }

    public Board() {
        this.deck = Card.makeDeck();
        this.activeCards = initializeBoard(deck);
    }

    private Card[][] initializeBoard(ArrayList<Card> theDeckOfCards) {
        Card[][] board = new Card[boardWidth][BOARD_HEIGHT];
        Collections.shuffle(theDeckOfCards);
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                board[i][j] = theDeckOfCards.remove(0);
            }
        }
        return board;
    }

    //must be all different, or 3 different and one same, Or 3 same and 1 different, or two same two different.
    public boolean confirmSet(Card[] potentialSet) {
        Set<Card.ColorEnum> colors = new HashSet<>();
        Set<Card.NumberEnum> numbers = new HashSet<>();
        Set<Card.ShapeEnum> shapes = new HashSet<>();
        Set<Card.ShadingEnum> shadings = new HashSet<>();

        for (Card card : potentialSet) {
            colors.add(card.color);
            numbers.add(card.number);
            shapes.add(card.shape);
            shadings.add(card.shading);
        }



        // Check if all attributes are different
        boolean allDifferent = colors.size() == 3 && numbers.size() == 3 &&
                shapes.size() == 3 && shadings.size() == 3;

        // Check if there are three different attributes and one same
        boolean threeDifferentOneSame = (colors.size() == 3 && numbers.size() == 3 &&
                shapes.size() == 3 && shadings.size() == 1) ||
                (colors.size() == 3 && numbers.size() == 3 &&
                        shapes.size() == 1 && shadings.size() == 3) ||
                (colors.size() == 3 && numbers.size() == 1 &&
                        shapes.size() == 3 && shadings.size() == 3) ||
                (colors.size() == 1 && numbers.size() == 3 &&
                        shapes.size() == 3 && shadings.size() == 3);

        // Check if there are three same attributes and one different
        boolean threeSameOneDifferent = (colors.size() == 1 && numbers.size() == 1 &&
                shapes.size() == 1 && shadings.size() == 3) ||
                (colors.size() == 1 && numbers.size() == 1 &&
                        shapes.size() == 3 && shadings.size() == 1) ||
                (colors.size() == 1 && numbers.size() == 3 &&
                        shapes.size() == 1 && shadings.size() == 1) ||
                (colors.size() == 3 && numbers.size() == 1 &&
                        shapes.size() == 1 && shadings.size() == 1);

        boolean twoSameTwoDifferent = (colors.size() == 3 && numbers.size() == 3 &&
                shapes.size() == 1 && shadings.size() == 1) ||
                (colors.size() == 3 && numbers.size() == 1 &&
                        shapes.size() == 3 && shadings.size() == 1) ||
                (colors.size() == 3 && numbers.size() == 1 &&
                        shapes.size() == 1 && shadings.size() == 3) ||
                (colors.size() == 1 && numbers.size() == 3 &&
                        shapes.size() == 3 && shadings.size() == 1) ||
                (colors.size() == 1 && numbers.size() == 3 &&
                        shapes.size() == 1 && shadings.size() == 3) ||
                (colors.size() == 1 && numbers.size() == 1 &&
                        shapes.size() == 3 && shadings.size() == 3);

        return allDifferent || threeDifferentOneSame || threeSameOneDifferent || twoSameTwoDifferent;
    }


    //choose three cards from the game as a possible set.
    public boolean pickSet(Card[] selectedCards) {
        return confirmSet(selectedCards);
    }

    //when a set is made, those cards should be removed and replaced.
    //if the board has greater than 12 cards, do nothing.

    public void replaceUsedCards(Card[] CardsFromSet) {
        if (boardWidth * BOARD_HEIGHT == 12) {
            Card[][] activeCards = getActiveCards();
            //flatten the 2D board array into a regular array of cards, and produce an arraylist
            ArrayList<Card> activeCardsArrayList = new ArrayList<Card>(Arrays.asList(cardSingleArray(activeCards)));
            for (Card card : CardsFromSet) {
                activeCardsArrayList.remove(card);
            }
            //add three new cards to replace
            activeCardsArrayList.addAll(Arrays.asList(addNewCards(deck)));
            Card[][] newActiveCards = new Card[boardWidth][BOARD_HEIGHT];
            for (int i = 0; i < boardWidth; i++) {
                for (int j = 0; j < BOARD_HEIGHT; j++) {
                    newActiveCards[i][j] = activeCardsArrayList.removeFirst();
                }
            }
            setActiveCards(newActiveCards);
        }

    }

    public Card[] addNewCards(ArrayList deck) {
        Card[] newCards = new Card[3];
        for (int i = 0; i < 3; i++) {
            newCards[i] = (Card) deck.removeFirst();
        }
        return newCards;
    }

    public void printBoard(Card[][] activeCards) {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                System.out.println(activeCards[i][j].toString());
            }
        }
    }
    public ArrayList<Card> getTwelveCardsFromDeck(ArrayList<Card> deck){
        ArrayList<Card> twelveNewCards = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            twelveNewCards.add(this.deck.removeFirst());
        }

        return  twelveNewCards;
    }
}