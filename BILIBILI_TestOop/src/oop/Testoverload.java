package oop;
/**
 * ²âÊÔÖØÔØ
 * @author MXJ
 *
 */
public class Testoverload {
	public static void main(String[] args) {
		MyMath m = new MyMath();
		int result1 = m.add(1, 2);
		int result2 = m.add(1, 2, 3);
		System.out.println(result1);
		System.out.println(result2);
	}
}
class MyMath {
	public int add(int a,int b){
		return a+b;
	}
	public int add(double a,int b){
		return (int)(a+b);
	}
	public int add(int b,double a){
		return (int)(a+b);
	}
	public int add(int a,int b,int c) {
		return a+b+c;
	}
}
