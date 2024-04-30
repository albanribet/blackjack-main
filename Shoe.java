import java.util.Arrays;

public class Shoe{

    private static Shoe shoeObj;
    /**
     * public constructor for the Shoe class
     * @param numDecks
     */
    private Shoe(int numDecks){
        Deck[] shoe = new Deck[numDecks];
        for (int i = 0; i < numDecks; i++) {
            shoe[i] = new Deck();
            System.out.println(Arrays.toString(shoe));
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
