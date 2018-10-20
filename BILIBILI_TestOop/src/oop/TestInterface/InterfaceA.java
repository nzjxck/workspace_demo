package oop.TestInterface;
/**
 * 接口实现多继承
 * @author MXJ
 *
 */
public interface InterfaceA {
	void aaa();
}
interface interfaceB{
	void bbb();
}
interface interfaceC extends InterfaceA,interfaceB{
	void ccc();
}
class TestClass implements interfaceC{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ccc() {
		// TODO Auto-generated method stub
		
	}
	
}