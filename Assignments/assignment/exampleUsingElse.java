
public class exampleUsingElse {

	public static void main(String[] args) {
		int number = 87;
		for(int i=2;i*i<=number;i++)
		{
			if(number%i == 0)
			{
				System.out.println("Given number is not Prime");
				break;
			}
			else
			{
				System.out.println("Given number is Prime");
				break;
			}
		}

	}

}
