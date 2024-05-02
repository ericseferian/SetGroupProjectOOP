//	•	Deals 12 cards for gameplay
//	•	If no set is present, add 3 additional cards into the game
//	•	Detect when there are no cards left
// removes the used cards from the deck
//potentially interacts with a board object

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Board {

    private Card[][] activeCards;
    private ArrayList<Card> deck;

    //not final because more cards may need to be added as columns
    private int boardWidth = 4;
    private final int BOARD_HEIGHT = 3;

    private final int CARDS_IN_A_SET = 3;


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
    //compare all 3 card combinations
    //if one is a set, continue the game
    //TODO:
    //else, add a column of 3 cards


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


    //must be all the same or all different.
    public boolean confirmSet(Card[] potentialSet) {
        Card card1 = potentialSet[0];
        Card card2 = potentialSet[1];
        Card card3 = potentialSet[2];
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
        for (int i = 0; i < 2; i++) {
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
}

