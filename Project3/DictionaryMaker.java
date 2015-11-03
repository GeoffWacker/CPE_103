/**
 * Project 03 - DictionaryMaker
 * Create a sorted in-order output file from an input file of random words.
 * @author geoffwacker
 * @id gwacker
 * 10.28.15
 */

import java.io.*;
import java.util.*;

public class DictionaryMaker 
{
	public static void main(String[] args)
	{
		//Create a scanner for user input.
		Scanner in = new Scanner(System.in);

		//Get the input file name.
		System.out.println("Please enter the full name of the input file:");
		String input = in.nextLine();
		
		//Get the output file name.
		System.out.println("Please enter the full name of the output file:");
		String output = in.nextLine();

		try
		{
			//Create a FileInputStream so we can read from the input file.
			FileInputStream inFile = new FileInputStream(input);
			
			//Set up to write to an output file.
			PrintStream outFile = new PrintStream(new FileOutputStream(output));
			
			//Create a scanner to go through the input file.
			Scanner inScan = new Scanner(inFile);

			//Create a dictionary to hold all of our words.
			BST<String> dictionary = new BST<String>();
	         
			//While we still have input left, look for words.
			while(inScan.hasNextLine())
			{
				//Grab the next string in the input file. 
				String word = inScan.nextLine();
	            
				//If we don't have it in our dictionary already, add it.
				if(!dictionary.find(word))
				{
					//Add the word to our dictionary file.
					dictionary.insert(word);
				}
			}

	         //Create an in-order iterator so we can print out the words.
	         Iterator<String> inItr = dictionary.iteratorIn();

	         //While we still have words left in our dictionary, print them to the output file.
	         while(inItr.hasNext())
	         {
	            //Print the word on a separate line.
	            outFile.println(inItr.next());
	         }
	         
	         //Close outFile and inScan since we don't need them anymore.
	         outFile.close();
	         inScan.close();
	      }
		
		//The file wasn't found, so output an error message.
		catch(FileNotFoundException e)
		{
			System.out.println("Error: file was not found. Please enter a valid input file name.");
		}
		
		//Close the scanner since we don't need it anymore.
		in.close();
	}
}