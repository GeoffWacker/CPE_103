/**
 * Lab 10 - BSTWork
 * Driver/client for BasicBST.
 * @author geoffwacker
 * 10.27.15
 */

import java.util.Scanner;

public class BSTWork 
{
	public static void main(String[] args)
	{
		//Variable declaration.
		char input = 'a';
		
		//Create an empty tree to work with.
		BasicBST tree = new BasicBST();
		
		//Create a scanner to get input.
		Scanner in = new Scanner(System.in);
				
		//Loop to ask for input.
		while (input != 'q')
		{
			//Print out the menu.
			System.out.println("Choose one of the following operations: ");
			System.out.println("- add/insert (Enter the letter a) ");
			System.out.println("- odds (Enter the letter o) ");
			System.out.println("- height (Enter the letter h) ");
			System.out.println("- leaves (Enter the letter l) ");
			System.out.println("- one-child nodes (Enter the letter c) ");
			System.out.println("- quit (Enter the letter q) ");
			
			//Get the input.
			input = in.nextLine().charAt(0);
		
			//Switch statement to handle input.
			switch (input)
			{
				//User wants to add/insert.
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
				
				//User wants to find the number of odds.
				case 'o':
				{
					//Print out the number of odd values.
					System.out.println("Number of odd values in the BST: " + tree.countOdds());
                    break;
				}
				
				//User wants to find the height of the tree.
				case 'h':
				{
					//Print out the height.
					System.out.println("The height of the BST is: " + tree.height());
                    break;	
				}
				
				//User wants to find the number of leaves.
				case 'l':
				{
					//Print out the number of leaves.
					System.out.println("Number of leaves in the BST: " + tree.countLeaves());
                    break;
				}
				
				//User wants to find the number of one-child nodes.
				case 'c':
				{
					//Print out the number of one-child nodes.
					System.out.println("Number of one-child parents in the BST: " + tree.countOneChildParents());
                    break;
				}
				
				//User wants to quit.
				case 'q':
				{
					//Give close confirmation.
					System.out.println("Quitting now.");
					break;
				}
				
				//Invalid input.
				default:
				{
					System.out.println("Invalid input. Please try again.");
					break;
				}
			}
		}
		
		//Close the scanner since we don't need it anymore.
		in.close();
	}		
}