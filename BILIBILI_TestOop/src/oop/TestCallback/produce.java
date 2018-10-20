package oop.TestCallback;

public class produce {
	public static void MakeProduction(IProduct p){
		System.out.println("锤子");
		System.out.println("砍刀");
		System.out.println("剪刀");
		
		//擦拭
		p.cashi();
		System.out.println("开始工作！");
		System.out.println("工作完成！");
	}
	public static void main(String[] args) {
		MakeProduction(new Knife());
	}
}

/*class Hammer extends Product{
	public void cashi(){
		System.out.println("擦拭锤子！");
	}
}*/
//换成接口也可以
class Hammer implements IProduct{
	public void cashi(){
		System.out.println("擦拭锤子！");
	}
}
class Knife implements IProduct{
	public void cashi(){
		System.out.println("擦拭砍刀！");
	}

}