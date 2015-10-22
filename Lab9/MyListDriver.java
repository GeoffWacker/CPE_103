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
			System.out.println("Choose one of the following operations: ");
			System.out.println("- add (enter the letter a) ");
			System.out.println("- delete (Enter the letter d) ");
			System.out.println("- max (enter the letter x) ");
			System.out.println("- min (Enter the letter m) ");
			System.out.println("- print (Enter the letter p) ");
			System.out.println("- isEmpty (Enter the letter e) ");
			System.out.println("- quit (enter the letter q) ");
			input = in.nextLine().charAt(0);
		
			//Switch statement to handle input.
			switch (input)
			{
				//User wants to add.
				case 'a':
				{
					break;
				}
			
				//User wants to delete.
				case 'd':
				{
					break;
				}
			
				//User wants to find max.
				case 'x':
				{
					break;
				}
			
				//User wants to find min.
				case 'm':
				{
					break;
				}
			
				//User wants to print.
				case 'p':
				{
					break;
				}
				
				//User wants to see if empty.
				case 'e':
				{
					break;
				}
				
				//User wants to quit.
				case 'q':
				{
					break;
				}
			}
		}
	}
}