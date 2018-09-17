import java.io.*;
class ByteToCharStreamEx {
	public String input (String msg) throws IOException {
		System.out.print(msg);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	public static void main(String[] args) throws IOException	{				//가상머신이 예외 줏어갈 거임 휙휙 던지기
		ByteToCharStreamEx btc = new ByteToCharStreamEx();
		String id = btc.input("아이디 : ");
		String passwd = btc.input("비밀번호 : ");
		
		//FileOutputStream fos = new FileOutputStream("d1.txt");
		//OutputStreamWriter osw = new OutputStreamWriter(fos);
		//BufferedWriter fw = new BufferedWriter(osw);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d1.txt")));
		bw.write("아이디 : ");
		bw.write(id);
		bw.newLine();
		bw.write("패스워드 : ");
		bw.write(passwd);
		bw.flush();
	}
}
