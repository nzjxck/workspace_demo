package oop.TestStatic;

public class Student {
//��̬�����ݣ����ԣ�
	int ID;
	String name;
	
	static int ss;
	
	public static void printss(){
		//��̬�����ﲻ�ܵ��÷Ǿ�̬����
		//��name = "laotie";
		//ss = 20;
		System.out.println(ss);
	}
	
//��̬����Ϊ��������
	public void Study(){
		//�ڷǾ�̬�����п��Ե��þ�̬����������������
		//printss();
		//ss = 20;
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
