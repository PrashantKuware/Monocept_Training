package assignment.array_reverse.model;

public class ReverseArrayClass 
{
	public int[] reverseArray(int[] arr)
	{
		if (arr == null) {
	        throw new IllegalArgumentException("Array cannot be null");
	    }
		
		int end= arr.length-1;
		int start = 0;
		int temp;
		while(start < end)
		{
			
			temp=arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
			
		}
		return arr;
	}
}
