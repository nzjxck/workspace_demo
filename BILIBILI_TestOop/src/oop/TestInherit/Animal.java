package oop.TestInherit;
/**
 * ���Լ̳�
 * @author MXJ
 *
 */

public class Animal {
	String eye;
	public void run() {
		System.out.println("��~");
	}
	public void eat() {
		System.out.println("��~");
	}
	public Animal(){
		super();
		System.out.println("����һ���������");
	}
}
class Mammal extends Animal{
	//extends������Mammal�̳�Animal
	public void taisheng() {
		System.out.println("����̥����");
	}
}
class Bird extends Animal{
	String eye;
	//������ķ����͸����������ʱ�򣬿��Խ��з�����д��������û��ϵ��
	public void run() {
		System.out.println("��~");
	}
	public void eggSheng() {
		System.out.println("����������");
	}
	public Bird(){
		super();
		System.out.println("����һ�������");
	}
}