package oop.TestPolymorphism;

public class test {
	public static void makevoice(Animal c){
		c.voice();
		//instanceof  ���c��Cat��
		if(c instanceof Cat){
			((Cat) c).catchmouse();
		}
	}
	public static void main(String[] args) {
		//���������ָ��һ������Ķ���
		//Animal c = new Cat();��2��
		//��ʵ��Cat c = new Cat()��1��������
		//Cat������еķ����ڡ�1���������
		//�����ڡ�2��������£�����Ҫǿ������ת����Cat�������Cat����ķ�����
		Animal c = new Cat();
		makevoice(c);
//		Cat c1 = (Cat)c;
//		c1.catchmouse();
	}
}
