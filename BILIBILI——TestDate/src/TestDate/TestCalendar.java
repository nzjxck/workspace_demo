package TestDate;
/**
 * ����������
 */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
		c.set(2018, Calendar.AUGUST, 28, 8, 42, 25);
		Date d = c.getTime();
		System.out.println(d);
		System.out.println("###########################");
		/**
		 * �������ڼ���
		 */
		c.add(Calendar.MONTH, -20);
		Date d1 = c.getTime();
		System.out.println(d1);
		
	}
}
