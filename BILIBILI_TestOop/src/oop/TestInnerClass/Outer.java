package oop.TestInnerClass;

import oop.TestInnerClass.Face.Ear;

public class Outer {
	public static void main(String[] args) {
		Face.Nose n = new Face().new Nose();
		//����д��
		/*Face f = new Face();
		Nose m = f.new Nose();*/
		n.breath();
		Face.Ear e = new Ear();
		e.listen();
		

	}
}
class Face{
	int type;
	class Nose{
		String type;
		//static�������࣬���ǷǾ�̬�࣬�����ڲ�����ʹ�þ�̬����
		/*static */void breath(){
/*			������ӡtype��null��Ҳ�����ڲ���this.type��Ҫ�����ⲿ��typeҪ�����������Face��*/
			System.out.println(Face.this.type);
			System.out.println("����");
		}
	}
	static class Ear{
		void listen(){
			System.out.println("��");
		}
	}
}