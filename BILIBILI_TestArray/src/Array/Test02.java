package Array;
/**
 * ����ķ���
 * @author MXJ
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//����
		//[]��ǰ�ź�һ��
		int[] a;
		int b [];
		//�����������
		a = new int [3];
		b = new int [4];
		//��ʼ��(������Ԫ�س�ʼ��)
		//Ĭ�ϳ�ʼ��������Ԫ���൱�ڶ���ĳ�Ա����������0������false,char\u0000,����null	
		//��̬��ʼ����
		a[0] = 23;
		a[1] = 69;
		//��̬��ʼ����
		int c [] ={1,2,3};//������3��������Χ��[0,2]��
		Car [] cars = {
						new Car("����"),
						new Car("����"),
						new Car("����")
						};
		Car car1 = new Car("����");
		System.out.println(car1==cars[0]);
		//���Ϊfalse��������⣬car1���½��Ķ����������е�Ԫ�ض����ǲ�ͬ��ַ��
	}
}
