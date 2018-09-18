import java.sql.*;
import java.io.*;

class UpdateTest {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public UpdateTest() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public void setConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbid = "encore";
		String dbpasswd = "encore";
		con = DriverManager.getConnection(url, dbid, dbpasswd);
	}

	public void updateMember() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("아이디 : ");
		String id = br.readLine();
		System.out.print("비밀번호 : ");
		String passwd = br.readLine();

		String sql = "select * from dbtest where id='" + id + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		if (rs.next()) {
			//해당 아이디 있음
			if (passwd.equals(rs.getString("passwd"))) {
				//비밀번호가 같음
				System.out.println("아이디 : " + rs.getString("id") + "\n" + "비밀번호 : " + rs.getString("passwd") + "\n" + "전화번호 : " + rs.getString("tel") + "\n" + "가입일자 : " + rs.getString("logtime"));
				System.out.println("");
				System.out.println("수정할 비밀번호 : ");
				String newpw = br.readLine();
				System.out.println("수정할 전화번호 : ");
				String newtel = br.readLine();

				//수정 처리
				String dsql = "update dbtest set passwd='" + newpw + "', tel='" + newtel + "' where id='" + id + "'";
				stmt.executeUpdate(dsql);
				int result = stmt.executeUpdate(dsql);
				if (result==0) {
					System.out.println("수정 실패");
				} else {
					System.out.println("수정 성공");
					sql = "select id, passwd, name, tel, logtime from dbtest where id='" + id +"'";
					ResultSet nrs = stmt.executeQuery(sql);
					getValues(id);
				}
				if (stmt != null) stmt.close();
				if (con != null) con.close();
				
			} else {
				System.out.println("비밀번호가 틀립니다.");
			}
		} else {
			//해당 아이디 없음
			System.out.println("아이디가 없습니다.");
		}
	}

	public void getValues(String id) {
		SelectTest st = new SelectTest();
		st.setConnection();
		st.getMember(id);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		UpdateTest ut = new UpdateTest();
		ut.setConnection();
		ut.updateMember(); 
	}
}
