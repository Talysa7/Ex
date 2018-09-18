import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class SelectTest {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public SelectTest() {
		//드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} //생성자

	public void setConnection() {
		//DB 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbid = "encore";
		String dbPasswd = "encore";
		try {
			con = DriverManager.getConnection(url, dbid, dbPasswd);
			System.out.println("DB 연결 성공");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public void getMember(String id) {
		//id가 null인 경우		전체 출력
		//id가 null이 아닌 경우	해당 id만 출력
		String sql;
		
		if (id==null || id.equals("")) {
			sql = "select * from dbtest";
		} else {
			sql = "select id, passwd, name, tel, logtime from dbtest where id='" + id +"'";
		}
		try {
			stmt = con.createStatement();
			//조회할 때는 stmt.executeQuery();
			//수정할 때는 stmt.executeUpdate()
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(
					//columnIndex로도 뽑을 수 있는데, 이런 경우 의도대로 안 뽑힐 때도 있기 때문에 columnLabel로 뽑는게 나음
					rs.getString("id") + "\t" + rs.getString("passwd") + "\t" + rs.getString("name") + "\t" + rs.getString("tel") + "\t" + rs.getTimestamp("logtime")
					);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
				if (con!=null) con.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		st.setConnection();
		st.getMember(null);
		//st.getMember("aaa");
		//null 대신 id 넣으면 동작하게 해놨다.
	}
}
