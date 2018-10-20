package opp.TestEncapsulation02;

import opp.TestEncapsulation01.Test01;

public class Test03 {
	public static void main(String[] args) {
		Test01 t = new Test01();
		//在使用default类型的时候会报错
		//The method print() from the type Test01 is not visible
		//t.print();
	}
}
