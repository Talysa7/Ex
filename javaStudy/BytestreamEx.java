import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;			//지정된 파일을 찾을 수 없습니다.
import java.io.IOException;

//1byte 단위 파일
class BytestreamEx {
	public static void main(String[] args) 	{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		int data = 0;

		try {
			fis = new FileInputStream("a.txt");
			fos = new FileOutputStream("a1.txt");

			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			while ((data=bis.read())!=-1) {
				System.out.print((char)data);					//char 안 해주면 숫자로 나옴!
				bos.write(data);
			}
			bos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
				if(bis!=null) bis.close();
				if(bos!=null) bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
