/**
 * This program prompts the user for 2 strings and tells them if they are anagrams
 * CPSC 224-01, Spring 2018
 * Programming Assignment #1
 * @author Thomas McDonald
 * @version v1.0 1/26/18
 */
import java.util.*;
public class AnagramCheck
{
    public static void main(String[] args)
    {
        String st1,st2;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter 2 Strings that you want to compare.\n");
        System.out.println("First String (Hit enter when done): ");
        st1 = userInput.nextLine();
        System.out.println("\nSecond String (Hit enter when done): ");
        st2 = userInput.nextLine();
        System.out.print("\"" + st1 + "\" and \"" + st2 + "\" are ");
        if(isAnagram(st1,st2))
            System.out.println("anagrams.");
        else
            System.out.println("not anagrams.");
    }
    /**
     * isAnagram Accepts two strings and returns true if they are anagrams, else false
     *
     * @param st1 one of two strings to be compared
     * @param st2 one of two strings to be compared
     * @returns returns true if they are anagrams, else false
     * @throw N/A
     */
    private static boolean isAnagram(String st1, String st2)
    {
        st1 = st1.replaceAll(" ","");
        st2 = st2.replaceAll(" ","");
        if(st1.length()!= st2.length())
            return false;
        char[] st1Array = st1.toLowerCase().toCharArray();
        char[] st2Array = st2.toLowerCase().toCharArray();
        Arrays.sort(st1Array);
        Arrays.sort(st2Array);
        if(Arrays.equals(st1Array,st2Array))
            return true;
        else
            return false;
    }
}