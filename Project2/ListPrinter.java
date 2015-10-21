/**
 * Project 02 - ListPrinter
 * @author geoffwacker, kevinliu
 * 10.19.15
 */

import java.util.*;
import java.io.*;

public class ListPrinter 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//Variable declaration.
		String tempName;
		long tempId;
		int i = 1;
		
		//Create a scanner for keyboard input.
		Scanner in = new Scanner(System.in);
		
		//Create an empty heap that will hold students.
		BinHeap<Student> studentHeap = new BinHeap<Student>();
		
		//Get the file name.
		System.out.println("Enter the full file name: ");

		//Create a scanner to go through the file.
		Scanner fileScan = new Scanner(new File(in.nextLine()));
		
		//Keep reading the file until we reach the end of it.
		while(fileScan.hasNext())
		{
			//Create a scanner to go through line by line.
			Scanner lineScan = new Scanner(fileScan.nextLine());
	         
			if(lineScan.hasNextLong())
	         {
				//Get the ID to work with.
				tempId = lineScan.nextLong();
				
				//If we still have input and the ID is valid.
	            if(lineScan.hasNext() && tempId > 0) 
	            {
	            	//Get the last name to work with.
	            	tempName = lineScan.next();
	            	
	            	//Extra values that we don't want, so the record is invalid.
	            	if(lineScan.hasNext())
	            	{
	            	}
	            	
	            	//Record is valid, so insert it.
	            	else
	            	{
	            		studentHeap.insert(new Student(tempId, tempName));
	            	}
        		}
	         }
		}
		
		//Close the scanners since we don't need them anymore.
		in.close();
		fileScan.close();

		//Print out the all the valid student records in sequential order.
		System.out.println("Student List:");
		
		//Loop until the heap is empty.
		while(!studentHeap.isEmpty())
		{
			System.out.println(i++ +". " + studentHeap.deleteMin().toString());
		}
	}
}