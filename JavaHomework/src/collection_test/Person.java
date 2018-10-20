package collection_test;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	private char gender;
	private double mathscore;
	private double cnscore;
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public Person(String name, int age, char gender, double mathscore, double cnscore) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mathscore = mathscore;
		this.cnscore = cnscore;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public double getMathscore() {
		return mathscore;
	}


	public void setMathscore(double mathscore) {
		this.mathscore = mathscore;
	}


	public double getCnscore() {
		return cnscore;
	}


	public void setCnscore(double cnscore) {
		this.cnscore = cnscore;
	}

	
	@Override
	public String toString() {
		return "���� "+name + "| ���� " + age + "| �Ա� " + gender + "| ��ѧ�ɼ� " + mathscore
				+ "| ���ĳɼ� " + cnscore;
	}


	@Override
	public int compareTo(Person o) {
		return name.compareTo(o.name);
}
}