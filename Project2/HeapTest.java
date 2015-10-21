/**
 * Project 02 - HeapTest
 * @author geoffwacker, kevinliu
 * 10.19.15
 */

import java.util.*;

public class HeapTest 
{
	public static void main(String[] args)
	{
		//Variable declaration.
		char input = 'a';
		
		//Define a scanner.
		Scanner in = new Scanner(System.in);
		
		//Ask for the initial size of the heap.
		System.out.println("Please enter the initial size of the heap: ");
		
		//Create a string binHeap of the requested size.
		BinHeap<String> stringHeap = new BinHeap<String>(in.nextInt()); 
		in.nextLine();
		
		//Loop to ask for input.
		while (input != 'q')
		{
			System.out.println("Choose one of the following operations: ");
			System.out.println("- add an element (enter the letter a)");
			System.out.println("- delete the smallest element (enter the letter d)");
			System.out.println("- is the heap empty (enter the letter e)");
			System.out.println("- size of the collection (enter the letter s)");
			System.out.println("- print the collection (enter the letter p)");
			System.out.println("- quit (enter the letter q)");
			input = in.nextLine().charAt(0);
			
			//Switch statement to handle input.
			switch (input)
			{
				//User wants to add.
				case 'a':
				{
					System.out.println("What would you like to insert?");
		          
					if(in.hasNext())
					{
						String val = in.nextLine();
						stringHeap.insert(val);
						System.out.println(val + " inserted");
					}
		               
					else
					{
						System.out.println("Please enter a valid input: ");
						in.nextLine();
					}
					break;
				}
				
				//User wants to delete the minimum.
				case 'd':
				{
					try
					{
						System.out.println(stringHeap.deleteMin()+" deleted");
					}
		          
					catch (BinHeap.MyException e)   
					{
						System.out.println("Invalid operation on an empty heap");
					}
					break;
				}
				
				//User wants to check if the heap is empty.
				case 'e':
				{
					if (stringHeap.isEmpty())
					{
						System.out.println("heap is empty");
					}
	                     
					else
					{
						System.out.println("heap is not empty");
					}
					break;
				}
				
				//User wants to know the size of the heap.
				case 's':
				{
					System.out.println("The size is: " + stringHeap.size());
	                break;
				}
				
				//User wants to print the heap.
				case 'p':
				{
					System.out.println(stringHeap);
					break;
				}
				
				//User wants to quit.
				case 'q':
				{
					//Close the scanner since we won't need it anymore.
					in.close();
					
					//Empty the heap, one value at a time, separated by spaces.
					while (!stringHeap.isEmpty())
					{
						System.out.print(stringHeap.deleteMin() + " ");
					}
					break;
				}
				
				//User entered invalid input.
				default:
				{
					System.out.println("Invalid choice");
					break;
				}	
			}
		}
	}
}