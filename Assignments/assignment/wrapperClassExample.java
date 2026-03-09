import java.util.ArrayList;

public class wrapperClassExample {
    public static void main(String[] args) {
        // Autoboxing: primitive int value is automatically converted to an Integer object
        Integer numObj = 42; 
        
        // Unboxing: Integer object is automatically converted back to a primitive int value.
        int numPrimitive = numObj; 
        
        System.out.println("Integer object: " + numObj);
        System.out.println("Primitive int: " + numPrimitive);

        // Using wrapper classes with collections 
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(10); // Autoboxing happens here
        numberList.add(20); 

        // Accessing utility methods provided by the wrapper class
        int maxVal = Integer.max(numberList.get(0), numberList.get(1));
        System.out.println("Maximum value in list: " + maxVal);
        
        // Converting a String to an int using a utility method
        String strNum = "123";
        int parsedNum = Integer.parseInt(strNum); //
        System.out.println("Parsed int from string: " + parsedNum);
    }
}
