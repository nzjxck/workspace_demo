package oop.TestInnerClass;

import oop.TestInnerClass.Face.Ear;

public class Outer {
	public static void main(String[] args) {
		Face.Nose n = new Face().new Nose();
		//换种写法
		/*Face f = new Face();
		Nose m = f.new Nose();*/
		n.breath();
		Face.Ear e = new Ear();
		e.listen();
		

	}
}
class Face{
	int type;
	class Nose{
		String type;
		//static从属于类，类是非静态类，所以内部不能使用静态方法
		/*static */void breath(){
/*			单独打印type是null，也就是内部的this.type，要访问外部的type要在外面标上类Face。*/
			System.out.println(Face.this.type);
			System.out.println("呼吸");
		}
	}
	static class Ear{
		void listen(){
			System.out.println("听");
		}
	}
}