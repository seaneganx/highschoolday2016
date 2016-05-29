import java.util.Scanner;
import java.util.Vector;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class Q6
{
	public static void main( String[] args )
	{
		// file I/O
		Scanner fileInput = new Scanner( System.in );

		// the number of tests to run
		int numCases = fileInput.nextInt();

		// each test needs this information to produce output
		int testCase;

		// graph information
		Vector<HashSet<Integer>> matrix; // adjacency matrix for the graph
		int locations; // number of vertices on the graph
		int runs; // number of edges on the graph
		int origVertex; // when we're generating the graph we need to know where an edge starts (which location is the person at?)
		int destVertex; // when we're generating the graph we need to know where an edge ends (which location can the person get to from this location?)

		// search information
		LinkedList<Integer> searchQueue; // which locations are we going to be looking from and in what order?
		boolean[] visited; // which locations have been visited so far?
		int curLocation; // which location are we currently at in the search?
		Iterator<Integer> neighbours; // a way to iterate through each neighbour to the current location
		int curNeighbour; // temporary place to hold neighbouring locations while we check if they're visited already and add them to the queue if they haven't been visited

		// other information
		int i; // for looping through stuff
		boolean allVisited;

		// run tests from 1 to the given number of cases
		for( testCase = 1; testCase <= numCases; testCase++ )
		{
			System.out.printf( "CASE %d: ", testCase );
			
			locations = fileInput.nextInt();
			runs = fileInput.nextInt();

			// initialize the adjacency matrix
			// the vector contains a set for each location in the resort
			// the set for a location contains integers representing which OTHER locations can be reached from the current location 
			// e.g. the adjacency matrix for the diagram in the problem booklet looks like this:
			/*
			 * 0: { 1 }
			 * 1: { 3 }
			 * 2: { 0, 3 }
			 * 3: { 2, 4 }
			 * 4: {  }
			 */
			matrix = new Vector<HashSet<Integer>>(locations);

			// create a set at each index in the vector to store neighbouring vertices
			for( i = 0; i < locations; i++ )
			{
				matrix.add( i, new HashSet<Integer>() );
			}

			// store every edge in the adjacency matrix
			for( i = 0; i < runs; i++ )
			{
				// read in the start/end vertices as input
				origVertex = fileInput.nextInt();
				destVertex = fileInput.nextInt();

				// add that edge into the adjacency matrix but REVERSE THE DIRECTION
				// reversing the direction allows us to perform a single search starting at the lodge, and following every graph edge possible until we run out of locations that haven't been visited
				// when we're done the search the only places that will be left unvisited during the search are places that we were able to get to starting at the lodge, but not get back from
				matrix.get( destVertex ).add( origVertex );
			}

			// perform a breadth first search on the graph
			searchQueue = new LinkedList<Integer>(); // a queue is necessary for a breadth first search
			visited = new boolean[locations]; // create a way of marking which locations we've visited

			// start the search at the lodge
			searchQueue.addLast(0);
			visited[0] = true;

			// keep searching until we run out of unvisited locations
			while( !searchQueue.isEmpty() )
			{
				// get the next location to search around from the queue
				curLocation = searchQueue.removeFirst();

				// iterate through all the neighbours to the current node
				neighbours = matrix.get( curLocation ).iterator();
				while( neighbours.hasNext() )
				{
					curNeighbour = neighbours.next();

					// if the neighbour hasn't been visted add it to the queue and mark it as visited
					if( !visited[curNeighbour] )
					{
						searchQueue.addLast(curNeighbour);
						visited[curNeighbour] = true;
					}
				}
			}

			// check if any location at the resort hasn't been visited in the search
			// recall, any locations unvisited in the search have no way of reaching the lodge
			allVisited = true;
			for( i = 0; i < locations; i++ )
			{
				// if we already found a location that wasn't visited during the search, we never go back to say that every location was visited
				allVisited = allVisited && visited[i];
				
				// if( !visited[i] ) System.out.print( i + " " ); // if you want to see which locations left people stranded you can uncomment this line
			}

			// print out whether or not people can end up stranded for this test case
			if( allVisited )
			{
				System.out.println( "home safe" );
			}
			else
			{
				System.out.println( "stranded" );
			}
		}
	}
}