
package com.exceptionHandling.testing;

class stringNames {
	public static void main(String[] args) {

		StringBuilder sb = new Stringbuilder();

		String[] names = { "Amit", null, "Priya", "Sneha", null, "Vikram", "Neha", null, "Rohit", "Anjali", "Karan",
				null, "Pooja", "Suresh", null, "Meena", "Arjun", null, "Kavita", "Nikhil", null, "Swati", "Manish",
				"Deepika", null, "Ajay", "Sunita", null, "Rajesh", "Komal", "Vivek", null, "Ritu", "Ankit", null,
				"Shreya", "Harish", null, "Divya", "Gaurav", null, "Preeti", "Sanjay", null, "Nisha", "Yash", null,
				"Payal", "Tarun", null };

		for (int i = 0; i < names.length(); i++) {
			sb.append(" " + names[i]);
		}

		System.out.println(sb);
	}

}
