package oop.TestInherit;

public class test {
	public static void main(String[] args) {
		Bird b = new Bird();
		b.eggSheng();
		b.toString();//之所以能调用tostring方法是因为Bird是Animal的子类，Animal是Object的子类，在Bird里找不到，去Animal类里找，还找不到去Object类里面找可以找到。
	}
}
