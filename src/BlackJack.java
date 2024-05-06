import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack{

    /**
     * static singleton of the BlackJack class
     */
    private static BlackJack blackjackObj;
    private static Shoe shoe;
    private static ArrayList<Card> playerHand;
    private static ArrayList<Card> dealerHand;
    private static int bet;
    
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

    /**
     * method to draw a card from the shoe
     * @return the card drawn
     */
    public static Card drawCard(){
        //randomise the card drawn!!!
        Random rand = new Random();
        return Shoe.getCards()[rand.nextInt(Shoe.getCards().length)];
    }

    /**
     * accessor method for the player hand
     * @return the player's hand
     */
    public static ArrayList<Card> getPlayerHand(){
        return playerHand;
    }

    /**
     * accessor method for the dealer hand
     * @return Dealer's hand
     */
    public static ArrayList<Card> getDealerHand(){
        return dealerHand;
    }

    /**
     * method to play a round of blackjack
     */
    public static void playRound(int b){
        bet = b;
        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
        playerHand.add(drawCard());
        dealerHand.add(drawCard());
        playerHand.add(drawCard());
        dealerHand.add(drawCard());
        System.out.println("Your hand is: " + playerHand + " worth: " + calculateHand(playerHand));
        try { Thread.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("The dealer's visible card is the " + dealerHand.get(1).getRankString() + " of " + dealerHand.get(1).getSuitString() + " and a hidden card");
        if (calculateHand(playerHand) == 21) {
            System.out.println("You have a BlackJack!");
            App.setBalance((int)(App.getBalance() + bet*2.5));
        } else if (calculateHand(dealerHand) == 21){ 
            System.out.println("The dealer has a BlackJack D:");
        } else if (calculateHand(playerHand) > 21) {
            System.out.println("You have gone bust D:");
        } else if (calculateHand(playerHand) < 21) playerTurn();
    }


    /**
     * method to simulate the player's turn
     */
    @SuppressWarnings("resource")
    private static void playerTurn(){
        while(true){
            try { Thread.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Would you like to hit or stand? (h/s)");
            //make this error proof later
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            if (choice.equals("h")) hit(playerHand);
            else if (choice.equals("s")){
                dealerTurn();
                return;
            }
            if (calculateHand(playerHand) > 21) {
                System.out.println("You have gone bust D:");
                return;
            } else if (calculateHand(playerHand) == 21) {
                System.out.println("You have 21!");
                dealerTurn();
                return;
            }
        }
    }

    /**
     * method to simulate the dealer's turn
     */
    private static void dealerTurn(){
        System.out.println("The dealer's hand is: " + dealerHand + " worth: " + calculateHand(dealerHand));
        try { Thread.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
        while (calculateHand(dealerHand) < 17){
            hit(dealerHand);
            try { Thread.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        if (calculateHand(dealerHand) > 21) {
            App.setBalance(App.getBalance() + bet*2);
            System.out.println("The dealer has gone bust! You have won! Your balance is now: " + App.getBalance());
        }else if (calculateHand(dealerHand) > calculateHand(playerHand)) System.out.println("The dealer has won D:");
        else if (calculateHand(dealerHand) < calculateHand(playerHand)){
            App.setBalance(App.getBalance() + bet*2);
            System.out.println("You have won! Your balance is now: " + App.getBalance());
        }else {
            App.setBalance(App.getBalance() + bet);
            System.out.println("It's a draw! XD");
        }
        try { Thread.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    /**
     * method to calculate the total value of a hand
     * @param hand the hand to be calculated
     * @return the total value of the hand
     */
    private static int calculateHand(ArrayList<Card> hand){
        int total = 0;
        for (Card card : hand) {
            if (card.getRank() == 'a' && total + 11 > 21) total += 1;
            else total += card.getValue();
        }
        return total;
    }

    private static void hit(ArrayList<Card> hand){
        Card card = drawCard();
        hand.add(card);
        if(hand == playerHand) System.out.println("You drew a: " + card.getRankString() + ". Your hand is: " + hand + " worth: " + calculateHand(hand));
        else System.out.println("The dealer drew a: " + card.getRankString() + ". The dealer's hand is: " + hand + " worth: " + calculateHand(hand));
    }
}
