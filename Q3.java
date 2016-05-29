import java.util.Scanner;

public class Q3
{
	public static void main( String[] args )
	{
		// file I/O
		Scanner fileInput = new Scanner( System.in );

		// the number of tests to run
		int numCases = fileInput.nextInt();

		// each test needs this information to produce output
		int testCase;
		int numIntegers;
		int pivotValue;
		int[] original;
		int[] partitioned;
		int numPartitioned;
		int i; // for looping through stuff

		// run tests from 1 to the given number of cases
		for( testCase = 1; testCase <= numCases; testCase++ )
		{
			// get the number of integers, the pivot value, and create an array to store the integers and their partitioned order
			numIntegers = fileInput.nextInt();
			pivotValue = fileInput.nextInt();
			original = new int[numIntegers];
			partitioned = new int[numIntegers];

			// fill the array with the integers on the next line
			for( i = 0; i < numIntegers; i++ )
			{
				original[i] = fileInput.nextInt();
			}

			// partition the data by reading the original array in two passes, for each side of the pivot
			numPartitioned = 0;

			// first pass
			for( i = 0; i < numIntegers; i++ )
			{
				if( original[i] <= pivotValue )
				{
					partitioned[numPartitioned] = original[i];
					numPartitioned++;
				}
			}

			// second pass
			for( i = 0; i < numIntegers; i++ )
			{
				if( original[i] > pivotValue )
				{
					partitioned[numPartitioned] = original[i];
					numPartitioned++;
				}
			}

			// print the case number on the first line
			System.out.printf( "-CASE %d-\n", testCase );
			
			// print out the numbers less than or equal to the pivot value on the second line
			i = 0;
			while( i < partitioned.length && partitioned[i] <= pivotValue )
			{
				System.out.printf( "%d ", partitioned[i] );
				i++;
			}
			System.out.println();

			// print out the numbers greater than the pivot value on the third line
			while( i < partitioned.length )
			{
				System.out.printf( "%d ", partitioned[i] );
				i++;
			}
			System.out.println();
		}
	}
}