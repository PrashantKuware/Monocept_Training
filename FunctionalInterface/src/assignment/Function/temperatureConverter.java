package assignment.Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class temperatureConverter 
{

	public static void main(String[] args) 
	{
		List<Double> temp = Arrays.asList(0.0, 20.0, 37.5);
		Function<Double, Double> getTemp = C -> ((C *(9.0/5)) + 32);
		
		for(Double N : temp)
		{
			System.out.println("Converted temperature in Fenenheit : "+getTemp.apply(N));
		}
		
		temp.stream().forEach(cels -> System.out.println(getTemp.apply(cels)));
	}

}
