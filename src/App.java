import java.util.Scanner;
import java.util.Arrays;

/**
 * main application for the project
 * @author Alban
 */
public class App {

    private static int balance;
    private static boolean playGame = true;


    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        balance = 1000;
        Scanner sc = new Scanner(System.in);
        System.out.println("*".repeat(50));
        System.out.println("Welcome to BlackJack");
        System.out.println("Please enter the number of decks you would like to play with: ");
        int numDecks;
        while (true){
            try {
                numDecks = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number of decks");
            }
        }
        BlackJack.getInstance(numDecks);//make a blackjack game
        //System.out.println(BlackJack.getShoe());
        //check if this can be put in blackjack game
        boolean autoBet = false;
        int bet = 10;
        //String auto = "";
        while (playGame){
            while (!autoBet) {
                System.out.println("Your balance is: $" + balance);
                System.out.println("Please enter your bet (min $10): "); // (type 'auto' after it to keep betting that amount)");
                while (true){
                    try {
                        bet = sc.nextInt();
                        //auto = sc.next();
                        //if (auto.equals("auto")) autoBet = true;
                        if (bet > balance) System.out.println("You cannot bet more than your balance");
                        else if (bet < 10) System.out.println("You must bet at least $10");
                        else break;
                    } catch (Exception e) {
                        System.out.println("Please enter a valid bet");
                    }
                }
                balance -= bet;
                System.out.println("Your balance is now: $" + balance);
                //game here!!
                BlackJack.playRound(bet);
            }
            
            //end game part
            System.out.println("Your balance is now: $" + balance);
            System.out.println("Would you like to play again? (y/n)"); //make this error proof later
            String playAgain = sc.next();
            if (playAgain.equals("n")) playGame = false;
        }
        System.out.println("You left the casino with $" + balance + ". Thank you for playing BlackJack");
    }

    public static int getBalance(){
        return balance;
    }

    public static void setBalance(int newBalance){
        balance = newBalance;
    }
}
