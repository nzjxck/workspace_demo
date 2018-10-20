package oop;

public class Point {
	double x,y,z;
	//通过构造器，初始化对象的属性
	public Point(double _x,double _y,double _z){
		x=_x;
		y=_y;
		z=_z;
	}
	public double distance(Point p){
		return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)+(z-p.z)*(z-p.z));
	}
	public static void main(String[] args) {
		Point p1 = new Point(3.6, 2.8, 6.9);
		Point p2 = new Point(30, 78, 55);
		System.out.println(p1.x);
		System.out.println(p1.y);
		System.out.println(p1.z);
		double result = p1.distance(p2);
		System.out.println(result);
	}
	
}
