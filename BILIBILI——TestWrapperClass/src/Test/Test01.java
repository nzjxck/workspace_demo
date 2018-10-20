package Test;

public class Test01 {
	public static void main(String[] args) {
		Integer i = new Integer(1000);
		System.out.println(i.toHexString(i));//十进制转十六进制
		System.out.println(Integer.MAX_VALUE);
		Integer i2 = new Integer(234);
		System.out.println(new Integer("333")+20);
		System.out.println(i2.intValue()+10);
		String str = 234+"";
		/**
		 * 自动装箱
		 */
		Integer c = 1000;
		int d = new Integer(1600);
		//自动拆箱
		//相当于  int d = new Integer(1600).intValue();
		Integer i3 = 650;
		Integer i4 = 650;
		System.out.println(i3==i4);
		Integer i5 = 120;
		Integer i6 = 120;
		System.out.println(i5==i6);//[-128,127]之间的数仍然当做基本数据类型来处理，也就是不自动装箱，数组缓存区。
		
		System.out.println();
	}
}
