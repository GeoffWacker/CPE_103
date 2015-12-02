/**
 * Lab 16 - DiGraphTest
 * Client/driver for Lab 16.
 * @author geoffwacker
 * @id gwacker
 * 12.01.15
 */

import java.util.Scanner;

public class DiGraphTest 
{
	public static void main(String[] args)
	{
		//Variable declaration.
		char input = 'a';
			
		//Create a scanner to get input.
		Scanner in = new Scanner(System.in);
		
		//Prompt for the number of vertices.
		System.out.println("Please enter the number of vertices: ");
		int n = in.nextInt();
		
		//Advance the scanner.
		in.nextLine();
		
		//Create a graph to work with.
		DiGraphAM diGraph = new DiGraphAM(n);
			
		//Print out the menu once.
		System.out.println("Choose one of the following operations by entering provided letter: ");
		System.out.println("       a - add edge");
		System.out.println("       d - delete edge");
		System.out.println("       e - edge count");
		System.out.println("       v - vertex count");
		System.out.println("       p - print");
		System.out.println("       t - topological sort");
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
				//User wants to add an edge to the directed graph.
				case 'A':
				case 'a':
				{
					//Prompt for the edge to add.
					System.out.println("Please enter the vertices (x,y) of the edge you'd like to add:");
					
					//Get the vertices.
					int x = in.nextInt();
					int y = in.nextInt();
						
					//Insert into the directed graph.
					diGraph.addEdge(x, y);
					
					//Print insert confirmation.
					System.out.println("Edge (" + x + ", " + y + ") was added!");

					//Advance the scanner.
					in.nextLine();
					break;
				}
				
				//User wants to delete an edge from the directed graph.
				case 'D':
				case 'd':
				{
					//Prompt for the edge to delete.
					System.out.println("Please enter the vertices (x,y) of the edge you'd like to delete:");
					
					//Get the vertices.
					int x = in.nextInt();
					int y = in.nextInt();
						
					//Insert into the directed graph.
					diGraph.deleteEdge(x, y);
					
					//Print delete confirmation.
					System.out.println("Edge (" + x + ", " + y + ") was deleted!");
					
					//Advance the scanner.
					in.nextLine();
					break;
				}
				
				//User want to get the number of edges in the directed graph.
				case 'E':
				case 'e':
				{
					//Print out the result.
					System.out.println("The number of edges is: " + diGraph.edgeCount());
					break;
				}
				
				//User want to get the number of vertices in the directed graph.
				case 'V':
				case 'v':
				{
					//Print out the result.
					System.out.println("The number of vertices is: " + diGraph.vertexCount());
					break;
				}
				
				//User want to print the contents of the directed graph.
				case 'P':
				case 'p':
				{
					//Print out print confirmation.
					System.out.println("The contents of the adjacency table of the graph is the following:");
					
					//Call the print method.
					diGraph.print();
					break;
				}
				
				//User want to get the topological sorting of the graph.
				case 'T':
				case 't':
				{
					try
					{
						//Print out sort confirmation.
						System.out.println("The topological sorting of the graph is the following:");
					
						//Call the topological sort method.
						int topSortArray[] = diGraph.topSort();
					
						//Print out the sorted array on one line.
						for(int i=0; i < topSortArray.length; i++)
						{
							System.out.print(topSortArray[i] + " ");
						}
						
						//Print out a line for spacing.
						System.out.println();
					}
					
					//The graph is cyclic, so print an error message.
					catch(RuntimeException e)
					{
						System.out.println("Can't do topological sort - the graph is cyclic");
					}
					
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