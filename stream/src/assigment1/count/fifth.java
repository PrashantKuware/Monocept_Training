package assigment1.count;

import java.util.Arrays;
import java.util.List;

public class fifth {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Raman", "Aman", "Sohan", "arti", "Asus", "Laptop");
		long count = list.stream().map(s -> s.toUpperCase()).filter(n -> n.startsWith("A")).count();
		
		System.out.println("Word start with A : "+count);
	}

}
