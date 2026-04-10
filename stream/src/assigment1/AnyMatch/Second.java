package assigment1.AnyMatch;

import java.util.Arrays;
import java.util.List;

public class Second {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Karan", "Aanish", "Lala", "Ganedsash");
		
		Object ans = list.stream().anyMatch(a->a.startsWith("A"));
		System.out.println(ans);
	}

}
