package assignment.predicate;

import java.util.function.Predicate;

public class oddNumberChecker {
    public static void main(String[] args) {

    	Predicate<Integer> isOdd = x -> x%2!=0;

        for (int i = 1; i < 11; i++) {
           if(isOdd.test(i))
           {
        	   System.out.println(i);
           }
        }
    }
}