//바이트(1byte) / 문자(2byte) 출력 스트림 모두를 가지고 객체를 생성
import java.io.*;
class PrintWriterEx {
	public static void main(String[] args) 	{
		//파일 생성				c1.txt
		PrintWriter pw1 = null;
		FileOutputStream fos = null;
		PrintWriter pw2 = null;
		FileWriter fw = null;
		PrintWriter pw3 = null;;
		
		try {
			pw1 = new PrintWriter("c1.txt");
			pw1.println(10);
			pw1.println("ABC");
			pw1.println("가나다");
			pw1.flush();

		//1byte					c2.txt
			fos = new FileOutputStream("c2.txt");
			pw2 = new PrintWriter(fos, true);
			pw2.println(10.5);
			pw2.println("ABC");
			pw2.println("가나다라");

		//2byte					c3.txt
			fw = new FileWriter("c3.txt");
			pw3 = new PrintWriter(fw, true);
			pw3.println('A');
			pw3.println("ABC");
			pw3.println("아무거나");

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if(pw1!=null) pw1.close();
				if(fos!=null) fos.close();
				if(pw2!=null) pw2.close();
				if(fw!=null) fw.close();
				if(pw3!=null) pw3.close();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}
	}
}
