/**
 * a class that represents the individual cards
 */
public class Card{

    private String value;
    private String suit;
    
    /**
     * contructor for the Card class
     * @param value the value of the card eg. 1, 7, king
     * @param suit the suit the card comes from eg. spades, hearts
     */
    public Card(String value, String suit){
        this.value = value;
        this.suit = suit;
    }

    /**
     * Accessor method for the value datafield
     * @return the value of the card
     */
    public String getValue(){
        return value;
    }

    /**
     * Accessor method for the suit datafield
     * @return the suit of the card
     */
    public String getSuit(){
        return suit;
    }

    /**
     * method to return the colour of a car by looking at what suit it has
     * @return the colour of the card
     */
    public String getColour(){
        if(suit.equals("spade") ||suit.equals("club")) return "black";
        else return "red";
    }
}