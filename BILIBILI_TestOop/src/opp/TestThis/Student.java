package opp.TestThis;

public class Student {
	int ID;
	String name;
	
	public Student (String name,int id) {
		//ǰ���name�����е����ԣ������name�ǹ������еĲ���name
		this();//������������ڹ������ĵ�һ��������䡣Constructor call must be the first statement in a constructor
		this.name = name;
	}
	public Student(){
		System.out.println("����һ������");
	}

	public void Study(){
		System.out.println(name+"����ѧϰjava�������");
	}
	public void sayHello(String sname) {
		System.out.println(name+"��"+sname+"���к�");
	}
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.name = "����";
		s1.Study();
		s1.sayHello("����");
	}
}
