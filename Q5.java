import java.util.Scanner;
import java.util.HashSet;

public class Q5
{
	public static void main( String[] args )
	{
		// file I/O
		Scanner fileInput = new Scanner( System.in );

		// the number of tests to run
		int numCases = fileInput.nextInt();

		// each test needs this information to produce output
		int testCase;
		int xCardinality;
		int yCardinality;
		HashSet<Integer> x;
		HashSet<Integer> y;
		HashSet<Integer> intersect;
		HashSet<Integer> union;
		int i; // for looping through stuff

		// run tests from 1 to the given number of cases
		for( testCase = 1; testCase <= numCases; testCase++ )
		{
			// read in the sizes of each set
			xCardinality = fileInput.nextInt();
			yCardinality = fileInput.nextInt();

			// create the sets to store values in
			x = new HashSet<Integer>();
			y = new HashSet<Integer>();
			intersect = new HashSet<Integer>();
			union = new HashSet<Integer>();

			// populate the main sets
			for( i = 0; i < xCardinality; i++ )
			{
				x.add( fileInput.nextInt() );
			}
			for( i = 0; i < yCardinality; i++ )
			{
				y.add( fileInput.nextInt() );
			}

			// calculate the intersection of x and y
			// start by adding all the values of x into the set, then remove any items that weren't included in y
			intersect.addAll( x );
			intersect.retainAll( y );

			// calculate the union of x and y
			// start by adding all the values of x into the set, then add all the values of y in too (recall, sets only keep one copy of duplicates)
			union.addAll( x );
			union.addAll( y );
			
			// print the jaccard index to one decimal place
			System.out.printf( "%d. Jaccard Index: %.1f\n", testCase, (double)intersect.size() / union.size() );
		}
	}
}