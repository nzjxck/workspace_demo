package StringBulider;
/**
 * String 不可变字符序列
 * 测试可变字符序列  StringBulider（线程不安全，效率高）StringBuffer(线程安全，效率低)
 * StringBuffer和StringBuilder用法一致，只涉及到进程锁的问题不一致。
 * @author MXJ
 *
 */
public class TestStringBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();//已经new了一个char[16]数组
		StringBuilder sb1 = new StringBuilder(32);//new了一个char[32]数组
		StringBuilder sb2 = new StringBuilder("abcd");//new了一个char[16+4]数组
		sb2.append("efg");
		sb2.append(true).append("126").append("aibc");//通过 return this 实现方法链
		System.out.println(sb2);
		sb2.delete(3, 5);
		System.out.println(sb2);
		System.out.println(sb2.reverse());
	}
}
