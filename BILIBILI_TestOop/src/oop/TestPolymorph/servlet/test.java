package oop.TestPolymorph.servlet;

public class test {
	public static void main(String[] args) {
		HttpServlet s = new MyServlet();
		s.service();
		//������õ��Ǹ���Http�ķ���service,�����ڲ���doGet(this,super),��������з�����this��ָ������㣨Ҳ���������ࣩ
		//Ҳ����my���е�doGet����������ʾmy.doGet
	}
}
