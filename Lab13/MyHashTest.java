/**
 * Lab 13 - MyHashTest
 * Client/driver for MyHashTable.
 * @author geoffwacker
 * @id gwacker
 * 11.08.15
 */
import java.util.Iterator;
import java.util.Scanner;

public class MyHashTest 
{
	public static void main(String[] args)
	{
		//Variable declaration.
		char input = 'a';
			
		//Create a scanner to get input.
		Scanner in = new Scanner(System.in);
		
		//Get the size of the table.
		System.out.println("Please enter the integer size of the hash table:");
		
		//Create a table of specified size.
		MyHashTable<Integer> table = new MyHashTable<Integer>(in.nextInt());
		
		//Advance the scanner.
		in.nextLine();
			
		//Print out the menu once.
		System.out.println("Choose one of the following operations by entering provided letter: ");
		System.out.println("       a - add/insert");
		System.out.println("       f - find");
		System.out.println("       d - delete");
		System.out.println("       e - is empty");
		System.out.println("       p - print");
		System.out.println("	   k - make empty");
		System.out.println("       s - size");
		System.out.println("       o - output");
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
				//User wants to add an element to the table.
				case 'A':
				case 'a':
				{
					//Prompt for input.
					System.out.println("Please enter the integer you'd like to add:");
					int addInt = in.nextInt();
					
					//Call the insert method.
					table.insert(addInt);
					
					//Print add confirmation.
					System.out.println(addInt + " was added!");
					
					//Advance the scanner.
					in.nextLine();
					
					break;
				}
				
				//User wants to find an element in the table.
				case 'F':
				case 'f':
				{
					//Prompt for input.
					System.out.println("Please enter the integer you'd like to find:");
					int findInt = in.nextInt();
					
			
					//We found the value in our table.
					if (table.find(findInt))
					{
						//Print find confirmation.
						System.out.println(findInt + " was found!");
					}
					
					//We didn't find it in our table.
					else
					{
						//Print not found.
						System.out.println(findInt + " was not found!");
					}
					
					//Advance the scanner.
					in.nextLine();
					
					break;
				}
				
				//User wants to delete an element from the table.
				case 'D':
				case 'd':
				{
					//Prompt for input.
					System.out.println("Please enter the integer you'd like to delete:");
					int deleteInt = in.nextInt();
					
					//Call the delete method.
					table.delete(deleteInt);
					
					//Print delete confirmation.
					System.out.println(deleteInt + " was deleted!");
					
					//Advance the scanner.
					in.nextLine();
					
					break;
				}
				
				//User wants to see if the table is empty.
				case 'E':
				case 'e':
				{
					//The table is empty.
					if(table.isEmpty())
					{
						System.out.println("The table is empty.");
					}
					
					//The table is not empty.
					else
					{
						System.out.println("The table is NOT empty.");
					}
					
					break;
				}
				
				//User wants to print the table.
				case 'P':
				case 'p':
				{
					//Call the print method.
					table.print();
					
					break;
				}
				
				//User wants to make the table empty.
				case 'K':
				case 'k':
				{	
					table.makeEmpty();
					System.out.println("The table is now empty!");
					break;
				}
				
				//User wants to get the size of the table.
				case 'S':
				case 's':
				{
					System.out.println("The size of the table is: " + table.size());
					break;
				}
				
				//User wants to output the elements of the table via an iterator.
				case 'O':
				case 'o':
				{
					//Create an iterator to work with our hash table.
					Iterator<Integer> iter = table.iterator();
					
					try 
					{
						//While we still elements left in the table, print them out on one line.
						while (iter.hasNext()) 
						{
							System.out.print(iter.next() + " ");
						}
						
						//Print out out line for spacing.
						System.out.println();
					}
					
					catch (UnsupportedOperationException e) 
					{
						System.out.println("Can't output, there are no elements!");
					}
					
					break;
				}
				
				//User wants to quit.
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