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
		//����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} //������

	public void setConnection() {
		//DB ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbid = "encore";
		String dbPasswd = "encore";
		try {
			con = DriverManager.getConnection(url, dbid, dbPasswd);
			System.out.println("DB ���� ����");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public void getMember(String id) {
		//id�� null�� ���		��ü ���
		//id�� null�� �ƴ� ���	�ش� id�� ���
		String sql;
		
		if (id==null || id.equals("")) {
			sql = "select * from dbtest";
		} else {
			sql = "select id, passwd, name, tel, logtime from dbtest where id='" + id +"'";
		}
		try {
			stmt = con.createStatement();
			//��ȸ�� ���� stmt.executeQuery();
			//������ ���� stmt.executeUpdate()
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(
					//columnIndex�ε� ���� �� �ִµ�, �̷� ��� �ǵ���� �� ���� ���� �ֱ� ������ columnLabel�� �̴°� ����
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
		//null ��� id ������ �����ϰ� �س���.
	}
}
