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
 * 可视化日历程序
 * @author MXJ
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("请输入日期（格式：2010-1-1）");
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = df.parse(temp);
			Calendar c = new GregorianCalendar();
			c.setTime(d);
			int day = c.get(Calendar.DATE);
			c.set(Calendar.DATE,1);
			//System.out.println(c.get(Calendar.DAY_OF_WEEK));//获取目标月份的1号是星期几
			System.out.print("日\t一\t二\t三\t四\t五\t六");
			System.out.println();
			for(int space =1;space<c.get(Calendar.DAY_OF_WEEK);space++){
				System.out.print("\t");
			}
			for(int i =1;i<=c.getActualMaximum(c.DATE);i++){//通过获取本月日期的最大值，来自动获取30或31日。
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
