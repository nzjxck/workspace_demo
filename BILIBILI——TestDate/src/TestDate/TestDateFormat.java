package TestDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.DataFormatException;

public class TestDateFormat {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		
		Date d = new Date();
		String s1 = df.format(d);//按照格式化将时间转化成字符串
		System.out.println(s1);
		String s2 = "2018-8-28 08:09:25";
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d2 = df2.parse(s2);
			System.out.println(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
