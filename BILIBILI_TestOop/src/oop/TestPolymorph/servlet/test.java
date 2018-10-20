package oop.TestPolymorph.servlet;

public class test {
	public static void main(String[] args) {
		HttpServlet s = new MyServlet();
		s.service();
		//这里调用的是父类Http的方法service,方法内部有doGet(this,super),这里的所有方法的this都指向最外层（也就是最子类）
		//也就是my类中的doGet方法。故显示my.doGet
	}
}
