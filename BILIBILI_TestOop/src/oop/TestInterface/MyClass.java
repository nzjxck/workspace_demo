package oop.TestInterface;

public class MyClass implements Myinterface{

	@Override
	public void test01() {
		System.out.println("test01������~");
		
	}

	@Override
	public int test02(int a, int b) {
		System.out.println("test02��ʼ����");
		return a+b;
	}

}
