package oop.TestPolymorphism;

public class Animal {
	int id;
	public void voice(){
		System.out.println("��ͨ�������");
	}
}
class Cat extends Animal{
	public void voice(){
		System.out.println("������~");
}
	public void catchmouse(){
		System.out.println("ץ����");
	}
}
class Dog extends Animal{
	public void voice(){
		System.out.println("������~");
	}
}
class Pig extends Animal{
	public void voice(){
		System.out.println("������~");
	}
}

