package oop.TestAbstract;

public abstract class Animal {
	//abstract方法必须存在于abstract类中
	public abstract void rua();
	//abstract相当于就是只声明不实现。
}
class Cat extends Animal{

	@Override
	public void rua() {
		System.out.println("猫步小跑");
		
	}
	//要继承sbstract父类，就必须实现父类的abstract方法
	//The type Cat must implement the inherited abstract method Animal.rua()
}