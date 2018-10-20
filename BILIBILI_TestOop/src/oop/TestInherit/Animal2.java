package oop.TestInherit;
/**
 * 测试组合
 * @author MXJ
 *
 */
public class Animal2 {
		protected String eye;
		public void run() {
			System.out.println("跑~");
		}
		public void eat() {
			System.out.println("吃~");
		}
		public Animal2(){
			System.out.println("构造一个动物对象");
		}
		public static void main(String[] args) {
			Bird2 b = new Bird2();
			b.run();
		}
	}
	class Mammal2 {
		//在Mammal2里声明一个Anmial2类的对象就可以调用Animal2里的属性和方法。
		//在实现代码复用性的方面，组合可以和继承做到同样的效果。
		Animal2 animal2 = new Animal2();
		public void taisheng() {
			System.out.println("我是胎生的");
		}
	}
	class Bird2 extends Animal2{
		String eye;
		Animal2 animal2 = new Animal2();
		//当子类的方法和父类有区别的时候，可以进行方法重写（与重载没关系）
		public void run() {
			System.out.println("飞~");
		}
		public void eggSheng() {
			System.out.println("我是卵生的");
		}
		public Bird2(){
			System.out.println("创建一个鸟对象");
		}
	}

