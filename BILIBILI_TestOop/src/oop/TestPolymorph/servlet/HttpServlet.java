package oop.TestPolymorph.servlet;

public class HttpServlet {
	public void service(){
		System.out.println("service");
		doGet();
	}
	public void doGet(){
		System.out.println("HttpServlet.doGet");
	}
}
