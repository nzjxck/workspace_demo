package opp.TestEncapsulation01;

public class Man {
	//一般来说，类中的成员变量一般用private
	//而常量以及静态变量使用public
	private String name;
	private int id;
	private boolean man;
	public static int ak;
	//私有变量无法在本类外直接用对象.变量
	//所以额外添加方法对这个变量进行操作，即提供了操作接口
	//见Test01里调用setName方法来对这个Man类的name属性进行操作。
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//对于boolean类型变量的get是is。
	public boolean isMan() {
		return man;
	}
	public void setMan(boolean man) {
		this.man = man;
	}
	
}
