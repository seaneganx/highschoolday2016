import java.util.Scanner;

public class Q2
{

	public static void main( String[] args )
	{
		// file I/O
		Scanner fileInput = new Scanner( System.in );
		
		// the number of tests to run
		int numCases = fileInput.nextInt();

		// each test needs this information to produce output
		int testCase;
		int collatzNumber;
		int curValue;
		int oddSteps;
		int evenSteps;

		// run tests from 1 to the given number of cases
		for( testCase = 1; testCase <= numCases; testCase++ )
		{
			// initialize our information for a new number
			collatzNumber = fileInput.nextInt();
			curValue = collatzNumber;
			oddSteps = 0;
			evenSteps = 0;

			// keep applying Collatz rules until we reach a value of one
			while( curValue != 1 )
			{
				// check if the value is even or odd and apply the appropriate Collatz rule
				if( curValue % 2 == 0 )
				{
					// the number is even
					curValue = curValue / 2;
					evenSteps++;
				}
				else
				{
					// the number is odd
					curValue = (3 * curValue) + 1;
					oddSteps++;
				}
			}

			// output the number of steps for this number
			System.out.printf( "%d. The number %d needs %d odd steps and %d even steps.\n", testCase, collatzNumber, oddSteps, evenSteps );
		}
	}
}