package String;

public class Student 
{
	private int[] marks = {100, 200, 300, 400,500};
	
	public int[] getMarks()
	{
		return marks.clone();
	}
}
