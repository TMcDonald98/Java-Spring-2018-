/**
 * This program prompts the user for a strings and an amount of rows
 * and zig zags the string across that many rows
 * CPSC 224-01, Spring 2018
 * Programming Assignment #2
 * @author Thomas McDonald
 * @version v1.0 2/2/18
 */
import java.util.*;
public class ZIGZAG {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String str = getString(scan);
		int rows = getRows(scan);
		scan.close();
		String str_o = zigzagConversion(str,rows);
		finalMessage(str_o,str,rows);
	}
	/**
	 * getString Accepts a scanner and prompts the user to enter a string, edits it,
	 * and returns it
	 *
	 * @param scan a common scanner to access user input
	 * @returns string entered by user
	 * @throw N/A
	 */
	private static String getString(Scanner scan){
		System.out.println("Please enter a String that you would like ZigZaged:\n");
		String str = scan.nextLine();
		str = str.replaceAll(" ","");
		str = str.toUpperCase();
		return str;
	}
	/**
	 * getRows Accepts a scanner and prompts the user to enter an amount of rows
	 * and returns it
	 *
	 * @param scan a common scanner to access user input
	 * @returns int entered by user
	 * @throw N/A
	 */
	private static int getRows(Scanner scan){
		System.out.println("Please enter how many rows that you would like ZigZaged:\n");
		int rows = scan.nextInt();
		return rows;
	}
	/**
	 * zigzagConversion Accepts a the user input string and amount of rows and zig zags
	 * the string and returns it
	 *
	 * @param str a string entered by the user to be zigzaged
	 * @param rows the desired amount of rows to be zigzaged across(input by user)
	 * @returns Zigzaged version of string
	 * @throw N/A
	 */
	private static String zigzagConversion(String str,int rows)
	{
		int length = str.length();
		int currentRow = 1;
		boolean up = false;
		String[] output = new String[rows];
		for(int i=0;i<rows;i++){
			output[i] = "";
		}
		for(int i = 0; i < length; i++ ){
			output[currentRow-1] = output[currentRow-1] + str.substring(i, i+1);
			if(currentRow == rows)
				up = true;
			else if(currentRow == 1)
				up = false;
			if(up)
				currentRow--;
			else
				currentRow++;
		}
		String finalOutput = "";
		for(String current: output){
			finalOutput = finalOutput + current;
		}
		return finalOutput;			
	}
	/**
	 * final message accepts the user inputs and the final output string and prints it
	 *
	 * @param str a string entered by the user to be zigzaged
	 * @param rows the desired amount of rows to be zigzaged across(input by user)
	 * @param str_o the zigzaged version of the oringal string
	 * @returns N/A
	 * @throw N/A
	 */
	private static void finalMessage(String str_o,String str, int rows){
		System.out.println("Original String: "+str);
		System.out.println("Zig-Zag ("+ rows +" rows): "+str_o);
	}
}
