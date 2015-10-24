/**
 * Lab 09 - MyListDriver
 * @author geoffwacker, kevinliu
 * 10.21.15
 */
import java.util.*;

public class MyListDriver 
{
	public static void main(String[] args)
	{	
		//Variable declaration.
		char input = 'a';
				
		//Create a list to work with.
		MySortedList list = new MySortedList();
		
		//Create a scanner to get input.
		Scanner in = new Scanner(System.in);
		
		//Loop to ask for input.
		while (input != 'q')
		{
			//Print out the menu.
			System.out.println("Choose one of the following operations: ");
			System.out.println("- add (enter the letter a) ");
			System.out.println("- delete (Enter the letter d) ");
			System.out.println("- max (enter the letter x) ");
			System.out.println("- min (Enter the letter m) ");
			System.out.println("- print (Enter the letter p) ");
			System.out.println("- isEmpty (Enter the letter e) ");
			System.out.println("- quit (enter the letter q) ");
			
			//Get the input.
			input = in.nextLine().charAt(0);
		
			//Switch statement to handle input.
			switch (input)
			{
				//User wants to add.
				case 'a':
				{
					//Grab the input.
					System.out.println("What would you like to add?");
					int addInt = in.nextInt();
					
					//Add the value.
					list.add(addInt);
					
					//Give delete confirmation.
					System.out.println(addInt + " was added");
					
					//Advance the scanner.
					in.nextLine();
					break;
				}
			
				//User wants to delete.
				case 'd':
				{
					//Grab the input.
					System.out.println("What would you like to delete?");
					int deleteInt = in.nextInt();
					
					//Delete the value.
					list.delete(deleteInt);
					
					//Give delete confirmation.
					System.out.println(deleteInt + " was deleted");
					
					//Advance the scanner.
					in.nextLine();
					break;
				}
			
				//User wants to find max.
				case 'x':
				{
					//If the list is empty, print out an error message to avoid NullPointerException.
					if (list.isEmpty())
					{
						System.out.println("Can't find the max: the list is empty!");
						break;
					}
					
					//The list isn't empty, so we're good to find the max.
					else
					{
						System.out.println("The largest element is: " + list.max());
						break;
					}
				}
			
				//User wants to find min.
				case 'm':
				{
					//If the list is empty, print out an error message to avoid NullPointerException.
					if (list.isEmpty())
					{
						System.out.println("Can't find the min: the list is empty!");
						break;
					}
					
					//The list isn't empty, so we're good to find the min.
					else
					{	
						System.out.println("The smallest element is: " + list.min());
						break;
					}
				}
			
				//User wants to print.
				case 'p':
				{
					//If the list is empty, print nothing to avoid NullPointerException.
					if (list.isEmpty())
					{
						System.out.println("");
						break;
					}
					
					//List isn't empty, so print it out.
					else
					{
						list.print();
						break;
					}
				}
				
				//User wants to see if empty.
				case 'e':
				{
					//List is empty.
					if (list.isEmpty())
					{
						System.out.println("The list is empty.");
					}
					
					//List is NOT empty.
					else
					{
						System.out.println("The list is NOT empty.");
					}
				}
				
				//User wants to quit.
				case 'q':
				{
					//Close the scanner since we don't need it anymore.
					in.close();
					break;
				}
			}
		}
	}
}