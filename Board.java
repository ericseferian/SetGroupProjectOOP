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

public Board(){
    this.board = new Card[boardWidth][BOARD_HEIGHT];

}

public void initializeBoard(){


    }
public void printBoard(){



    }



}
