package Test_Collection;

import java.util.ArrayList;
import java.util.List;

public class Test_ArrayList {
	public static void main(String[] args) {
		List list =new ArrayList(2);
		list.add("0");
		list.add("1");
		list.add("2");
		list.remove("0");
		System.out.println(list.size());
	}
}
