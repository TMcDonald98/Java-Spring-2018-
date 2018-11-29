/**
 * This program prompts the user for 2 strings and tells them if they are anagrams
 * CPSC 224-01, Spring 2018
 * Programming Assignment #5
 * @author Thomas McDonald
 * @version v1.0 3/9/2018
 */
import java.util.*;
public class Yahtzee {
    protected static final int DICE_IN_PLAY = 5;
    public static void main(String[] args) {
        Hand hand = new Hand(DICE_IN_PLAY);
        char playAgain = 'y';
        Scanner scan = new Scanner(System.in);
        while (playAgain == 'y') {
            String keep = "nnnnn"; //setup to roll all dice in the first roll
            int turn = 1;
            while (turn < 4 && !keep.equals("yyyyy")) {
                //roll dice not kept
                for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++) {
                    if (keep.charAt(dieNumber) != 'y')
                        hand.reroll(dieNumber);
                }
                //output roll
                System.out.print("Your roll was: ");
                hand.display();
                //if not the last roll of the hand prompt the user for dice to keep
                if (turn < 3) {
                    System.out.print("enter dice to keep (y or n) ");
                    keep = scan.next();
                }
                turn++;
            }
            //start scoring
            //hand need to be sorted to check for straights
            hand.sort();
            System.out.print("Here is your sorted hand : ");
            hand.display();
            Score score = new Score(hand);
            //upper scorecard
            score.upperSection();
            //lower scorecard
            score.lowerSection();
            System.out.print("\nEnter 'y' to play again ");
            playAgain = scan.next().charAt(0);
        }
        scan.close();
    }
}
