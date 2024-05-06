/**
 * a class that represents the individual cards
 * @author Alban
 */
public class Card{

    private char rank;
    private int bValue;
    private char suit;
    private String rankString;
    private String suitString;
    
    /**
     * contructor for the Card class
     * @param rank the value of the card eg. 1, 7, king
     * @param suit the suit the card comes from eg. spades, hearts
     */
    public Card(char rank, char suit){
        this.rank = rank;
        this.suit = suit;
        if (suit == 's') suitString = "spades";
        else if (suit == 'c') suitString = "clubs";
        else if (suit == 'h') suitString = "hearts";
        else suitString = "diamonds";
        if (rank == 'a') rankString = "ace";
        else if (rank == 't') rankString = "ten";
        else if (rank == 'j') rankString = "jack";
        else if (rank == 'q') rankString = "queen";
        else if (rank == 'k') rankString = "king";
        else rankString = Character.toString(rank);
        
        if (rank == 'a') bValue = 11;// make sure it can be one!!!
        else if (rank == 't' || rank == 'j' || rank == 'q' || rank == 'k') bValue = 10;
        else bValue = Character.getNumericValue(rank);
    }

    /**
     * Accessor method for the rank datafield
     * @return the rank of the card
     */
    public char getRank(){
        return rank;
    }

    /**
     * Accessor method for the rankString datafield
     * @return the rank of the card as a string
     */
    public String getRankString(){
        return rankString;
    }

    /**
     * Accessor method for the suit datafield
     * @return the suit of the card
     */
    public char getSuit(){
        return suit;
    }

    /**
     * Accessor method for the suitString datafield
     * @return the suit of the card as a string
     */
    public String getSuitString(){
        return suitString;
    }

    /**
     * Accessor method for the bValue datafield
     * @return the value of the card
     */
    public int getValue(){
        return bValue;
    }

    /**
     * method to return the colour of a car by looking at what suit it has
     * @return the colour of the card
     */
    public String getColour(){
        if(suit == 's' ||suit == 'c') return "black";
        else return "red";
    }

    /**
     * toString method for the Card class
     * @return a visual representation of the card
     */
    public String toString(){
        return rank + "" + suit;
    }
}