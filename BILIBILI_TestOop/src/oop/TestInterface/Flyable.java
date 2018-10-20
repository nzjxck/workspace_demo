package oop.TestInterface;

public interface Flyable {
	void fly();
}
interface Attack{
	void attack();
}
class Plane implements Flyable{

	@Override
	public void fly() {
		System.out.println("�ɻ����÷���������");
		
	}	
}
class Stone implements Flyable,Attack{

	@Override
	public void fly() {
		System.out.println("ʯͷ�����ӳ�ȥ������~");
		
	}

	@Override
	public void attack() {
		System.out.println("ʯͷ���ˣ�");
		
	}
	
}