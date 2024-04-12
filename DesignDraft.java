import java.util.ArrayList;

public class DesignDraft {

    //currently just prints the deck of cards
    public static void main(String[] args) {

        ArrayList aNewDeckOfCards = Card.makeDeck();

        for ( Object card : aNewDeckOfCards)
        {
            System.out.println(card.toString());

        }
    }


}
