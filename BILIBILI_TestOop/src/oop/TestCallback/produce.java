package oop.TestCallback;

public class produce {
	public static void MakeProduction(IProduct p){
		System.out.println("����");
		System.out.println("����");
		System.out.println("����");
		
		//����
		p.cashi();
		System.out.println("��ʼ������");
		System.out.println("������ɣ�");
	}
	public static void main(String[] args) {
		MakeProduction(new Knife());
	}
}

/*class Hammer extends Product{
	public void cashi(){
		System.out.println("���ô��ӣ�");
	}
}*/
//���ɽӿ�Ҳ����
class Hammer implements IProduct{
	public void cashi(){
		System.out.println("���ô��ӣ�");
	}
}
class Knife implements IProduct{
	public void cashi(){
		System.out.println("���ÿ�����");
	}

}