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
		System.out.println("飞机利用发动机飞行");
		
	}	
}
class Stone implements Flyable,Attack{

	@Override
	public void fly() {
		System.out.println("石头被人扔出去，飞行~");
		
	}

	@Override
	public void attack() {
		System.out.println("石头砸人！");
		
	}
	
}