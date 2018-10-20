package opp.TestEncapsulation01;

public class Test02 {
	public static void main(String[] args) {
		//不能在Test02里调用Test01的方法
		Test01 t =new Test01();
		//The method print() from the type Test01 is not visible
		//上述这条报错是在private情况下
		//下面这条是在default情况下
		t.print();
	}
	
}
