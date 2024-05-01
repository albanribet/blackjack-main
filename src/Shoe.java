import java.util.Arrays;

public class Shoe{

    private static Shoe shoeObj;
    /**
     * public constructor for the Shoe class
     * @param numDecks
     */
    private Shoe(int numDecks){
        Deck[] shoe = new Deck[numDecks*Deck.getNumCards()];
        // for (int i = 0; i < numDecks; i++) {
        //     Deck deck = new Deck();
        //     for (int j = 0; j < Deck.getNumCards(); j++)
        //     shoe[i*52 + j] = deck.getCards();
        //     System.out.println(Arrays.toString(shoe));
        // }
        for (int i = 0; i < numDecks; i++){
            Deck deck = new Deck();
            System.arraycopy(deck.getCards(), 0, shoe, i*52, Deck.getNumCards()); // fix!!
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
}
