//client
import java.net.*;
import java.io.*;
class EchoClient {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	private BufferedReader brmsg;
	private String msg;
	private String returnmsg;
	public EchoClient (String ip, int port) throws UnknownHostException, IOException {
		//3.소켓 생성
		s = new Socket(ip, port);
		//4.입출력 스트림 생성
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		while(true) {
			//5.메시지 송신
			brmsg = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("보낼메시지 : ");
			msg = brmsg.readLine();
			bw.write(msg);
			bw.newLine();
			bw.flush();
			//8.메시지 수신
			returnmsg = br.readLine();
			if(returnmsg.equals("exit")) {
				System.out.println("서버 접속 종료");
				break;
			} else {
				System.out.println("돌아온 메시지: " + returnmsg);
			}
		}
		//9.소켓 종료
		if(s!=null) s.close();
		if(br!=null) br.close();
		if(bw!=null) bw.close();
		if(brmsg!=null) brmsg.close();
	}//생성자
	public static void main(String[] args) throws UnknownHostException, IOException {
	new EchoClient("192.168.0.61", 3000);
	}//메인
}
