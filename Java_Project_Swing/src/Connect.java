import java.sql.*;

public class Connect {

	public static Connection con;

	public static Connection get() {
		Connection conn = null;
		try {
			
			String userId = "ADMIN";
			String pwd = "5groupDatabase";
			String url = "jdbc:oracle:thin:@db20220627204321_high?TNS_ADMIN=/Users/PC/Downloads/Wallet_DB20220627204321";
		

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, userId, pwd);
		
			System.out.println("DB연결완료");
		}
		catch (Exception e) {
			System.out.println("연결실패");
		}
		return conn;
	}
}
