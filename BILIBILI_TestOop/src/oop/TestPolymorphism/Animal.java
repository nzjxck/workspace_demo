package oop.TestPolymorphism;

public class Animal {
	int id;
	public void voice(){
		System.out.println("ÆÕÍ¨¶¯Îï½ĞÉù");
	}
}
class Cat extends Animal{
	public void voice(){
		System.out.println("ß÷ß÷ß÷~");
}
	public void catchmouse(){
		System.out.println("×¥ÀÏÊó£¡");
	}
}
class Dog extends Animal{
	public void voice(){
		System.out.println("ÍôÍôÍô~");
	}
}
class Pig extends Animal{
	public void voice(){
		System.out.println("ºßßóßó~");
	}
}

