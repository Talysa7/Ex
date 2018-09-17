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
			//4.입출력 스트림 생성
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			while (true) {
				//6.메시지 수신
				msg = br.readLine();				
				//7.메시지 송신
				bw.write(msg);
				bw.newLine();
				bw.flush();
				if(msg.equals("exit")) {
					System.out.println("클라이언트 접속 종료");
					break;
				} else {
					System.out.println("받은 메시지 : " + msg);
				}
			}
			//9.소켓 종료
			if(s!=null) s.close();
			if(br!=null) br.close();
			if(bw!=null) bw.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}//런
}//스레드 클래스
class EchoServer {
	private ServerSocket ss;
	private Socket s;
	public EchoServer (int port) throws IOException {
		//1.서버 소켓 생성
		ss = new ServerSocket(port);
		//2.서버 소켓 청취
		while(true) {
			System.out.println("클라이언트 접속 대기 중...");
			s = ss.accept();
			System.out.println("접속한 클라이언트 : " + s.getInetAddress().getHostName());
			EchoServerThread est = new EchoServerThread(s);
			est.start();
		}
	}//생성자
	public static void main(String[] args) throws IOException	{
		new EchoServer(3000);
	}//메인
}
