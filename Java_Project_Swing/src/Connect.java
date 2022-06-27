import java.sql.*;

public class Connect {

	public static Connection con;

	public static Connection get() {
		Connection conn = null;
		try {
			// 접속할 메모리 드라이버에 올림
			String id = "BBBB";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속하기 위한 메소드(접속 url, 계정명, 암호)
			con = DriverManager.getConnection(url, id, pw);
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
