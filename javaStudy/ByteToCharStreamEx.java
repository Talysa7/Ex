import java.io.*;
class ByteToCharStreamEx {
	public String input (String msg) throws IOException {
		System.out.print(msg);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	public static void main(String[] args) throws IOException	{				//����ӽ��� ���� �޾ ���� ���� ������
		ByteToCharStreamEx btc = new ByteToCharStreamEx();
		String id = btc.input("���̵� : ");
		String passwd = btc.input("��й�ȣ : ");
		
		//FileOutputStream fos = new FileOutputStream("d1.txt");
		//OutputStreamWriter osw = new OutputStreamWriter(fos);
		//BufferedWriter fw = new BufferedWriter(osw);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d1.txt")));
		bw.write("���̵� : ");
		bw.write(id);
		bw.newLine();
		bw.write("�н����� : ");
		bw.write(passwd);
		bw.flush();
	}
}
