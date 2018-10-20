package homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateDemo {
	public void daysInMonth(String temp) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//日期格式化
			DateFormat df1 = new SimpleDateFormat("yyyy");
			DateFormat df2 = new SimpleDateFormat("MM");
			DateFormat df3 = new SimpleDateFormat("dd");
			Date d = df.parse(temp);
			Calendar c = new GregorianCalendar();
			c.setTime(d);//将给定的日期Date传给Calendar
			System.out.println("今天的日期是"+df.format(d));
			System.out.println("今年是"+df1.format(d)+"年");
			System.out.println("本月是"+df2.format(d)+"月");
			System.out.println("今天是"+df3.format(d)+"日");
			System.out.println("这个月最大天数为"+c.getActualMaximum(c.DATE)+"天");//获取本月最大天数
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public void tomorrow(String temp){
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//日期格式化
			Date d = df.parse(temp);
			Calendar c = new GregorianCalendar();
			c =Calendar.getInstance();//将抽象类Calendar实例化
			c.setTime(d);//将给定的日期d传给c
			c.add(c.DATE, 1);//日期加1
			Date dtom = c.getTime();
			System.out.println("明天的日期是"+df.format(dtom));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("请输入日期(格式：2018-9-19)");
		Scanner sc = new Scanner(System.in);
		String temp1 = sc.nextLine();
		DateDemo dt = new DateDemo();
		dt.daysInMonth(temp1);
		dt.tomorrow(temp1);
	}
}
