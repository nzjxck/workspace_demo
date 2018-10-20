package oop.TestInherit;
/**
 * 测试继承
 * @author MXJ
 *
 */

public class Animal {
	String eye;
	public void run() {
		System.out.println("跑~");
	}
	public void eat() {
		System.out.println("吃~");
	}
	public Animal(){
		super();
		System.out.println("构造一个动物对象");
	}
}
class Mammal extends Animal{
	//extends可以让Mammal继承Animal
	public void taisheng() {
		System.out.println("我是胎生的");
	}
}
class Bird extends Animal{
	String eye;
	//当子类的方法和父类有区别的时候，可以进行方法重写（与重载没关系）
	public void run() {
		System.out.println("飞~");
	}
	public void eggSheng() {
		System.out.println("我是卵生的");
	}
	public Bird(){
		super();
		System.out.println("创建一个鸟对象");
	}
}