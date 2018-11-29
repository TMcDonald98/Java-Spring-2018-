/**
 * This program prompts the user for 2 strings and tells them if they are anagrams
 * CPSC 224-01, Spring 2018
 * Programming Assignment #5
 * @author Thomas McDonald
 * @version v1.0 3/9/2018
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
public class Yahtzee {
	/**
     * runs Yahtzee
     *
     * @param N/A
     * @returns N/A
     * @throw File Not Found Exception
     */
    public static void main(String[] args) throws
    FileNotFoundException{
    	//file
    	Scanner file = new Scanner(new File("yahtzeeConfig.txt"));
    	int SIDES_ON_DIE = file.nextInt();
    	int DICE_IN_PLAY = file.nextInt();
    	int ROLLS_ALLOWED = file.nextInt();
    	System.out.println("Current Settings:");
    	System.out.println("	Sides On Die: "+ SIDES_ON_DIE);
    	System.out.println("	Size Of Hand: "+ DICE_IN_PLAY);
    	System.out.println("	Rolls/Turn: "+ ROLLS_ALLOWED);
    	//change settings?
    	System.out.println("Would You Like To Change Settings?(y or n)");
    	Scanner scan = new Scanner(System.in);
    	char changeSettings = scan.next().charAt(0);
    	if(changeSettings == 'y')
    	{
    		System.out.println("	How Many Sides On Die? ");
    		SIDES_ON_DIE=scan.nextInt();
        	System.out.println("	Size Of Hand? ");
        	DICE_IN_PLAY=scan.nextInt();
        	System.out.println("	Rolls/Turn? ");
        	ROLLS_ALLOWED=scan.nextInt();
        	PrintStream write = new PrintStream(new File("yahtzeeConfig.txt"));
        	write.println(SIDES_ON_DIE);
        	write.println(DICE_IN_PLAY);
        	write.println(ROLLS_ALLOWED);
        	write.close();
    	}
    	file.close();
        Hand hand = new Hand(DICE_IN_PLAY, SIDES_ON_DIE);
        char playAgain = 'y';
        int currentRound = 1;
        Score score = new Score(SIDES_ON_DIE); 
        //game begins
        while (playAgain == 'y' && currentRound <= 13) {
        	System.out.println("Round "+ currentRound);
            String keep = "n";//setup to roll all dice in the first roll
            String keepAll = "y";
            for(int i=0;i < DICE_IN_PLAY-1;i++)
            {
            	keep = keep + "n";
            	keepAll = keepAll + "y";
            }
            int turn = 1;
            while (turn <= ROLLS_ALLOWED && !keep.equals(keepAll)) {
                //roll dice not kept
                for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++) {
                    if (keep.charAt(dieNumber) != 'y')
                        hand.reroll(dieNumber);
                }
                //output roll
                System.out.print("Your roll was: ");
                hand.display();
                //if not the last roll of the hand prompt the user for dice to keep
                if (turn < ROLLS_ALLOWED) {
                    System.out.println("enter dice to keep (y or n) ");
                    keep = scan.next();
                }
                turn++;
            }
            //start scoring
            //hand need to be sorted to check for straights
            hand.sort();
            System.out.print("Here is your sorted hand : ");
            hand.display();
            score.scoreHand(hand,scan);
            System.out.println("Enter 'y' to another round");
            playAgain = scan.next().charAt(0);
            currentRound++;
        }
        score.finalScore();//final score of all rounds
        scan.close();
    }
}
