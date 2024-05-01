import java.util.ArrayList;

public class Card {
//Color, number, shape, and shading each have three possibilities.

    //make an array of 81 total cards that reflect these possibilities.

    //There are 27  cards that are red, blue, and green.
    //The same is true for each type of number, shape, and shading

    public enum ColorEnum {RED, PURPLE, GREEN}

    public enum NumberEnum {ONE, TWO, THREE}

    public enum ShapeEnum {DIAMOND, OVAL, SQUIGGLE}

    public enum ShadingEnum {BLANK, SOLID, STRIPED}

    public ColorEnum color;
    public NumberEnum number;
    public ShapeEnum shape;
    public ShadingEnum shading;

    private static final int TOTAL_CARDS = 81;
    
    
    ///////////////////////////
    
    public static final String imageLocation = "C:\\Location\\Of\\The\\Images\\"; //FILL THIS. This is the location of the images of the cards.
    //For example, if you put the images I provided into a folder called "Cards" on your Desktop, your Path should look like this: "C:\\Users\\YourUsername\\Desktop\\Cards\\"

    ///////////////////////////
    
    
    /*

    public Card(ColorEnum cardColor,
                NumberEnum cardNumber,
                ShapeEnum cardShape,
                ShadingEnum cardShading){

        this.color = cardColor;
        this.number = cardNumber;
        this.shape = cardShape;
        this.shading = cardShading;

    }

     */

    private String imagePath;

    public Card(ColorEnum cardColor,
                NumberEnum cardNumber,
                ShapeEnum cardShape,
                ShadingEnum cardShading){
        this.color = cardColor;
        this.number = cardNumber;
        this.shape = cardShape;
        this.shading = cardShading;
    }

    public static ArrayList<Card> makeDeck() {
//        Card[] deckOfCards = new Card[81];
        ArrayList<Card> deckOfCards = new ArrayList<Card>(TOTAL_CARDS);

        int index = 0;

        // Iterate through all possible combinations of attributes
        for (ColorEnum color : ColorEnum.values()) {
            for (NumberEnum number : NumberEnum.values()) {
                for (ShapeEnum shape : ShapeEnum.values()) {
                    for (ShadingEnum shading : ShadingEnum.values()) {
                        // Create a new card with the current combination of attributes
                        deckOfCards.add(index, new Card(color, number, shape, shading));
                        index++;
                    }
                }
            }
        }
        return deckOfCards;
    }


    public String imagePath(){
        String colorString;
        String numberString;
        String shapeString;
        String shadingString;
        switch (color) {
            case RED:
                colorString = "red";
                break;
            case PURPLE:
                colorString = "purple";
                break;
            case GREEN:
                colorString = "green";
                break;
            default:
                colorString = "U"; // Unknown color
        }
        switch (number) {
            case ONE:
                numberString = "one";
                break;
            case TWO:
                numberString = "two";
                break;
            case THREE:
                numberString = "three";
                break;
            default:
                numberString = "?"; // Unknown number
        }
        switch (shading) {
            case BLANK:
                shadingString = "blank";
                break;
            case STRIPED:
                shadingString = "striped";
                break;
            case SOLID:
                shadingString = "solid";
                break;
            default:
                shadingString = "?"; // Unknown number
        }
        switch (shape) {
            case OVAL:
                shapeString = "oval";
                break;
            case SQUIGGLE:
                shapeString = "squiggle";
                break;
            case DIAMOND:
                shapeString = "diamond";
                break;
            default:
                shapeString = "?"; // Unknown number
        }

        return imageLocation + colorString + "-" + numberString + "-" + shapeString + "-" + shadingString + ".png";

    }

    public String toString() {
        String colorString;
        switch (color) {
            case RED:
                colorString = "R";
                break;
            case PURPLE:
                colorString = "P";
                break;
            case GREEN:
                colorString = "G";
                break;
            default:
                colorString = "U"; // Unknown color
        }

        String numberString;
        switch (number) {
            case ONE:
                numberString = "1";
                break;
            case TWO:
                numberString = "2";
                break;
            case THREE:
                numberString = "3";
                break;
            default:
                numberString = "?"; // Unknown number
        }

        return
                "Color: " + colorString.repeat(color.ordinal() + 1) + "\n" +
                "Shape: " + shape + "\n" +
                "Shading: " + shading + "\n";
    }

}

