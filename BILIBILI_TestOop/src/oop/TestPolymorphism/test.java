package oop.TestPolymorphism;

public class test {
	public static void makevoice(Animal c){
		c.voice();
		//instanceof  如果c是Cat类
		if(c instanceof Cat){
			((Cat) c).catchmouse();
		}
	}
	public static void main(String[] args) {
		//父类的引用指向一个子类的对象
		//Animal c = new Cat();【2】
		//其实和Cat c = new Cat()【1】有区别
		//Cat类里独有的方法在【1】里可以用
		//但是在【2】的情况下，就需要强制类型转换成Cat类才能用Cat里面的方法。
		Animal c = new Cat();
		makevoice(c);
//		Cat c1 = (Cat)c;
//		c1.catchmouse();
	}
}
