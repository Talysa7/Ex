import java.sql.*;
import java.io.*;

class InsertTest {
	private Connection con;
	private Statement stmt;
	private String id, passwd, name, tel;

	public InsertTest() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public void setConnection() throws SQLException {
		//DB 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbid = "encore";
		String dbPasswd = "encore";
		con = DriverManager.getConnection(url, dbid, dbPasswd);
	}

	public void insertMember(String id, String passwd, String name, String tel) throws SQLException {
		String sql = "insert into dbtest values('" + id + "', '" + passwd + "', '" + name + "', '" + tel + "', sysdate)";
		stmt = con.createStatement();
		int result = stmt.executeUpdate(sql);
		if (result==0) {
			System.out.println("가입 실패");
		} else {
			System.out.println("가입 성공");
		}
		if (stmt != null) stmt.close();
		if (con != null) con.close();
	}

	public void insertValues() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("아이디 : ");
		id = br.readLine();
		System.out.print("비밀번호 : ");
		passwd = br.readLine();
		System.out.print("이름 : ");
		name = br.readLine();
		System.out.print("전화번호 : ");
		tel = br.readLine();

		insertMember(id, passwd, name, tel);
		getValues();
	}

	public void getValues() {
		SelectTest st = new SelectTest();
		st.setConnection();
		st.getMember(null);
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		InsertTest it = new InsertTest();
		it.setConnection();
		it.insertValues();
	}
}