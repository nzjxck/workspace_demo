package opp.TestThis;

public class Student {
	int ID;
	String name;
	
	public Student (String name,int id) {
		//前面的name是类中的属性，后面的name是构造器中的参数name
		this();//构造器必须放在构造器的第一个陈述语句。Constructor call must be the first statement in a constructor
		this.name = name;
	}
	public Student(){
		System.out.println("构造一个对象");
	}

	public void Study(){
		System.out.println(name+"正在学习java面向对象");
	}
	public void sayHello(String sname) {
		System.out.println(name+"向"+sname+"打招呼");
	}
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.name = "老铁";
		s1.Study();
		s1.sayHello("老王");
	}
}
