//	•	Deals 12 cards for gameplay
//	•	If no set is present, add 3 additional cards into the game
//	•	Detect when there are no cards left
// removes the used cards from the deck
//potentially interacts with a board object

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    private Card[][] activeCards;
    private ArrayList<Card> deck;

    //not final because more cards may need to be added as columns
    private int boardWidth = 4;
    private final int BOARD_HEIGHT = 3;


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

//write a method to check if there's a set on the board or not

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


    //must be all the same or all different.
    public boolean confirmSet(Card card1, Card card2, Card card3) {
        if (
                (!card1.color.equals(card2.color) && !card1.color.equals(card3.color) && !card2.color.equals(card3.color))
                        && ((!card1.number.equals(card2.number) && !card1.number.equals(card3.number) && !card2.number.equals(card3.number))
                        && ((!card1.shape.equals(card2.shape) && !card1.shape.equals(card3.shape) && !card2.shape.equals(card3.shape))
                        && ((!card1.shading.equals(card2.shading) && !card1.shading.equals(card3.shading) && !card2.shading.equals(card3.shading)))))
        ) {
            return true;
        } else if ((card1.color.equals(card2.color) && card1.color.equals(card3.color))
                && ((card1.number.equals(card2.number) && card1.number.equals(card3.number))
                && ((card1.shape.equals(card2.shape) && card1.shape.equals(card3.shape))
                && ((card1.shading.equals(card2.shading) && card1.shading.equals(card3.shading)))))) {
            return true;

        } else
            return false;
    }

    //choose three cards from the game as a possible set.
    public Card[] pickSet() {
        Card[] possibleSet = new Card[3];
        return possibleSet;
    }

    public void printBoard(Card[][] activeCards) {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                System.out.println(activeCards[i][j].toString());
            }
        }
    }

}

