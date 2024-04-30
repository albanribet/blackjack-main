import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("*".repeat(50));
        System.out.println("Welcome to BlackJack");
        System.out.println("Please enter the number of decks you would like to play with");
        int numDecks;
        while (true){
            try {
                numDecks = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number of decks");
            }
        }
        BlackJack bj = BlackJack.getInstance(numDecks);
        // Deck d = new Deck();
        // System.out.println(d.getCards()[10].getRank() + " " + d.getCards()[10].getSuit());
        // System.out.println(d.getCards()[10].getValue());
        // System.out.println(d);
    }
}
