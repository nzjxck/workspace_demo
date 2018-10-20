package Array;
/**
 * 数组的方法
 * @author MXJ
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//声明
		//[]放前放后都一样
		int[] a;
		int b [];
		//创建数组对象
		a = new int [3];
		b = new int [4];
		//初始化(对数组元素初始化)
		//默认初始化：数组元素相当于对象的成员变量。数字0，布尔false,char\u0000,引用null	
		//动态初始化：
		a[0] = 23;
		a[1] = 69;
		//静态初始化：
		int c [] ={1,2,3};//长度是3，索引范围是[0,2]；
		Car [] cars = {
						new Car("奔驰"),
						new Car("宝马"),
						new Car("丰田")
						};
		Car car1 = new Car("奔驰");
		System.out.println(car1==cars[0]);
		//结果为false很容易理解，car1是新建的对象，与数组中的元素对象是不同地址。
	}
}
