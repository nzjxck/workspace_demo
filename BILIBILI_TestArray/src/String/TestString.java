package String;

public class TestString {
	public static void main(String[] args) {
		String str1 = new String("laotie");
		String str2 = new String("laotie");
		String str3 = str2;
		System.out.println(str1.equals(str2));//equals �Ƚϵ������ݲ��ǵ�ַ����==������
		System.out.println(str1==str2);
		System.out.println(str2.equals(str3));//equals�Ƚϵ���ֱ�Ӹ�ֵ�ľ�ֱ�ӷ���TRUE
		String str4 = "nihao";
		String str5 = "nihao";
		System.out.println(str4==str5);//����true��ԭ����û���½�value[]��������������ָ�����ص�ͬһ���ַ�����������ַһ�£���ture��
		System.out.println(str4.charAt(2));//�����������ַ�,����ַ���Խ����׳��쳣��
		System.out.println(str4.substring(0));//�ַ�����ȡ��������0Ҳ���Ƿ���this������Խ����׳�Խ���쳣��
		System.out.println(str4.toCharArray());//�����ַ���ת��Ϊ���ַ����顣
		System.out.println("  aa  bb  ".trim().length());//ֻ��ȥ���ַ�����ǰ��ո����Է���6
		String str6 = "ni,hao,ma";
		String [] strarray =str6.split(",");
		for(int i = 0;i<strarray.length;i++){
			System.out.println(strarray[i]);
		}
		System.out.println("NIhaoM".equalsIgnoreCase("nihaom"));//���Դ�Сд������equals
		System.out.println("nihaoa".indexOf("a"));
		System.out.println("nihaoa".lastIndexOf("a"));//�Ӻ�����ǰ��
	}
}
