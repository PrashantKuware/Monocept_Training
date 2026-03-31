package assigment1.filter;

import java.util.Arrays;
import java.util.List;

public class fourth 
{

	public static void main(String[] args) 
	{
		List<String> list = Arrays.asList("Raman", "Aman", "", "arti", "Asus", null);
		
		list.stream().filter(s -> s != null && !s.trim().isEmpty()).forEach(n->System.out.println(n));

	}

}
