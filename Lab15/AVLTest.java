/**
 * Lab 15 - AVLTest
 * Client/driver for BasicAVL.
 * @author geoffwacker
 * @id gwacker
 * 11.29.15
 */

import java.util.Scanner;

public class AVLTest 
{
	public static void main(String[] args)
	{
		//Variable declaration.
		char input = 'a';
			
		//Create an empty tree to work with.
		BasicAVL tree = new BasicAVL();
			
		//Create a scanner to get input.
		Scanner in = new Scanner(System.in);
			
		//Print out the menu once.
		System.out.println("Choose one of the following operations by entering provided letter: ");
		System.out.println("       a - add/insert");
		System.out.println("       p - print");
		System.out.println("       q - quit");
		
		//Loop to ask for input.
		while(input != 'q')
		{
			//Ask for input.
			System.out.println("Please enter your menu choice:");
			
			//Get the input.
			input = in.nextLine().charAt(0);
		
			//Switch statement to handle input.
			switch(input)
			{
				//User wants to add an element to the AVL tree.
				case 'A':
				case 'a':
				{
					//Prompt for input.
					System.out.println("Please enter an integer to add/insert:");
					
					//Valid input.
					if (in.hasNextInt())
					{
						//Grab the input and advance the scanner..
						int addInt = in.nextInt();
						in.nextLine();
						
						//Insert the integer.
						tree.insert(addInt);
						
						//Print insert confirmation
						System.out.println(addInt + " was added!");
					}
					
					//Input is invalid, so prompt the user to try again.
					else
					{
						System.out.println("Invalid add/insert input. Only integers are permitted.");
						in.nextLine();
					}
					
					break;
				}
				
				//User wants to print the AVL tree.
				case 'P':
				case 'p':
				{
					//Call the print method.
					tree.print();
					break;
				}
				
				//User wants to quit.
				case 'Q':
				case 'q':
				{
					//Give close confirmation.
					System.out.println("Quitting now.");
					break;
				}
				
				//Invalid input.
				default:
				{
					//Print an invalid input message.
					System.out.println("Invalid input. Please try again.");
					break;
				}
				
			}
		}
		
		//Close the scanner since we don't need it anymore.
		in.close();
	}
}