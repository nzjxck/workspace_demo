package opp.TestEncapsulation01;

public class Man {
	//һ����˵�����еĳ�Ա����һ����private
	//�������Լ���̬����ʹ��public
	private String name;
	private int id;
	private boolean man;
	public static int ak;
	//˽�б����޷��ڱ�����ֱ���ö���.����
	//���Զ�����ӷ���������������в��������ṩ�˲����ӿ�
	//��Test01�����setName�����������Man���name���Խ��в�����
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//����boolean���ͱ�����get��is��
	public boolean isMan() {
		return man;
	}
	public void setMan(boolean man) {
		this.man = man;
	}
	
}
