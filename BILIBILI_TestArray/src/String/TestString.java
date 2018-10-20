package String;

public class TestString {
	public static void main(String[] args) {
		String str1 = new String("laotie");
		String str2 = new String("laotie");
		String str3 = str2;
		System.out.println(str1.equals(str2));//equals 比较的是内容不是地址，与==有区别
		System.out.println(str1==str2);
		System.out.println(str2.equals(str3));//equals比较的是直接赋值的就直接返回TRUE
		String str4 = "nihao";
		String str5 = "nihao";
		System.out.println(str4==str5);//返回true的原因是没有新建value[]对象，两个变量都指向常量池的同一个字符串常量，地址一致，故ture。
		System.out.println(str4.charAt(2));//返回索引处字符,如果字符串越界会抛出异常。
		System.out.println(str4.substring(0));//字符串截取，索引从0也就是返回this，索引越界会抛出越界异常。
		System.out.println(str4.toCharArray());//将此字符串转换为新字符数组。
		System.out.println("  aa  bb  ".trim().length());//只能去掉字符串的前后空格，所以返回6
		String str6 = "ni,hao,ma";
		String [] strarray =str6.split(",");
		for(int i = 0;i<strarray.length;i++){
			System.out.println(strarray[i]);
		}
		System.out.println("NIhaoM".equalsIgnoreCase("nihaom"));//忽略大小写来进行equals
		System.out.println("nihaoa".indexOf("a"));
		System.out.println("nihaoa".lastIndexOf("a"));//从后面往前数
	}
}
