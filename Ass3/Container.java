/**
 * This program reads points from a file and uses their index and value to find the greatest
 * area of containers formed from any two points
 * CPSC 224-01, Spring 2018
 * Programming Assignment #33
 * @author Thomas McDonald
 * @version v1.0 2/9/18
 */
import java.io.*;
import java.util.*;
public class Container {
    public static void main(String[] args) throws
            FileNotFoundException{
        int[] points = createArray();
        int maxArea = maxContainer(points);
        System.out.println("Max Container (Area): " + maxArea);
    }
    /**
     * maxContainer Accepts an array and uses a nested for loop to find
     * a combination of points with the highest resulting area, 
     * prints the points then returns the area
     *
     * @param points is an int array with all integer values from data.txt
     * @returns int the maximum area of a container
     * @throw N/A
     */
    static int maxContainer(int[] points){
        int maxIndex = 0;
        int maxIndex2 = 0;
        int maxArea = 0;
        for(int i = 0; i < points.length; i++){// i = index of point 1
            for(int k = 0; k < points.length;k++){// k = index of point 2

                int length = Math.abs(i-k);// my index starts at 0 but the +1's would negate
                int height = Math.min(points[i],points[k]);//want highest Shared height 
                if(height*length > maxArea){
                    maxArea = height * length;
                    maxIndex = i;
                    maxIndex2 = k;
                }
                if(i==k+1)//this is to avoid comparing a point to itself
                    k++;
            }
        }
        System.out.println("Point 1: ("+ (maxIndex+1) +", " + points[maxIndex]+")");
        System.out.println("Point 2: ("+ (maxIndex2+1) +", " + points[maxIndex2]+")");
        return maxArea;
    }
    /**
     * createArray creates a scanner from the file data.txt,
     * and stores as many integer values as it has into an array
     *
     * @param N/A
     * @returns int[] array of integers contained in file data.txt
     * @throw FileNotFoundException throws error if "data.txt" does not exist
     */
    static int[] createArray() throws
            FileNotFoundException{
        Scanner forSize = new Scanner(new File("data.txt"));// need separate
        // need scanner before and after we declare array to get size then fill
        int count = 0;//the size of the array
        while(forSize.hasNextInt()){//traverse through entire file
            int temp = forSize.nextInt();
            count++;
        }
        forSize.close();
        Scanner scan = new Scanner(new File("data.txt"));
        int[] points = new int[count];
        for(int i=0; i < count;i++){//fills array
            points[i] = scan.nextInt();
        }
        scan.close();
        return points;
    }
}
