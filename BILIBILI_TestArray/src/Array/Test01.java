package Array;
/**
 * ����Ļ�������
 * @author MXJ
 *
 */
public class Test01 {
	public static void main(String[] args) {
		int [] a =new int[3];
		/**
		 * 1.��������ͬ�������ͣ�����Ϊ�κ��������ͣ������򼯺�
		 * 2.����Ҳ�Ƕ�������Ԫ���൱�ڶ���ĳ�Ա������
		 * 3.���鳤����ȷ���ģ����ɱ�ġ�Խ��ᱨ��
		 */
		a[0] = 12;
		a[1] = 56;
		a[2] = 49;
		Car[] cars = new Car[10];
		cars[0] = new Car("����");
		System.out.println(cars[0].name);
	}
}
