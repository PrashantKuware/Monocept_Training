package assigment1.ToArray;

import java.util.Arrays;

public class Third {

	public static void main(String[] args) {
		
		String[] arr = {"Karan", "Manish", "Lala", "Ganedsash"};
		
		Arrays.stream(arr).map(n -> n.toUpperCase()).forEach(a -> System.out.println(a));

	}

}
