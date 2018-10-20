package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 文件读取（练习异常）
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
				if(fr!=null){//空指针异常的处理方式
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
public String openfile() throws FileNotFoundException{//在方法中不管异常的情况，谁调用我，谁来try catch,如上述注释处
	FileReader f = new FileReader("d:/a.txt");
	return "";
}
}
