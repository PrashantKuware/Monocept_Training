package assigment1.AnyMatch;

import java.util.Arrays;
import java.util.List;

public class First {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(23,54,65,687,23,756,324,9);
		
		boolean ans = list.stream().anyMatch(n -> n%2==0);
		System.out.println(ans);

	}

}
