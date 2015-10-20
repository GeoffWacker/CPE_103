/**
 * Project 02 - Student
 * @author geoffwacker, kevinliu
 * 10.19.15
 */

public class Student implements Comparable<Student>
{
	//Instance variables.
	private long id;
	private String lastName;
	
	//Construct a student with an ID and a last name.
	public Student(long id, String lastName)
	{
		this.id = id;
		this.lastName = lastName;
	}

	/**
	 * Implements the Comparable interface.
	 * @param other the other student to compare against.
	 * @return -1, 1, or 0.
	 */
	public int compareTo(Student other)
	{
		//See if *this* student has a smaller id than the the other student.
		if(this.id < other.id)
		{
			return -1;
		}
		
		//See if *this* student has a greater id than the other student.
		else if(this.id > other.id)
		{
			return 1;
		}
		
		//The IDs are the same.
		else 
		{
			return 0; 
		}
	}
	
	/**
	 * Returns a string containing the id and the last name of *this* student.
	 * @return a string with the id and last name.
	 */
	public String toString()
	{
		return ("{ id: " + id + ", name: " + lastName+ " }");
	}
}