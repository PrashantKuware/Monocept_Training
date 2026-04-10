package assigment1.findFirst;

import java.util.Arrays;
import java.util.List;

public class Second {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(23,54,65,687,23,756,324,9);
		int firstEven = list.stream().filter(n -> n%2==0).findFirst().orElseThrow();
		System.out.println(firstEven);
	}

}
