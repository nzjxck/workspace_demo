package oop.TestInherit;
/**
 * �������
 * @author MXJ
 *
 */
public class Animal2 {
		protected String eye;
		public void run() {
			System.out.println("��~");
		}
		public void eat() {
			System.out.println("��~");
		}
		public Animal2(){
			System.out.println("����һ���������");
		}
		public static void main(String[] args) {
			Bird2 b = new Bird2();
			b.run();
		}
	}
	class Mammal2 {
		//��Mammal2������һ��Anmial2��Ķ���Ϳ��Ե���Animal2������Ժͷ�����
		//��ʵ�ִ��븴���Եķ��棬��Ͽ��Ժͼ̳�����ͬ����Ч����
		Animal2 animal2 = new Animal2();
		public void taisheng() {
			System.out.println("����̥����");
		}
	}
	class Bird2 extends Animal2{
		String eye;
		Animal2 animal2 = new Animal2();
		//������ķ����͸����������ʱ�򣬿��Խ��з�����д��������û��ϵ��
		public void run() {
			System.out.println("��~");
		}
		public void eggSheng() {
			System.out.println("����������");
		}
		public Bird2(){
			System.out.println("����һ�������");
		}
	}

