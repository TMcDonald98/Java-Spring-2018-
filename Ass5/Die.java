import java.util.Random;
public class Die
{
    private int number;
    private Random rand;
    /**
     * creates an instance of Die with randomly rolled number
     *
     * @param N/A
     * @returns N/A
     * @throw N/A
     */
    protected Die()
    {
        rand = new Random();
        roll();
    }
    /**
     * randomizes value of die
     *
     * @param N/A
     * @returns int the new value
     * @throw N/A
     */
    public int roll()
    {
        number = rand.nextInt(6)+1;
        return number;
    }
    /**
     * allows user to set number on the die
     *
     * @param num number to change value on die to
     * @returns N/A
     * @throw N/A
     */
    protected void setNumber(int num)
    {
        number = num;
    }
    /**
     * returns current value of die
     *
     * @param N/A
     * @returns int the number stored on die
     * @throw N/A
     */
    protected int getNumber()
    {
        return number;
    }
}
