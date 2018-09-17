//2byte 단위로 파일입출력 + 버퍼
/*
			1byte				2byte
입력		InputStream		Reader
출력		OutputStream	Writer
*/
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

class CharStreamEx {
	public static void main(String[] args) {
		//b.txt -> b1.txt
		FileReader is = null;
		FileWriter os = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		String msg;

		try {
			is = new FileReader("b.txt");
			os = new FileWriter("b1.txt");
			br = new BufferedReader(is);
			bw = new BufferedWriter(os);

				while ((msg=br.readLine())!=null) {
					System.out.println(msg);
					bw.write(msg);
					bw.newLine();
				}
			bw.flush();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if(is!=null) is.close();
				if(os!=null) os.close();
				if(br!=null) br.close();
				if(bw!=null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
