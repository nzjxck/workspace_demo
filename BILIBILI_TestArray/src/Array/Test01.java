package Array;
/**
 * 数组的基本概念
 * @author MXJ
 *
 */
public class Test01 {
	public static void main(String[] args) {
		int [] a =new int[3];
		/**
		 * 1.数组是相同数据类型（可以为任何数据类型）的有序集合
		 * 2.数组也是对象。数组元素相当于对象的成员变量。
		 * 3.数组长度是确定的，不可变的。越界会报错。
		 */
		a[0] = 12;
		a[1] = 56;
		a[2] = 49;
		Car[] cars = new Car[10];
		cars[0] = new Car("奔驰");
		System.out.println(cars[0].name);
	}
}
