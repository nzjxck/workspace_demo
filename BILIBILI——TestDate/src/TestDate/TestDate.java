package TestDate;

import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		Date d2 = new Date(1000);//�Ժ���Ϊ��λ��1970��1.1��ʼ
		System.out.println(d2);
		System.out.println(d.after(d2));
	}
}
