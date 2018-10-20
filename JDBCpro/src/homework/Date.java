package homework;

public class Date {
	int year, month, day;

	public Date(int year, int month, int day) throws Exception {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		if (this.month > 12 || this.month < 1) {
			throw new Exception("您输入的月份信息有误！");
		}
		if (this.month == 2) {
			if ((this.year / 4 == 0 && this.year / 100 != 0) || this.year / 400 == 0) {
				if (this.day < 0 || this.day > 29) {
					throw new Exception("您输入的日期信息有误!");
				}
			} else if (this.day < 0 || this.day > 28) {
				throw new Exception("您输入的日期信息有误!");
			}
		}if ((this.month!=2)&&(this.month==4||this.month==6||this.month==9||this.month==11)) {
			if (this.day<0||this.day>30) {
				throw new Exception("您输入的日期信息有误！");
			}
		}else {
			if (this.day<0||this.day>31) {
				throw new Exception("您输入的日期信息有误！");
			}
		}
	}

	@Override
	public String toString() {
		return year + "年" + month + "月" + day + "日";
	}

	public int dayinmonth() {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 2:
			if (year / 4 == 0 && year / 100 != 0 || year / 400 == 0) {
				return 29;
			} else {
				return 28;
			}
		default:
			return 30;
		}
	}

	public Date tomorrow() throws Exception {
		if(this.month==12&&this.day==31){
			return(new Date(year+1, 1, 1));
		}
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day == 31) {
				return (new Date(year, month + 1, 1));
			} else {
				return (new Date(year, month, day + 1));
			}
		case 2:
			if (year / 4 == 0 && year / 100 != 0 || year / 400 == 0) {

				if (day == 29) {
					return (new Date(year, month + 1, 1));
				} else {
					return (new Date(year, month, day + 1));
				}
			} else {
				if (day == 28) {
					return (new Date(year, month + 1, 1));
				} else {
					return (new Date(year, month, day + 1));
				}
			}
		case 4:
		case 6:
		case 9:
		case 11:
			if (day == 30) {
				return (new Date(year, month + 1, 1));
			} else {
				return (new Date(year, month, day + 1));
			}
		}
		return null;

	}

	public static void main(String[] args) {
		Date date;
		try {
			date = new Date(2018, 6, 30);
			System.out.println("Today is " + date);
			System.out.println("This Month has " + date.dayinmonth() + " days");
			System.out.print("Tomorrow is ");
			System.out.println(date.tomorrow());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
