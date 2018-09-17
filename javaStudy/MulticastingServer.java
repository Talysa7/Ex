import java.net.*;
import java.io.*;
import java.util.*;

class MultiServerThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	private String name;
	private String msg;
	private static ArrayList <BufferedWriter> list = new ArrayList <BufferedWriter> ();
	public MultiServerThread (Socket s) throws IOException {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		list.add(bw);
	}
	public void run () {
		try {
			name = br.readLine();
			sendAll("[[ " + name + " ]]���� �����߽��ϴ�.");
			while(true) {
				msg = br.readLine();
				if(msg.equals("exit")) {
					//�ش� Ŭ���̾�Ʈ�� ����
					bw.write("exit");
					bw.newLine();
					bw.flush();
				} else {
					Thread.sleep(1000);
					sendAll("[" + name + "] : " + msg);
				//��ü ��ε�ĳ����
				} 
			System.out.println("Ŭ���̾�Ʈ ���� ����");
			} 
		} catch(Exception e)	{
			System.out.println("exit�� �����ϼ���");
		} finally {
			try {
				list.remove(bw);
				sendAll("[[ " + name + " ]]���� �����߽��ϴ�.");
				if(s!=null) s.close();
				if(br!=null) br.close();
				if(bw!=null) bw.close();
			} catch(IOException ie) {
				System.out.println("Ŭ���̾�Ʈ ����������");
			}
		}
	}
	
	public void sendAll (String msg) throws IOException {
		for(int i=0; i<list.size(); i++) {
			BufferedWriter sbw = list.get(i);
			sbw.write(msg);
			sbw.newLine();
			sbw.flush();
		}	
	}
}

public class MulticastingServer {
	private ServerSocket ss;
	private Socket s;
	public MulticastingServer(int port) throws IOException {
		ss = new ServerSocket(port);
		while(true) {
			System.out.println("Ŭ���̾�Ʈ ���� ��� ��...");
			s = ss.accept();
			System.out.println("Ŭ���̾�Ʈ : " + s.getInetAddress().getHostName());
			MultiServerThread mst = new MultiServerThread(s);
			mst.start();
		}
	}
	public static void main(String[] args) throws IOException {
		new MulticastingServer(3000);
	}
}
