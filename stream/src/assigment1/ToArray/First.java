package assigment1.ToArray;

import java.util.Arrays;
import java.util.List;

public class First {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Karan", "Manish", "Lala", "Ganedsash");
		String[] array = list.stream()
                .toArray(String[]::new);

System.out.println(Arrays.toString(array));

	}

}
