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
			sendAll("[[ " + name + " ]]님이 입장했습니다.");
			while(true) {
				msg = br.readLine();
				if(msg.equals("exit")) {
					//해당 클라이언트만 종료
					bw.write("exit");
					bw.newLine();
					bw.flush();
				} else {
					Thread.sleep(1000);
					sendAll("[" + name + "] : " + msg);
				//전체 브로드캐스팅
				} 
			System.out.println("클라이언트 정상 종료");
			} 
		} catch(Exception e)	{
			System.out.println("exit로 종료하세요");
		} finally {
			try {
				list.remove(bw);
				sendAll("[[ " + name + " ]]님이 퇴장했습니다.");
				if(s!=null) s.close();
				if(br!=null) br.close();
				if(bw!=null) bw.close();
			} catch(IOException ie) {
				System.out.println("클라이언트 비정상종료");
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
			System.out.println("클라이언트 접속 대기 중...");
			s = ss.accept();
			System.out.println("클라이언트 : " + s.getInetAddress().getHostName());
			MultiServerThread mst = new MultiServerThread(s);
			mst.start();
		}
	}
	public static void main(String[] args) throws IOException {
		new MulticastingServer(3000);
	}
}
