package opp.TestEncapsulation01;


/**
 * ���Է�װ
 * @author MXJ
 *
 */
public class Test01 {
	private String str;
	protected void print() {
		System.out.println("��ӡTEST01");
	}
	public static void main(String[] args) {

		Man man = new Man();
		man.setName("laotie");
	}
}
