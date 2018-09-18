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
		System.out.print("���̵� : ");
		String id = br.readLine();
		System.out.print("��й�ȣ : ");
		String passwd = br.readLine();

		String sql = "select * from dbtest where id='" + id + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		if (rs.next()) {
			//�ش� ���̵� ����
			if (passwd.equals(rs.getString("passwd"))) {
				//��й�ȣ�� ����
				System.out.println("���̵� : " + rs.getString("id") + "\n" + "��й�ȣ : " + rs.getString("passwd") + "\n" + "��ȭ��ȣ : " + rs.getString("tel") + "\n" + "�������� : " + rs.getString("logtime"));
				System.out.println("");
				System.out.println("������ ��й�ȣ : ");
				String newpw = br.readLine();
				System.out.println("������ ��ȭ��ȣ : ");
				String newtel = br.readLine();

				//���� ó��
				String dsql = "update dbtest set passwd='" + newpw + "', tel='" + newtel + "' where id='" + id + "'";
				stmt.executeUpdate(dsql);
				int result = stmt.executeUpdate(dsql);
				if (result==0) {
					System.out.println("���� ����");
				} else {
					System.out.println("���� ����");
					sql = "select id, passwd, name, tel, logtime from dbtest where id='" + id +"'";
					ResultSet nrs = stmt.executeQuery(sql);
					getValues(id);
				}
				if (stmt != null) stmt.close();
				if (con != null) con.close();
				
			} else {
				System.out.println("��й�ȣ�� Ʋ���ϴ�.");
			}
		} else {
			//�ش� ���̵� ����
			System.out.println("���̵� �����ϴ�.");
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
