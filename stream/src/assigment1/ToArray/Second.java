package assigment1.ToArray;

import java.util.Arrays;

public class Second {

	public static void main(String[] args) {
		int[] arr = {23,54,65,687,23,756,324,9};
		
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);

	}

}
