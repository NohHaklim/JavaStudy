package _01;

public class Student {
	private String name;
	private String sid;

	public Student(String name, String sid) {
		super();
		this.name = name;
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
}
