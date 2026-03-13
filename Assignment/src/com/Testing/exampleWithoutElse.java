
public class exampleWithoutElse 
{

	private static boolean isPrime(int number)
	{
		if(number < 2)
		{
			System.out.println("Number should be greater than 1");
			return false;
		}
		for(int i=2;i*i<=number;i++)
		{
			if(number%i == 0)
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		int number = 2;
		if(isPrime(number))
		{
			System.out.println("Not Prime");
			return;
		}
		System.out.println(" Prime");
	}

}
