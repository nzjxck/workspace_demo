package oop.TestStatic;

public class Student {
//静态的数据（属性）
	int ID;
	String name;
	
	static int ss;
	
	public static void printss(){
		//静态方法里不能调用非静态变量
		//如name = "laotie";
		//ss = 20;
		System.out.println(ss);
	}
	
//动态的行为（方法）
	public void Study(){
		//在非静态方法中可以调用静态方法及变量，如下
		//printss();
		//ss = 20;
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
