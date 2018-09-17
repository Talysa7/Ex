import java.net.*;
import java.io.*;
import java.util.*;

class MutliClientReadThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private String returnmsg;
	public MutliClientReadThread (Socket s) throws IOException {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	public synchronized void run() {
		try {
			while(true) {
				returnmsg = br.readLine();
				if(returnmsg.equals("exit")) {
					System.out.println("서버 접속 종료");
				} else {
					System.out.println(returnmsg);
				}
			}
		} catch (Exception e) {
			System.out.println("서버 비정상 종료");
		} finally {
			try {
				if(s!=null) s.close();
				if(br!=null) br.close();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}
	}
}
class MutliClientWriteThread extends Thread {
	private Socket s;
	private BufferedWriter bw;
	private BufferedReader brmsg;
	private String msg;
	public MutliClientWriteThread (Socket s) throws IOException {
		this.s = s;
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		brmsg = new BufferedReader(new InputStreamReader(System.in));
	}
	public synchronized void run() {
		String name = "비둘기";
		try {
			bw.write(name);
			bw.newLine();
			bw.flush();
			while(true) {
				System.out.print(">> ");
				msg = brmsg.readLine();
				bw.write(msg);
				bw.newLine();
				bw.flush();
				if (msg.equals("exit")) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("서버 비정상 종료");
		} finally {
			try {
				if(bw!=null) bw.close();
				if(brmsg!=null) brmsg.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
public class MulticastingClient {
	private Socket s;
	public MulticastingClient(String ip, int port) throws UnknownHostException, IOException  {
		s = new Socket(ip, port);
		MutliClientReadThread mrt = new MutliClientReadThread(s);
		MutliClientWriteThread mwt = new MutliClientWriteThread(s);
		mrt.start();
		mwt.start();
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		new MulticastingClient("192.168.0.61", 3000);
	}
}