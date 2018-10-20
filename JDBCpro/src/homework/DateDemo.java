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
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//���ڸ�ʽ��
			DateFormat df1 = new SimpleDateFormat("yyyy");
			DateFormat df2 = new SimpleDateFormat("MM");
			DateFormat df3 = new SimpleDateFormat("dd");
			Date d = df.parse(temp);
			Calendar c = new GregorianCalendar();
			c.setTime(d);//������������Date����Calendar
			System.out.println("�����������"+df.format(d));
			System.out.println("������"+df1.format(d)+"��");
			System.out.println("������"+df2.format(d)+"��");
			System.out.println("������"+df3.format(d)+"��");
			System.out.println("������������Ϊ"+c.getActualMaximum(c.DATE)+"��");//��ȡ�����������
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public void tomorrow(String temp){
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//���ڸ�ʽ��
			Date d = df.parse(temp);
			Calendar c = new GregorianCalendar();
			c =Calendar.getInstance();//��������Calendarʵ����
			c.setTime(d);//������������d����c
			c.add(c.DATE, 1);//���ڼ�1
			Date dtom = c.getTime();
			System.out.println("�����������"+df.format(dtom));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("����������(��ʽ��2018-9-19)");
		Scanner sc = new Scanner(System.in);
		String temp1 = sc.nextLine();
		DateDemo dt = new DateDemo();
		dt.daysInMonth(temp1);
		dt.tomorrow(temp1);
	}
}
