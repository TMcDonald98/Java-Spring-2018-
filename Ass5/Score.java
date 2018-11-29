public class Score {
    private Hand hand;
    /**
     * creates an instance of score board using a hand
     *
     * @param hand the hand of die to be scored
     * @returns N/A
     * @throw N/A
     */
    protected Score(Hand hand_i)
    {
        hand=hand_i;
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
        for (int dieValue = 1; dieValue <= 6; dieValue++) {
            int currentCount = 0;
            for (int diePosition = 0; diePosition < hand.size; diePosition++) {
                if (hand.compare(diePosition, dieValue))
                    currentCount++;
            }
            System.out.print("Score " + dieValue * currentCount + " on the ");
            System.out.println(dieValue + " line");
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
        if (hand.maxOfAKindFound() >= 3)
            System.out.println("Score " + hand.totalAll() + " on the 3 of a Kind line");
        else
            System.out.println("Score 0 on the 3 of a Kind line");
        if (hand.maxOfAKindFound() >= 4)
            System.out.println("Score " + hand.totalAll() + " on the 4 of a Kind line");
        else
            System.out.println("Score 0 on the 4 of a Kind line");
        if (hand.fullHouseFound())
            System.out.println("Score 25 on the Full House line" );
        else
            System.out.println("Score 0 on the Full House line");
        if (hand.maxStraightFound() >= 4)
            System.out.println("Score 30 on the Small Straight line");
        else
            System.out.println("Score 0 on the Small Straight line");
        if (hand.maxStraightFound() >= 5)
            System.out.println("Score 40 on the Large Straight line");
        else
            System.out.println("Score 0 on the Large Straight line");
        if (hand.maxOfAKindFound() >= 5)
            System.out.println("Score 50 on the Yahtzee line");
        else
            System.out.println("Score 0 on the Yahtzee line" );
        System.out.println("Score " + hand.totalAll() + " on the Chance line");
    }
}
