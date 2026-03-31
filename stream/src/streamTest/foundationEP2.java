package streamTest;

import java.util.Arrays;

class foundationEP2
{
    public static void main(String[] args)
    {
         Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  
         
       //  wronge
//         numbers.stream().forEach(num -> System.out.println(num));
       
       //right
       Arrays.stream(numbers).filter(n -> n>5).map(num -> {switch(num)
    		   {
       case 1: return "one";
       case 2: return "two";
       case 3: return "three";
       case 4: return "four";
       case 5: return "five";
       case 6: return "six";
       case 7: return "seven";
       case 8: return "eight";
       case 9: return "nine";
       case 0: return "zero";
    		   }
       return "Related number not available";
       }).
       forEach(num -> System.out.println(" "+num));
       
       
    }
}