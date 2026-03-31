package assigment1.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class second {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,34,45,2,5,7,678,979,43,567,234,78,32,30);
		
		List<Double> squreList = list.stream().map(n-> Math.pow(n, 2)).collect(Collectors.toList());
		System.out.println(squreList);

	}

}
