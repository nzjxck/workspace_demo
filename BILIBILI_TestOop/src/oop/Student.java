package oop;

public class Student {
//��̬�����ݣ����ԣ�
	int ID;
	String name;
	int age;
	String sex;
	int weight;
//��̬����Ϊ��������
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
