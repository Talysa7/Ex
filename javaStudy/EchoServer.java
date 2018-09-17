//server
import java.net.*;
import java.io.*;
import java.util.*;
class EchoServerThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	private String msg;
	public EchoServerThread (Socket s) {
		this.s = s;
	}
	public void run() {
		try {
			//4.����� ��Ʈ�� ����
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			while (true) {
				//6.�޽��� ����
				msg = br.readLine();				
				//7.�޽��� �۽�
				bw.write(msg);
				bw.newLine();
				bw.flush();
				if(msg.equals("exit")) {
					System.out.println("Ŭ���̾�Ʈ ���� ����");
					break;
				} else {
					System.out.println("���� �޽��� : " + msg);
				}
			}
			//9.���� ����
			if(s!=null) s.close();
			if(br!=null) br.close();
			if(bw!=null) bw.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}//��
}//������ Ŭ����
class EchoServer {
	private ServerSocket ss;
	private Socket s;
	public EchoServer (int port) throws IOException {
		//1.���� ���� ����
		ss = new ServerSocket(port);
		//2.���� ���� û��
		while(true) {
			System.out.println("Ŭ���̾�Ʈ ���� ��� ��...");
			s = ss.accept();
			System.out.println("������ Ŭ���̾�Ʈ : " + s.getInetAddress().getHostName());
			EchoServerThread est = new EchoServerThread(s);
			est.start();
		}
	}//������
	public static void main(String[] args) throws IOException	{
		new EchoServer(3000);
	}//����
}
