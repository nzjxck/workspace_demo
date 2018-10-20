package oop;

public class Student {
//静态的数据（属性）
	int ID;
	String name;
	int age;
	String sex;
	int weight;
//动态的行为（方法）
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
