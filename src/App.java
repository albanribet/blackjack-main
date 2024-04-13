/**
 * main application for the project
 * @author Alban
 */
public class App {
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        Deck d = new Deck();
        System.out.println(d.getCards()[10].getRank() + " " + d.getCards()[10].getSuit());
        System.out.println(d.getCards()[10].getValue());
        System.out.println(d);
    }
}
