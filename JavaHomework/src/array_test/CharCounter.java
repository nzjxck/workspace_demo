package array_test;

import java.util.Scanner;

public class CharCounter {
	public static boolean have(char[] cha ,char c) {
		for (int i=0;i<cha.length;i++) {
			if(cha[i]==c) return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
		System.out.println("�������ַ���~��");
		Scanner scanner = new Scanner(System.in);
		String temp = scanner.nextLine();
		//��ĸ��ANSCII��
		for(int i=65;i<123;i++) {
			int charnum=0;
			for(int j = 0; j<temp.length();j++) {
				if((char)i==temp.charAt(j)) {
					charnum++;
				}
		}if(charnum!=0) {
			System.out.println((char)i+"��"+charnum+"��");
		}
		}
		//���ֵ�ANSCII��
		for(int i=48;i<59;i++) {
			int num=0;
			for(int j = 0; j<temp.length();j++) {
				if((char)i==temp.charAt(j)) {
					num++;
				}
		}if(num!=0) {
			System.out.println((char)i+"��"+num+"��");
		}
			
		}
		
}
}
