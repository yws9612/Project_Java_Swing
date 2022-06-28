import java.sql.*;

public class Connect {

	public static Connection con;

	public static Connection get() {
		Connection conn = null;
		try {
			// 접속할 메모리 드라이버에 올림
			String userId = "ADMIN";
			String pwd = "5groupDatabase";
			String url = "jdbc:oracle:thin:@db20220627204321_high?TNS_ADMIN=/Users/soldesk/Downloads/Wallet_DB20220627204321";//여기 파일경로는 바꿔야함

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속하기 위한 메소드(접속 url, 계정명, 암호)
			conn = DriverManager.getConnection(url, userId, pwd);
			// Connection객체를 얻음 ..conn은 실제로 데이터베이스와 연결하여
			// 작업을 수행할 수 있는 통로로 작용하는 중요한 객체 변수로 사용됨
			System.out.println("데이터베이스에 연결됐다");
		}
		catch (Exception e) {
			System.out.println("로딩 실패");
		}
		return conn;
	}
}
