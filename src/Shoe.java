import java.util.Arrays;

public class Shoe{

    private static Shoe shoeObj;
    private static Card[] cards; //Should I make this an ArrayList
    /**
     * public constructor for the Shoe class
     * @param numDecks
     */
    private Shoe(int numDecks){
        cards = new Card[numDecks*Deck.getInitNumCards()];
        // for (int i = 0; i < numDecks; i++) {
        //     for (int j = 0; j < Deck.getNumCards(); j++)
        //     Deck deck = new Deck();
        //     cards[i*52 + j] = deck.getCards();
        //     System.out.println(Arrays.toString(cards));
        // }
        for (int i = 0; i < numDecks; i++){
            Deck deck = new Deck();
            System.arraycopy(deck.getCards(), 0, cards, i*52, Deck.getInitNumCards()); // fix!!
        }
    }

    /**
     * method to get the singleton of the Shoe class
     * @param numDecks
     * @return
     */
    public static Shoe getInstance(int numDecks) {
        if (shoeObj == null) shoeObj = new Shoe(numDecks);
        return shoeObj;
    }

    /**
     * toString method for the Card class
     * @return a visual representation of the array
     */
    public String toString(){
        StringBuilder toString = new StringBuilder();
        toString.append("{");
        for (int i = 0; i < cards.length; i++) {
            toString.append(String.valueOf(cards[i].getRank()) + cards[i].getSuit() + ((i+1 < cards.length) ? ", " :  ""));
        }
        toString.append("}");
        return toString.toString();
    }

    /**
     * accessor method for the cards array
     * @return the cards array
     */
    public static Card[] getCards(){
        return cards;
    }
}
