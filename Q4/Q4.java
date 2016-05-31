import java.util.Scanner;
import java.lang.StringBuilder;

public class Q4
{
	public static void main( String[] args )
	{
		// file I/O
		Scanner fileInput = new Scanner( System.in );

		// the number of tests to run
		int numCases = fileInput.nextInt();

		// each test needs this information to produce output
		int testCase;
		int width;
		int height;
		String curLine;
		int i; // for looping through stuff
		int j; // reversing the string
		char[] lineArray; // the current line represented as a char array so we can switch characters
		char temp; // temporary storage for the character swap

		// run tests from 1 to the given number of cases
		for( testCase = 1; testCase <= numCases; testCase++ )
		{
			// print out the case number
			System.out.println( testCase );

			width = fileInput.nextInt();
			height = fileInput.nextInt();

			// note that the buffer still contains the newline character from the width and height tokens (we have to clear that newline character before reading the next line)
			fileInput.nextLine();

			for( i = 0; i < height; i++ )
			{
				// read the current line of characters
				curLine = fileInput.nextLine();

				// reverse the current line
				// java library calls can be convenient if you can find them during the competition
				curLine = new StringBuilder(curLine).reverse().toString();

				/* // using loops and a character array instead of a library call. Notice how difficult and time consuming this can be in the competition (find libraries if you can)
				lineArray = curLine.toCharArray();

				// dividing the size of the string by two always results in us stopping before the "middle" of the string (even/odd lengths have a different idea of "middle")
				for( j = 0; j < lineArray.length / 2; j++ )
				{
					// save the left side character so we can swap it with its pair at the other end of the string
					temp = lineArray[j];

					// put the right side character into the left side spot
					lineArray[j] = lineArray[ lineArray.length - j - 1 ];

					// put the left side character we saved into the right side spot
					lineArray[ lineArray.length - j - 1 ] = temp;
				}

				// replace the current line we read in with the array of the reversed characters
				curLine = "";
				for( j = 0; j < lineArray.length; j++ )
				{
					curLine += lineArray[j];
				} */

				// print out the current line
				System.out.println( curLine );
			}
		}
	}
}