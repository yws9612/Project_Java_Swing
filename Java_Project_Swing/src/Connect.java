import java.sql.*;

public class Connect {

	public static Connection con;

	public static Connection get() {
		Connection conn = null;
		try {
			// ������ �޸� ����̹��� �ø�
			String id = "BBBB";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// �����ϱ� ���� �޼ҵ�(���� url, ������, ��ȣ)
			con = DriverManager.getConnection(url, id, pw);
			// Connection��ü�� ���� ..conn�� ������ �����ͺ��̽��� �����Ͽ�
			// �۾��� ������ �� �ִ� ��η� �ۿ��ϴ� �߿��� ��ü ������ ����

			System.out.println("�����ͺ��̽��� ����ƴ�");
		}

		catch (Exception e) {

			System.out.println("�ε� ����");

		}

		return conn;

	}

}
