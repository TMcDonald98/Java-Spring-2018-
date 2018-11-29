import java.util.Scanner;

public class Score {
    private Hand hand;
    private boolean[] upperScored;
    private boolean[] lowerScored;
    private int[] upScores;
    private int[] lowScores;
    //private int[] currentScores;
    private int sides;
    /**
     * creates an instance of score board using a hand
     *
     * @param hand the hand of die to be scored
     * @returns N/A
     * @throw N/A
     */
    protected Score(int sides_i)
    {
    	sides=sides_i;
        upperScored = new boolean[sides];
        lowerScored = new boolean[7];
        upScores = new int[sides];
        lowScores = new int[7];
        for(int i = 0; i< sides;i++)
        	upperScored[i] = false;
        for(int i = 0; i<7;i++)
        	lowerScored[i] = false;
    }
    /**
     * finds all scores for hand and adds one that user chooses to score card
     *
     * @param hand_i the hand to be input
     * @returns N/A
     * @throw N/A
     */
    protected void scoreHand(Hand hand_i,Scanner scan)
    {
    	hand= hand_i;
    	upperSection();
    	lowerSection(); 
    	chooseLine(scan);
    }
    /**
     * asks user to choose line that they want scored
     *
     * @param N/A
     * @returns N/A
     * @throw N/A
     */
    protected void chooseLine(Scanner scan)
    {
    	System.out.println("Which Line Number Would You Like To Score?");
    	//Scanner scan = new Scanner(System.in);
    	int line = scan.nextInt();
    	if(line <= sides && upperScored[line-1] != true && line>0)
    		upperScored[line-1] = true;
    	else if(line <= sides+7 && lowerScored[line-sides-1]!=true && line>0)
    		lowerScored[line-sides-1]=true;
    	else
    		chooseLine(scan);
    	//scan.close();
    }
    /**
     * calculates and prints the upper part of scoreboard
     *
     * @param N/A
     * @returns N/A
     * @throw N/A
     */
    protected void upperSection()
    {
        for (int dieValue = 1; dieValue <= hand.sidesOnDie; dieValue++) {
            int currentCount = 0;
            for (int diePosition = 0; diePosition < hand.size; diePosition++) {
                if (hand.compare(diePosition, dieValue))
                    currentCount++;
            }
            if(!upperScored[dieValue-1])
            {
            	upScores[dieValue-1]= currentCount*dieValue;
	            System.out.print(dieValue+") Score " + dieValue * currentCount + " on the ");
	            System.out.println(dieValue + " line");
        	}
        }
    }
    /**
     * calculates and prints the lower part of scoreboard
     *
     * @param N/A
     * @returns N/A
     * @throw N/A
     */
    protected void lowerSection()
    {
    	int label = sides+1;
    	if(!lowerScored[label-sides-1])
    	{
	        if (hand.maxOfAKindFound() >= 3){
	        	lowScores[label-sides-1] = hand.totalAll();
	            System.out.println(label+") Score " + hand.totalAll() + " on the 3 of a Kind line");
	        }
	        else{
	        	lowScores[label-sides-1] = 0;
	            System.out.println(label+") Score 0 on the 3 of a Kind line");
	        }
	    }
	    label++;
	    if(!lowerScored[label-sides-1])
    	{
	        if (hand.maxOfAKindFound() >= 4){
	        	lowScores[label-sides-1] = hand.totalAll();
	            System.out.println(label+") Score " + hand.totalAll() + " on the 4 of a Kind line");
	        }else{
	            System.out.println(label+") Score 0 on the 4 of a Kind line");
	            lowScores[label-sides-1] = 0;
	        }
        }
	    label++;
	    if(!lowerScored[label-sides-1])
    	{
	        if (hand.fullHouseFound()){
	        	lowScores[label-sides-1] = 25;
	        	System.out.println(label+") Score 25 on the Full House line" );
	        }else{
	        	lowScores[label-sides-1] =0;
	        	System.out.println(label+") Score 0 on the Full House line");
	        }
	    }
	    label++;
	    if(!lowerScored[label-sides-1])
    	{
	        if (hand.maxStraightFound() >= 4){
	        	lowScores[label-sides-1] = 30;
	            System.out.println(label+") Score 30 on the Small Straight line");
	        }else{
	        	lowScores[label-sides-1] = 0;
	            System.out.println(label+") Score 0 on the Small Straight line");
	        }
        }
	    label++;
	    if(!lowerScored[label-sides-1])
    	{
	        if (hand.maxStraightFound() >= 5){
	        	lowScores[label-sides-1] = 40;
	            System.out.println(label+") Score 40 on the Large Straight line");
	        }else{
	        	lowScores[label-sides-1] =0;
	        	System.out.println(label+") Score 0 on the Large Straight line");
	        }
        }
	    label++;
	    if(!lowerScored[label-sides-1])
    	{
		    if (hand.maxOfAKindFound() >= 5)
		    {
		    	lowScores[label-sides-1] = hand.totalAll();
	            System.out.println(label+") Score 50 on the Yahtzee line");
		    }else{
		    	lowScores[label-sides-1] =0;
		    	System.out.println(label+") Score 0 on the Yahtzee line" );
		    }
    	}
	    label++;
	    if(!lowerScored[label-sides-1]){
	    	lowScores[label-sides-1] = hand.totalAll();
	    	System.out.println(label+") Score " + hand.totalAll() + " on the Chance line");
	    }
	}
    /**
     * Prints the final score after rounds are complete
     *
     * @param N/A
     * @returns N/A
     * @throw N/A
     */
    protected void finalScore()
    {
    	int total = 0;
    	//final upper
    	for (int dieValue = 1; dieValue <= hand.sidesOnDie; dieValue++) 
    	{
            if(upperScored[dieValue-1]){
            	System.out.print(dieValue+") Score " + upScores[dieValue-1] + " on the ");
            	System.out.println(dieValue + " line");
            	total= total+upScores[dieValue-1];
            }
            else{
            	System.out.print(dieValue+") Score 0 on the ");
            	System.out.println(dieValue + " line");
            }
        }
    	//final lower
    	int label = sides+1;
    	if(lowerScored[label-sides-1]){
		    System.out.println(label+") Score " + lowScores[label-sides-1] + " on the 3 of a Kind line");
		    total= total+lowScores[label-sides-1];
    	}
    	else
    		System.out.println(label+") Score 0 on the 3 of a Kind line");
	    label++;
	    if(lowerScored[label-sides-1]){
		    System.out.println(label+") Score " + lowScores[label-sides-1] + " on the 4 of a Kind line");
		    total= total+lowScores[label-sides-1];
	    }
	    else
	    	System.out.println(label+") Score 0 on the 4 of a Kind line");
	    label++;
	    if(lowerScored[label-sides-1]){
		    System.out.println(label+") Score " + lowScores[label-sides-1] + " on the Full House line" );
		    total= total+lowScores[label-sides-1];
	    }
	    else
	    	System.out.println(label+") Score 0 on the Full House line");
	    label++;
	    if(lowerScored[label-sides-1]){
		    System.out.println(label+") Score " + lowScores[label-sides-1] + " on the Small Straight line");
		    total= total+lowScores[label-sides-1];
	    }
	    else
	    	System.out.println(label+") Score 0 on the Small Straight line");
	    label++;
	    if(lowerScored[label-sides-1]){
		    System.out.println(label+") Score " + lowScores[label-sides-1] + " on the Large Straight line");
		    total= total+lowScores[label-sides-1];
	    }
	    else
	    	System.out.println(label+") Score 0 on the Large Straight line");
		label++;
		if(lowerScored[label-sides-1]){
		    System.out.println(label+") Score " + lowScores[label-sides-1] + " on the Yahtzee line");
		    total= total+lowScores[label-sides-1];
		}
		else
			System.out.println(label+") Score 0 on the Yahtzee line");
		label++;
		if(lowerScored[label-sides-1]){
			System.out.println(label+") Score " + lowScores[label-sides-1] + " on the Chance line");
		    total= total+lowScores[label-sides-1];
		}
		else
			System.out.println(label+") Score 0 on the Chance line");
		System.out.println("TOTAL SCORE: "+ total);
    }
}
