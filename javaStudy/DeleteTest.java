import java.sql.*;
import java.io.*;

class DeleteTest 
{
	private Connection con;
	private Statement stmt;

	public DeleteTest () throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public void setConnection() throws SQLException {
		//DB ¿¬°á
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbid = "encore";
		String dbPasswd = "encore";
		con = DriverManager.getConnection(url, dbid, dbPasswd);
	}

	public void deleteMember() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("»èÁ¦ÇÒ ¾ÆÀÌµð : ");
		String id = br.readLine();

		String sql = "delete from dbtest where id='" + id + "'";
		stmt = con.createStatement();
		int result = stmt.executeUpdate(sql);
		if (result==0) {
			System.out.println("Å»Åð ½ÇÆÐ");
		} else {
			System.out.println("Å»Åð ¼º°ø");
		}
		if (stmt != null) stmt.close();
		if (con != null) con.close();
	}

	public void getValues() {
		SelectTest st = new SelectTest();
		st.setConnection();
		st.getMember(null);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		DeleteTest dt = new DeleteTest();
		dt.setConnection();
		dt.deleteMember();
		dt.getValues();
	}
}
