package assignment.string_utility.model;

public class StringVarify 
{
	public boolean isEmptycheck(String str)
	{
		return str == null ||str.isEmpty();
	}
	public String toUpperCase(String str)
	{
		if(str == null) return null;
		return str.toUpperCase();
	}
	public Integer getLength(String str)
	{
		if(str == null) return null;
		return str.length();
	}

}
