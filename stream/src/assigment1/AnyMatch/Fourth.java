package assigment1.AnyMatch;

import java.util.Arrays;
import java.util.List;

public class Fourth {

	public static void main(String[] args) {
		 List<String> words = Arrays.asList("java", "SpRING", "boot", "ApI");

	        boolean hasUpperCaseWord = words.stream()
	                                        .anyMatch(word -> word.equals(word.toUpperCase()));

	        System.out.println( hasUpperCaseWord);
	}

}
