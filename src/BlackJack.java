public class BlackJack{

    /**
     * static singleton of the BlackJack class
     */
    private static BlackJack blackjackObj;
    private static Shoe shoe;
    
    /**
     * private constructor for the BlackJack class
     * @param numDecks the number of decks to be used in the game
     */
    private BlackJack(int numDecks) {
        shoe = Shoe.getInstance(numDecks);
    }

    /**
     * method to get the singleton of the BlackJack class
     * @param numDecks
     * @return
     */
    public static BlackJack getInstance(int numDecks) {
        if (blackjackObj == null) blackjackObj = new BlackJack(numDecks);
        return blackjackObj;
    }	

    /**
     * accessor method for the shoe datafield
     * @return the shoe object
     */
    public static Shoe getShoe(){
        return shoe;
    }
}
