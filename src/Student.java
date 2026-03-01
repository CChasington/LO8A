
public class Student implements Comparable<Student> {
	
	private String _name;
	private int _score;
	
	public Student(String name, int score) {
		this._name = name;
		this._score = score;
	}

	@Override
	public int compareTo(Student other) {
		if (other.equals(this)) return 0;               // equal       (0)
		else if (this._score < other._score) return -1; // this < other (-1)
		else return 1;                                  // this > other (1)
	}
	
	@Override
	public String toString() {
		return _name + " " + _score;
	}
	
	
}
