import java.io.FileNotFoundException;

/**
 * Author Chase Beckley
 * Student, contains the local variables we save for student and methods to be called by ScoreTrakker
 */

public class Student implements Comparable<Student> {
	
	private String _name;
	private int _score;
	
	public Student(String name, int score) {
		this._name = name;
		this._score = score;
	}

	/**
	 * Compares two students's scores
	 * 
	 * @param other - The other student to compare this to.
	 * @return 0 if equal, -1 if this < other, and 1 if this > other
	 */
	@Override
	public int compareTo(Student other) {
		if (other.equals(this)) return 0;               // equal       (0)
		else if (this._score < other._score) return -1; // this < other (-1)
		else return 1;                                  // this > other (1)
	}
	
	/**
	 * Print Students as a string
	 * 
	 * @return A string in the format of "{name} {score}"
	 */
	@Override
	public String toString() {
		return _name + " " + _score;
	}
	
	
}
