package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * �ļ���ȡ����ϰ�쳣��
 * @author MXJ
 *
 */
public class TestFileRead {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("d:/a.txt");
			char c1 =(char)fr.read();
			System.out.println(c1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(fr!=null){//��ָ���쳣�Ĵ���ʽ
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		try {
//			String tf = new TestFileRead().openfile();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}
public String openfile() throws FileNotFoundException{//�ڷ����в����쳣�������˭�����ң�˭��try catch,������ע�ʹ�
	FileReader f = new FileReader("d:/a.txt");
	return "";
}
}
