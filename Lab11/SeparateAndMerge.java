/**
 * Lab 10 - SeparateAndMerge
 * Client/driver for LList<T>.
 * @author geoffwacker
 * 10.27.15
 */

import java.util.*;

public class SeparateAndMerge 
{
	public static void main(String[] args)
	{			
		//Create two LList objects.
		LList<Integer> listInt = new LList<Integer>();
        LList<Float> listFloat = new LList<Float>();
        
        //Create a scanner to get input.
  		Scanner in = new Scanner(System.in);
        
  		//Ask for input.
        System.out.println("What floats/integers would you like to input?");
        
        //Loop through input.
        while (in.hasNext())
        {
        	//We have an int, so add it to listInt.
            if (in.hasNextInt())
            {
            	listInt.add(in.nextInt());
            }
            
            //We have a flat, so add it to listFloat.
            else if (in.hasNextFloat())
            {
            	listFloat.add(in.nextFloat());
            }
            
            //User wants to quit, so break out of the loop.
            else if (in.next().charAt(0) == 'q')
            {
            	break;
            }
        }
        
        //Print out "Inputted values: " so we can start printing out all the inputted elements.
        System.out.print("Inputted values: ");
        
        //Create two iterators to go through their respective linked list.
        Iterator<Integer> intItr = listInt.iterator();
        Iterator<Float> floatItr = listFloat.iterator();

        //Keep printing integers and floats until we run out of integers.
        while (intItr.hasNext())
        {
        	//Print out an integer.
            System.out.print(intItr.next() + " ");
            
            //If we have another float to print, print it out.
            if (floatItr.hasNext())
            {
            	System.out.print(floatItr.next() +  " ");
            }
        }
        
        //We're out of integers, so print out the rest of the floats one after another.
        while(floatItr.hasNext())
        {
            System.out.print(floatItr.next() + " ");
        }
        
        //Close the scanner since we don't need it anymore.
        in.close();
	}
}