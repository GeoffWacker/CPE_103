/**
 * Lab 08 - MyListDriver
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
		MyList list = new MyList();
		
		//Create a scanner to get input.
		Scanner in = new Scanner(System.in);
		
		//Loop to ask for input.
		while (input != 'q')
		{
			System.out.println("Choose one of the following operations: ");
			System.out.println("- add (enter the letter a) ");
			System.out.println("- find (Enter the letter f) ");
			System.out.println("- print(enter the letter p) ");
			System.out.println("- sum (Enter the letter s) ");
			System.out.println("- quit (enter the letter q) ");
			input = in.nextLine().charAt(0);
		
			//Switch statement to handle input.
			switch (input)
			{
				//User wants to add.
				case 'a':
				{
					//Ask for an integer to add to the list.
					System.out.println("Please enter an integer to add: ");
				
					//Remove addInt once testing is done.
					int addInt = in.nextInt();
				
					//Add the integer to the list.
					list.add(addInt);
					
					//Print out verification that we added.
					System.out.println(addInt + " was added");
					System.out.println();
				
					
					
					//Advance the scanner.
					in.nextLine();
					break;
				}
			
				//User wants to find an element.
				case 'f':
				{
					//Ask for an integer to find in the list.
					System.out.println("Enter an integer to find: ");
				
					//Remove findInt once testing is done.
					int findInt = in.nextInt();
				
					//If the element is in the list, tell the user we've found it.
					if(list.find(findInt))
					{
						System.out.println("" + findInt + " was found"); 
						System.out.println();
						in.nextLine();
					} 
				
					//The element is not in the list, so tell the user we didn't find it.
					else
					{
						System.out.println("" + findInt + " was not found");
						System.out.println();
						in.nextLine();
					}
               
					break;
				}
			
				//User wants to print the list.
				case 'p':
				{
					list.print();
					break;
				}
			
				//User wants the sum of the list.
				case 's':
				{
					System.out.println("The sum is " + list.sum());
					System.out.println();
					break;
				}
			
				//User wants to quit.
				case 'q':
				{
					in.close();
					break;
				}
			}
		}
	}
}