import java.util.ArrayList;
import java.util.Arrays;

public class DesignDraft {

    //prints the active board
    public static void main(String[] args) {

        Board b = new Board();
        b.printBoard(b.getActiveCards());
        System.out.println(b.isSetPresent(b.getActiveCards()));

//        Card one = new Card(
//                Card.ColorEnum.RED,
//                Card.NumberEnum.ONE ,
//                Card.ShapeEnum.OVAL ,
//                Card.ShadingEnum.BLANK);
//
//        Card two = new Card(
//                Card.ColorEnum.GREEN,
//                Card.NumberEnum.TWO ,
//                Card.ShapeEnum.DIAMOND ,
//                Card.ShadingEnum.SOLID);
//
//        Card three = new Card(
//                Card.ColorEnum.PURPLE,
//                Card.NumberEnum.THREE ,
//                Card.ShapeEnum.SQUIGGLE ,
//                Card.ShadingEnum.STRIPED);
//
//        Card[] c = new Card[]{ two,three,one };
//
//        System.out.println(b.confirmSet(c));

//        ArrayList aNewDeckOfCards = Card.makeDeck();
//        for ( Object card : aNewDeckOfCards)
//        {
//            System.out.println(card.toString());
//        }
    }


}
