package Test;

public class Test01 {
	public static void main(String[] args) {
		Integer i = new Integer(1000);
		System.out.println(i.toHexString(i));//ʮ����תʮ������
		System.out.println(Integer.MAX_VALUE);
		Integer i2 = new Integer(234);
		System.out.println(new Integer("333")+20);
		System.out.println(i2.intValue()+10);
		String str = 234+"";
		/**
		 * �Զ�װ��
		 */
		Integer c = 1000;
		int d = new Integer(1600);
		//�Զ�����
		//�൱��  int d = new Integer(1600).intValue();
		Integer i3 = 650;
		Integer i4 = 650;
		System.out.println(i3==i4);
		Integer i5 = 120;
		Integer i6 = 120;
		System.out.println(i5==i6);//[-128,127]֮�������Ȼ����������������������Ҳ���ǲ��Զ�װ�䣬���黺������
		
		System.out.println();
	}
}
