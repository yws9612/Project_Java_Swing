import java.sql.*;

public class Connect {

	public static Connection con;

	public static Connection get() {
		Connection conn = null;
		try {
			// ������ �޸� ����̹��� �ø�
			String userId = "ADMIN";
			String pwd = "5groupDatabase";
			String url = "jdbc:oracle:thin:@db20220627204321_high?TNS_ADMIN=/Users/soldesk/Downloads/Wallet_DB20220627204321";
			//���� ���ϰ�δ� ���� ������ġ�� �°� �ٲ����

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// �����ϱ� ���� �޼ҵ�(���� url, ������, ��ȣ)
			conn = DriverManager.getConnection(url, userId, pwd);
			// Connection��ü�� ���� ..conn�� ������ �����ͺ��̽��� �����Ͽ�
			// �۾��� ������ �� �ִ� ��η� �ۿ��ϴ� �߿��� ��ü ������ ����
			System.out.println("DB연결완료");
		}
		catch (Exception e) {
			System.out.println("연결실패");
		}
		return conn;
	}
}
