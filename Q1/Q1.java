public class Q1
{

	public static void main( String[] args )
	{
		for( int age = 18; age <= 81; age++ )
		{
			System.out.printf( "If you are %d you can retire at age %d\n", age, getMagic80(age) );
		}
	}

	public static int getMagic80( int startAge )
	{
		// The number of years it takes before the employee reaches their magic 80 can be calculated by solving the following equation
		// ( workYears + startAge ) + workYears = 80
		// workYears = ( 80 - startAge ) / 2

		// the number of years can include a half year so we want to store it as a double
		// if the person is over 80 years old this solves to a negative value, which should be changed to zero.
		double workYears = Math.max( 0, (80.0 - startAge) / 2 );

		// Because half years don't count, we have to finish any half years of employment and end up with a score slightly higher than 80
		// Add the number of years of service together with their age when they start to obtain the age of retirement
		return startAge + (int)Math.ceil(workYears);
	}
}