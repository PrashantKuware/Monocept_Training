package streamTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToCollectionExample {

	public static void main(String[] args) {
		
		// Not specific
		List<Integer> list = Stream.of(1,2,3)
			    .collect(Collectors.toList());
		
		//Specific collection
		List<Integer> list1 = Stream.of(1,2,3)
			    .collect(Collectors.toCollection(ArrayList::new));
		
		LinkedList<String> list3 = Stream.of("A", "B")
			    .collect(Collectors.toCollection(LinkedList::new));
		
	}

}
