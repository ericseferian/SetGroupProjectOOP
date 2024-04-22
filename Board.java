//	•	Deals 12 cards for gameplay
//	•	If no set is present, add 3 additional cards into the game
//	•	Detect when there are no cards left
// removes the used cards from the deck
//potentially interacts with a board object

public class Board {

    private Card[][] board;

    //not final because more cards may need to be added as columns
    private int boardWidth;

    private final int BOARD_HEIGHT = 3;

    public Board() {
        this.board = new Card[boardWidth][BOARD_HEIGHT];

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
        } else if ((card1.color.equals(card2.color) && card1.color.equals(card3.color) )
                && ((card1.number.equals(card2.number) && card1.number.equals(card3.number) )
                && ((card1.shape.equals(card2.shape) && card1.shape.equals(card3.shape) )
                && ((card1.shading.equals(card2.shading) && card1.shading.equals(card3.shading)))))) {
            return true;

        } else
    return false;
    }


    //choose three cards from the game as a possible set.
    public Card[] pickSet(){
Card[] possibleSet = new Card[3];

return possibleSet;
    }

    public void initializeBoard() {


    }

    public void printBoard() {


    }


}
