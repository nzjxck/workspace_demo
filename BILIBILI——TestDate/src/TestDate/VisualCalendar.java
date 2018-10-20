package TestDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;
/**
 * ���ӻ���������
 * @author MXJ
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("���������ڣ���ʽ��2010-1-1��");
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = df.parse(temp);
			Calendar c = new GregorianCalendar();
			c.setTime(d);
			int day = c.get(Calendar.DATE);
			c.set(Calendar.DATE,1);
			//System.out.println(c.get(Calendar.DAY_OF_WEEK));//��ȡĿ���·ݵ�1�������ڼ�
			System.out.print("��\tһ\t��\t��\t��\t��\t��");
			System.out.println();
			for(int space =1;space<c.get(Calendar.DAY_OF_WEEK);space++){
				System.out.print("\t");
			}
			for(int i =1;i<=c.getActualMaximum(c.DATE);i++){//ͨ����ȡ�������ڵ����ֵ�����Զ���ȡ30��31�ա�
				if(i==day){
					System.out.print("*");
				}
				System.out.print(i+"\t");
				if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
					System.out.print("\n");
				}
				c.add(Calendar.DATE, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
