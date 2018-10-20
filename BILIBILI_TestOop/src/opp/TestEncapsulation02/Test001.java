package opp.TestEncapsulation02;

import opp.TestEncapsulation01.Test01;

public class Test001 extends Test01 {
	public void laor(){
		super.print();
	}
	public static void main(String[] args) {
		Test001 t = new Test001();
		t.print();
	}
}
