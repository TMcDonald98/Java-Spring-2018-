import java.util.*;
public class Hand {
    private ArrayList<Die> hand;
    protected int size;
    protected int sidesOnDie;
    /**
     * creates an instance of hand which contains arraylist of die
     *
     * @param size_i size of hand(how many dice)
     * @returns N/A
     * @throw N/A
     */
    protected Hand(int size_i, int sides)
    {
        size = size_i;
        sidesOnDie = sides;
        hand = new ArrayList<Die>(size);
        for(int i=0;i<size_i;i++)
            hand.add(new Die(sidesOnDie));
    }
    /**
     * compares an index with a dice value to see if equal
     *
     * @param diePosition the index of desired die
     * @param dieValue the value currently being checked
     * @returns boolean true if equal, else false
     * @throw N/A
     */
    protected boolean compare(int diePosition, int dieValue)
    {
        return hand.get(diePosition).getNumber() == dieValue;
    }
    /**
     * rerolls a dice at given index
     *
     * @param index the index of die to be rerolled
     * @returns N/A
     * @throw N/A
     */
    protected void reroll(int index)
    {
        Die die = hand.get(index);
        die.roll();
        hand.set(index,die);
    }
    /**
     * sorts array by die value using bubble sort
     *
     * @param N/A
     * @return N/A
     * @throws N/A
     */
    protected void sort()
    {
        boolean swap;
        int temp;
        do
        {
            swap = false;
            for (int count = 0; count < (size - 1); count++)
            {
                if ((hand.get(count)).getNumber() > (hand.get(count + 1)).getNumber())
                {
                    temp = (hand.get(count)).getNumber();
                    Die die = new Die(sidesOnDie);
                    die.setNumber(temp);
                    hand.set(count,hand.get(count + 1));
                    hand.set(count + 1, die);
                    swap = true;
                }
            }
        } while (swap);
    }
    /**
     * returns the number of the largest straight found
     *
     * @param N/A
     * @return int how long the longest straight was
     * @throws N/A
     */
    protected int maxStraightFound()
    {
        int maxLength = 1;
        int curLength = 1;
        for(int counter = 0; counter < size-1; counter++)//might be -2????
        {
            if (hand.get(counter).getNumber() + 1 == hand.get(counter + 1).getNumber() ) //jump of 1
                curLength++;
            else if (hand.get(counter).getNumber() + 1 < hand.get(counter + 1).getNumber()) //jump of >= 2
                curLength = 1;
            if (curLength > maxLength)
                maxLength = curLength;
        }
        return maxLength;
    }
    /**
     * returns the largest amount of a reoccurring number
     *
     * @param size_i size of hand(how many dice)
     * @returns N/A
     * @throw N/A
     */
    protected int maxOfAKindFound()
    {
        int maxCount = 0;
        int currentCount;
        for (int dieValue = 1; dieValue <= sidesOnDie; dieValue++)
        {
            currentCount = 0;
            for (int diePosition = 0; diePosition < size; diePosition++)
            {
                if (hand.get(diePosition).getNumber() == dieValue)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }
    /**
     * returns the sum of all die values
     *
     * @param N/A
     * @returns sum of all die
     * @throw N/A
     */
    protected int totalAll()
    {
        int total = 0;
        for(int diePosition = 0; diePosition <size; diePosition++)
        {
            total +=hand.get(diePosition).getNumber();
        }
        return total;
    }
    /**
     * displays the current hand (all die values)
     *
     * @param N/A
     * @returns N/A
     * @throw N/A
     */
    protected void display()
    {
        for (int dieNumber = 0; dieNumber < size; dieNumber++) {
            System.out.print(hand.get(dieNumber).getNumber() + " ");
        }
        System.out.println();
    }
    /**
     * checks if a full house exists
     *
     * @param N/A
     * @returns boolean true if full house, else false
     * @throw N/A
     */
    protected boolean fullHouseFound()
    {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        boolean found4K = false;
        boolean found5K = false;
        int currentCount ;
        for (int dieValue = 1; dieValue <= sidesOnDie; dieValue++)
        {
            currentCount = 0;
            for (int diePosition = 0; diePosition < size; diePosition++)
            {
                if (compare(diePosition, dieValue))
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
            if (currentCount == 4)
                found4K = true;
            if (currentCount == 5)
                found5K = true;
        }
        if (found2K && found3K || found5K|| (found4K&&found2K))
            foundFH = true;
        return foundFH;
    }
}
