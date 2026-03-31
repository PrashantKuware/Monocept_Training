package assigment1.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class first {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,34,45,2,5,7,678,979,43,567,234,78,32,30);
		
		list.stream().sorted(Comparator.comparing())

	}

}
