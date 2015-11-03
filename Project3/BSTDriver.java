/**
 * Project 03 - BSTDriver
 * Driver for BST.
 * @author geoffwacker
 * @id gwacker
 * 10.28.15
 */

import java.util.*;

public class BSTDriver 
{
	public static void main(String[] args)
	{
		//Variable declaration.
		char input = 'a';
			
		//Create an empty tree to work with.
		BST<Integer> tree = new BST<Integer>();
			
		//Create a scanner to get input.
		Scanner in = new Scanner(System.in);
			
		//Print out the menu once.
		System.out.println("Choose one of the following operations by entering provided letter: ");
		System.out.println("       a - add the element");
		System.out.println("       d - delete the element");
		System.out.println("       f - find the element");
		System.out.println("       e - check if the tree is empty");
		System.out.println("       k - make the tree empty");
		System.out.println("       n - get the number of nodes (the size) of the tree");
		System.out.println("       m - find the minimal element");
		System.out.println("       x - find the maximal element");
		System.out.println("       p - print the tree in preorder using iterator");
		System.out.println("       i - print the tree in inorder using iterator");
		System.out.println("       l - print the tree in levelorder using iterator");
		System.out.println("       t - print the tree using printTree");
		System.out.println("       o - output the tree using toString");
		System.out.println("       q - Quit the program");
		
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
				//User wants to add an element.
				case 'A':
				case 'a':
				{
					//Ask for input.
					System.out.println("Please enter a valid integer to add:");
					
					//Store the input.
					int addInt = in.nextInt();
					
					//Insert the integer into the BST.
					tree.insert(addInt);
					
					//Print out add confirmation.
					System.out.println(addInt + " was added.");
					
					//Advance the scanner.
					in.nextLine();
					break;
				}
				
				//User wants to delete an element.
				case 'D':
				case 'd':
				{
					//Ask for input.
					System.out.println("Please enter a valid integer to delete:");
					
					//Store the input.
					int deleteInt = in.nextInt();
					
					//Delete the integer from the BST.
					tree.delete(deleteInt);
					
					//Print out delete confirmation.
					System.out.println(deleteInt + " was deleted.");
					
					//Advance the scanner.
					in.nextLine();
					break;
				}
				
				//User wants to find an element.
				case 'F':
				case 'f':
				{
					//Ask for input.
					System.out.println("Please enter a valid integer to find:");
					
					//Store the input.
					int findInt = in.nextInt();
					
					//If we find the integer in the BST, print a found confirmation.
					if(tree.find(findInt))
					{
						System.out.println(findInt + " was found.");
					}
					
					//If we don't find the integer in the BST, print a NOT found confirmation.
					else
					{
						System.out.println(findInt + " was NOT found.");
					}
					//Advance the scanner.
					in.nextLine();
					break;
					
				}
				
				//User wants to check if the tree is empty.
				case 'E':
				case 'e':
				{
					//If the tree is empty, print out an empty confirmation.
					if(tree.isEmpty())
					{
						System.out.println("The tree is empty.");
					}
					
					//If the tree is not empty, print out a NOT empty confirmation.
					else
					{
						System.out.println("The tree is NOT empty.");
					}
					break;	
				}
				
				//User wants to make the tree empty.
				case 'K':
				case 'k':
				{
					//Make the tree empty.
					tree.makeEmpty();
					
					//Print out an empty confirmation.
					System.out.println("The tree is now empty.");
					break;
				}
				
				//User wants to get the size of the tree.
				case 'N':
				case 'n':
				{
					//Print out the size of the tree.
					System.out.println("The tree size is: " + tree.size());
					break;
				}
				
				//User wants to find the min.
				case 'M':
				case 'm':
				{
					try
					{
						System.out.println("The minimum value is: " + tree.findMinimum());
					}
					
					catch(BST.MyException e)
					{
						System.out.println("Error: The tree is empty!");
					}	
					break;
				}
				
				//User wants to find the max.
				case 'X':
				case 'x':
				{
					try
					{
						System.out.println("The maximum value is: " + tree.findMaximum());
					}
					
					catch(BST.MyException e)
					{
						System.out.println("Error: The tree is empty!");
					}
					break;
				}
				
				//User wants to print the tree via pre-order.
				case 'P':
				case 'p':
				{
					//Create a pre-order iterator.
					Iterator<Integer> preOrder = tree.iteratorPre();
					
					//Make sure the tree isn't empty.
					if(!tree.isEmpty()) 
					{
						//While the pre-order iterator has a next value, print out the values on one line.
						while(preOrder.hasNext()) 
						{
							System.out.print(preOrder.next() + " ");
						}
						
						//Print out a line for spacing.
						System.out.println();
					}	
					break;
				}
				
				//User wants to print the tree via in-order.
				case 'I':
				case 'i':
				{
					//Create an in-order iterator.
					Iterator<Integer> inOrder = tree.iteratorIn();
					
					//Make sure the tree isn't empty.
					if(!tree.isEmpty()) 
					{
						//While the in-order iterator has a next value, print out the values on one line.
						while(inOrder.hasNext()) 
						{
							System.out.print(inOrder.next() + " ");
						}
						
						//Print out a line for spacing.
						System.out.println();
					}
	               break;
				}
				
				//User wants to print the tree via level-order.
				case 'L':
				case 'l':
				{
					//Create a level-order iterator.
					Iterator<Integer> levelOrder = tree.iteratorLevel();
					
					//Make sure the tree isn't empty.
					if(!tree.isEmpty()) 
					{
						//While the level-order iterator has a next value, print out the values on one line.
						while(levelOrder.hasNext()) 
						{
							System.out.print(levelOrder.next() + " ");
						}
						
						//Print out a line for spacing.
						System.out.println();
					}	
	               break;
				}
				
				//User wants to print the tree via printTree.
				case 'T':
				case 't':
				{
					tree.printTree();
					System.out.println();
					break;
				}
				
				//User wants to output the tree via toString.
				case 'O':
				case 'o':
				{
					//Print out the tree using the toString method.
					System.out.println(tree.toString());
					break;
				}
				
				//User wants to quit the program.
				case 'Q':
				case 'q':
				{
					//Print a quitting message.
					System.out.println("Shutting down now, goodbye!");
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