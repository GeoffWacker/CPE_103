/**
 * Project 04 - Student
 * Class to represent a student record.
 * @author geoffwacker
 * @id gwacker
 * 11.16.15
 */

public class Student 
{
	//Instance variables.
	private long id;
	private String lastName;
	
	//Constructor.
	public Student(long id, String lastName)
	{
		this.id = id;
		this.lastName = lastName;
	}

	/**
	 * Determine if the two IDs we're comparing are the same.
	 * @return true if the id of this object is the same as the id of the other object.
	 */
	public boolean equals(Object other)
	{
		return this.id == ((Student)other).id;
	}
	
	/**
	 * Return a string containing the id and the name of the student.
	 */
	public String toString()
	{
		return ("{ id: " + id + ", name: " + lastName + " }");
	}
	
	/**
	 * Return the hash code of the key of this object.
	 */
	public int hashCode()
	{
		return new Long(id).hashCode();	
	}
}