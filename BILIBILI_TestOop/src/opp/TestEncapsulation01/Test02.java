package opp.TestEncapsulation01;

public class Test02 {
	public static void main(String[] args) {
		//������Test02�����Test01�ķ���
		Test01 t =new Test01();
		//The method print() from the type Test01 is not visible
		//����������������private�����
		//������������default�����
		t.print();
	}
	
}
