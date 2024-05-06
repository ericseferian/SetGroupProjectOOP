import java.util.ArrayList;
import java.util.Arrays;

public class DesignDraft {

    //prints the active board
    public static void main(String[] args) {

        Board b = new Board();
        b.printBoard(b.getActiveCards());
//        System.out.println(b.isSetPresent(b.getActiveCards()));

        Card one = new Card(
                Card.ColorEnum.RED,
                Card.NumberEnum.ONE ,
                Card.ShapeEnum.OVAL ,
                Card.ShadingEnum.BLANK);

        Card two = new Card(
                Card.ColorEnum.RED,
                Card.NumberEnum.ONE ,
                Card.ShapeEnum.DIAMOND ,
                Card.ShadingEnum.SOLID);

        Card three = new Card(
                Card.ColorEnum.RED,
                Card.NumberEnum.ONE ,
                Card.ShapeEnum.SQUIGGLE ,
                Card.ShadingEnum.STRIPED);

        Card[] c = new Card[]{ two,three,one };

        System.out.println(b.confirmSet(c));

    }


}
