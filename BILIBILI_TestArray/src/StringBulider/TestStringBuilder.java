package StringBulider;
/**
 * String ���ɱ��ַ�����
 * ���Կɱ��ַ�����  StringBulider���̲߳���ȫ��Ч�ʸߣ�StringBuffer(�̰߳�ȫ��Ч�ʵ�)
 * StringBuffer��StringBuilder�÷�һ�£�ֻ�漰�������������ⲻһ�¡�
 * @author MXJ
 *
 */
public class TestStringBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();//�Ѿ�new��һ��char[16]����
		StringBuilder sb1 = new StringBuilder(32);//new��һ��char[32]����
		StringBuilder sb2 = new StringBuilder("abcd");//new��һ��char[16+4]����
		sb2.append("efg");
		sb2.append(true).append("126").append("aibc");//ͨ�� return this ʵ�ַ�����
		System.out.println(sb2);
		sb2.delete(3, 5);
		System.out.println(sb2);
		System.out.println(sb2.reverse());
	}
}
