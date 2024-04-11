
public class DesignDraft {

    //currently just prints the deck of cards
    public static void main(String[] args) {

        Card[] deck = Card.makeDeck();

        for ( Card card : deck)
        {
            System.out.println(card.toString());

        }
    }


}
