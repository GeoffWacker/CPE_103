/**
 * Project 04 - HTDriver
 * Driver for testing HashTable's functionality.
 * @author geoffwacker
 * @id gwacker
 * 11.16.15
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class HTDriver 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//Create a scanner for user keyboard input.
		Scanner in = new Scanner(System.in);
	
		//Get the input file name.
		System.out.println("Please enter the full name of the input file:");
		String input = in.nextLine();

		//Create a FileInputStream so we can read from the input file.
		FileInputStream inFile = new FileInputStream(input);
	
		//Create a scanner to go through the input file.
		Scanner inScan = new Scanner(inFile);
		
		//Grab the first integer to use as the number of elements in the collection.
		int n = inScan.nextInt();
		
		//Create a hash table with the integer size.
		HashTable table = new HashTable(n);
		
		//Create a scanner to go line by line through the input file.
		Scanner inLine;
		
		//Read n lines.
		for(int i = 0; i < n; i++)
		{
			//Get the line.
			inLine = new Scanner(inScan.nextLine());
			
			//Make sure it's a long.
			if (inLine.hasNextLong())
			{
				//Grab the ID.
				long tempId = inLine.nextLong();
				
				//Validity check.
				if (inLine.hasNext() && tempId > 0)
				{
					//Grab the name.
					String tempName = inLine.next();
					
					//Insert the student record into the table.
					if(!inLine.hasNext())
					{
						table.insert(new Student(tempId, tempName));
					}
				}
			}
		}
		
		//Variable declaration.
		char menuChoice = 'a';
			
		//Print out the menu once.
		System.out.println("Choose one of the following operations by entering provided letter: ");
		System.out.println("       a - add the element");
		System.out.println("       d - delete the element");
		System.out.println("       f - find and retrieve the element");
		System.out.println("       n - get the number of elements in the collection");
		System.out.println("       e - check if the collection is empty");
		System.out.println("       k - Make the hash table empty");
		System.out.println("       p - print the content of the hash table");
		System.out.println("       o - output the elements of the collection");
		System.out.println("       q - Quit the program");
		
		//Loop to ask for input.
		while(menuChoice != 'q')
		{
			//Ask for input.
			System.out.println("Please enter your menu choice:");
			
			//Get the input.
			menuChoice = in.nextLine().charAt(0);
		
			//Switch statement to handle input.
			switch(menuChoice)
			{
				//User wants to add an element to the hash table.
				case 'A':
				case 'a':
				{
					//Ask for input.
					System.out.println("Please enter the student's ID and last name (separated by spaces):");
					
					//Get the line.
					inLine = new Scanner(in.nextLine());
					
					//Make sure the ID is a long.
					if(inLine.hasNextLong())
					{
						long tempId = inLine.nextLong();
						
						//Make sure it's a valid ID and we have another element to read (last name).
						if (tempId > 0 && inLine.hasNext())
						{
							String tempName = inLine.next();
							
							//Make sure we don't have additional values on this line.
							if(inLine.hasNext())
							{
								System.out.println("Invalid input: too many values.");
							}
							
							//We have a valid record.
							else
							{
								//Create a temporary student to hold the line input.
								Student tempStudent = new Student(tempId, tempName);
								
								//Insert the student into the table.
								table.insert(tempStudent);
								
								//Print out confirmation.
								System.out.println(tempStudent.toString() + " was added.");
							}
						}
						
						//ID is not positive, or we don't have a name to read.
						else
						{
							System.out.println("Error: invalid input!");
						}
					}
					
					//No long was found.
					else
					{
						System.out.println("Invalid input. Please enter a valid long.");
					}

					break;
				}
				
				//User wants to delete a certain element from the hash table.
				case 'D':
				case 'd':
				{
					//Ask for input.
					System.out.println("Please enter a valid positive long ID to delete:");
					
					//Make sure we have a valid long.
					if(in.hasNextLong())
					{
						//Store the input.
						long tempId = in.nextLong();
						
						//Make sure it's positive.
						if(tempId > 0)
						{
							//If the ID is valid, create a dummy student.
							Student dummyStudent = new Student(tempId, "dummyStudent");
							
							//Delete the student.
							table.delete(dummyStudent);
							
							//Print out delete confirmation.
							System.out.println("Student ID " + tempId + " was deleted.");
						}
						
						//Long is not positive.
						else
						{
							System.out.println("Invalid input. Please enter a POSITIVE long.");
						}
					}
					
					//No valid long found.
					else
					{
						System.out.println("Invalid input. Please enter a valid long.");
					}
					
					//Advance the scanner.
					in.nextLine();
					break;
				}
				
				//User wants to find and retrieve a certain element from the hash table.
				case 'F':
				case 'f':
				{
					//Ask for input.
					System.out.println("Please enter the ID of the student you'd like to find:");
					
					//Make sure we have a valid long.
					if(in.hasNextLong())
					{
						//Store the input.
						long tempID = in.nextLong();
							
						//Make sure it's positive.
						if(tempID > 0)
						{
							//Create a dummy student.
							Student dummyStudent = new Student(tempID, "dummyStudent");
								
							//Create a student to hold the result of find.
							Student foundStudent = (Student) table.find(dummyStudent);
								
							//We have a valid student.
							if(foundStudent != null)
							{
								System.out.println(foundStudent.toString() + " was found!");
							}
								
							//We don't have a valid student.
							else
							{
								System.out.println("The ID " + tempID + " was NOT found!");
							}
						}
							
						//Long is not positive.
						else
						{
							System.out.println("Invalid input. Please enter a POSITIVE long.");
						}
               		}
		              
					//No valid long found.
					else
					{
						System.out.println("Invalid input");
					}
					
					//Advance the scanner.
					in.nextLine();
					break;
				}
				
				//User wants to get the number of elements in the collection.
				case 'N':
				case 'n':
				{
					System.out.println("The number of elements in the collection is: " + table.elementCount());
					break;
				}
				
				//User wants to check if the collection is empty.
				case 'E':
				case 'e':
				{
					//Table is empty.
					if(table.isEmpty())
					{
						System.out.println("The hash table is empty.");
					}
					
					//Table must not be empty.
					else
					{
						System.out.println("The hash table is NOT empty.");
					}
					
					break;
				}
				
				//User wants to make the hash table empty.
				case 'K':
				case 'k':
				{
					table.makeEmpty();
					System.out.println("The hash table is now empty!");
					break;
				}
				
				//User wants to print the contents of the table.
				case 'P':
				case 'p':
				{
					table.printTable();
					break;
				}
				
				//User wants to output the elements of the collection.
				case 'O':
				case 'o':
				{
					//Create an iterator to go through the table.
					Iterator printIter = table.iterator();
					
					//While the iterator still has another value, print out the next element.
					while(printIter.hasNext()) 
					{
						System.out.println(printIter.next());
					}
					
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
		
		//Close the scanners since we don't need them anymore.
		in.close();
		inScan.close();
	}
}