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

				// print out the current line
				System.out.println( curLine );
			}
		}
	}
}