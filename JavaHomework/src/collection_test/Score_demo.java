package collection_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Score_demo {
	public static void main(String[] args) {
		List<Person> studentlist = new ArrayList<Person>();
		studentlist.add(new Person("������", 18, 'F', 50, 80));
		studentlist.add(new Person("����", 25, 'M', 20, 47));
		studentlist.add(new Person("�Կ�", 15, 'F', 79, 60));
		studentlist.add(new Person("�����", 23, 'F', 80, 65));
		studentlist.add(new Person("�Ŷ���", 65, 'M', 70, 70));
		studentlist.add(new Person("��ŵ", 30, 'M', 58, 70));
		
		Collections.sort(studentlist);
		System.out.println(studentlist);
		int index = Collections.binarySearch(studentlist, new Person("�Կ�"));
		if (index>=0) {
			System.out.println("�ҵ���");
		}else {
			System.out.println("û�ҵ�");
		}
		
	}
}
