/**
 * class that represents a deck of cards
 * @author Alban
 */
public class Deck {
    private Card[] cards;
    private static int numCards;

    /**
     * pblic constructor for Deck
     */
    public Deck(){
        this.numCards = 52;
        cards = new Card[numCards];
        char[] ranks = new char[]{'a', '2', '3', '4', '5', '6', '7',
                                        '8', '9', 't', 'j', 'q', 'k'};
        int suits = 0;
        for(int i = 0; i < numCards; i+=4){
            cards[i] = new Card(ranks[suits], 's');
            cards[i+1] = new Card(ranks[suits], 'c');
            cards[i+2] = new Card(ranks[suits], 'h');
            cards[i+3] = new Card(ranks[suits++], 'd');
        }
    }

    /**
     * accessor method for the cards array
     * @return the cards array
     */
    public Card[] getCards(){
        return cards;
    }

    /**
     * accessor method for the numCards datafield
     * @return the number of cards in the deck
     */
    public static int getNumCards(){
        return numCards;
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
}
