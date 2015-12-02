/**
 * Lab 16 - DiGraphAM
 * Directed graph implementation using adjacency matrix.
 * @author geoffwacker
 * @id gwacker
 * 12.01.15
 */

public class DiGraphAM 
{
	//Instance variable for the adjacency table.
	private int[][] adjTable;

	//Constructor to set the adjacency table to size NxN.
	public DiGraphAM(int n)
	{
		adjTable = new int[n][n];
	}
	
	/**
	 * Register the given edge in the adjacency table.
	 * @param from the vertex we're starting at.
	 * @param to the vertex we're going to.
	 */
	public void addEdge(int from, int to)
	{
		adjTable[from][to]=1;
	}
	
	/**
	 * Delete the given edge from the adjacency table.
	 * @param from the vertex we're starting at.
	 * @param to the vertex we're going to.
	 */
	public void deleteEdge(int from, int to)
	{
		adjTable[from][to]=0;
	}
	
	/**
	 * Return the number of edges in the graph.
	 * @return the number of edges in the graph.
	 */
	public int edgeCount()
	{
		//Store the number of edges.
		int numEdges = 0;
		
		//Outer loop through the graph.
		for(int i = 0; i < adjTable.length; i++)
		{
			//Inner loop through the graph.
			for(int j = 0; j < adjTable[i].length; j++)
        	{
				numEdges += adjTable[i][j];
        	}
		}
		
		//Return the total number of edges.
		return numEdges;
	}
	
	/**
	 * Return the number of vertices in the graph.
	 * @return the number of vertices in the graph (the array length).
	 */
	public int vertexCount()
	{
		return adjTable.length;
	}
	
	/**
	 * Print the contents of the graph.
	 */
	public void print()
	{
		//Outer loop through the graph.
		for(int i = 0; i < adjTable.length; i++)
		{
			//Print out the "from" vertices.
			System.out.print("" + i + " is connected to: ");
	         
			//Inner loop through the graph.
			for(int j = 0; j < adjTable.length; j++)
			{
				//We've found a connected vertex, so print it on the same line.
				if(adjTable[i][j] == 1)
	            {
	               System.out.print(j + " ");  
	            }
	         }
	         
	         //Print out a line for spacing.
	         System.out.println();
	      }
	}
	
	/**
	 * Return an array of integers representing the indegrees of all vertices in the graph.
	 * @return array of integers representing the indegrees of all vertices in the graph.
	 */
	private int[] indegrees()
	{
		//Create an integer array to store the indegrees.
		int[] inArr = new int[adjTable.length];
		
		//Outer loop through the graph.
		for(int i = 0; i < adjTable.length; i++)
		{
			//Inner loop through the graph.
			for(int j = 0; j < adjTable.length; j++)
			{
				//We've found an indegree, so add it to the array.
				if(adjTable[i][j] == 1)
				{
					inArr[j]++;
	            }
			}
		}
      
		//Return the array.
		return inArr;
	}
	
	/**
	 * Sort the graph topologically using LQueue.
	 * @return an array of topologically sorted vertices.
	 */
	public int[] topSort()
	{
		//Grab the array of indegrees.
		int[] indArr = indegrees();
		
		//Create an array to store the topologically sorted vertices.
		int[] topArr = new int[adjTable.length];
		
		//Create an LQueue of the vertices.
		LQueue<Integer> vertices = new LQueue<Integer>();
	      
		//Create a counter to keep track of the number of vertices we add to topArr.
		int counter = 0;
	      
		//Add the vertices to the LQueue.
		for(int i = 0; i < adjTable.length; i++)
		{
			if(indArr[i] == 0)
			{
				vertices.enqueue(i);
			}
		}
	      
		//While we still have vertices to go through.
		while(!vertices.isEmpty())
		{
			//Dequeue a vertex.
			int v = vertices.dequeue();
			
			//Put it in our sorted array.
			topArr[counter] = v;
			
			//Increment the counter.
			counter++;
			
			//Loop through the table.
			for(int i = 0; i < adjTable.length; i++)
			{
				if(adjTable[v][i] == 1)
	            {
					indArr[i]--;
					
					//Add the vertex to the LQueue.
					if(indArr[i] == 0)
					{
						vertices.enqueue(i);
					}
	            }
			}
		}
	      
		//We've got a cyclic graph, so throw an exception.
		if(counter != adjTable.length)
		{
			throw new RuntimeException();
		}
		
		//Return the topologically sorted array.
		return topArr;
	}
}