package oop.TestAbstract;

public abstract class Animal {
	//abstract�������������abstract����
	public abstract void rua();
	//abstract�൱�ھ���ֻ������ʵ�֡�
}
class Cat extends Animal{

	@Override
	public void rua() {
		System.out.println("è��С��");
		
	}
	//Ҫ�̳�sbstract���࣬�ͱ���ʵ�ָ����abstract����
	//The type Cat must implement the inherited abstract method Animal.rua()
}