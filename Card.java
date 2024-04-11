import java.awt.*;

public class Card {
//Color, number, shape, and shading each have three possibilities.

    //make an array of 81 total cards that reflect these possibilities.

    //There are 27  cards that are red, blue, and green.
    //The same is true for each type of number, shape, and shading

    public enum ColorEnum {RED, BLUE, GREEN}

    public enum NumberEnum {ONE, TWO, THREE}

    public enum ShapeEnum {DIAMOND, OVAL, SQUIGGLE}

    public enum ShadingEnum {BLANK, SOLID, STRIPED}

    public ColorEnum color;
    public NumberEnum number;
    public ShapeEnum shape;
    public ShadingEnum shading;

    private static final int TOTAL_CARDS = 81;

public Card(ColorEnum cardColor,
            NumberEnum cardNumber,
            ShapeEnum cardShape,
            ShadingEnum cardShading){

    this.color = cardColor;
    this.number = cardNumber;
    this.shape = cardShape;
    this.shading = cardShading;

}
//fill the deckOfCards array with objects of type card.
    //

    public static Card[] makeDeck() {
        Card[] deckOfCards = new Card[81];
        int index = 0;

        // Iterate through all possible combinations of attributes
        for (ColorEnum color : ColorEnum.values()) {
            for (NumberEnum number : NumberEnum.values()) {
                for (ShapeEnum shape : ShapeEnum.values()) {
                    for (ShadingEnum shading : ShadingEnum.values()) {
                        // Create a new card with the current combination of attributes
                        deckOfCards[index] = new Card(color, number, shape, shading);
                        index++;
                    }
                }
            }
        }
        return deckOfCards;
    }

    @Override
    public String toString() {
        return "color: " + this.color + "\n" +
                "number: " + this.number + "\n" +
                "shape: " + this.shape + "\n" +
                "shading: " + this.shading + "\n";
    }
}


