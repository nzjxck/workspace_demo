package file;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		File f1 = new File("d:/���ļ�.txt");
		try {
			f1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File f2 =new File("d:/���ļ���/aa/bb/cc");
		//f2.mkdirs();//�������ʹ��mkdir��ᴴ��ʧ�ܣ���Ϊǰ���Ŀ¼�����ڵĻ��Ͳ��ᴴ����
		System.out.println(f1.isFile());
		System.out.println(f2.isDirectory());
	}
}
