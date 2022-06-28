import java.sql.Connection;
import java.sql.DriverManager;

public class ConnecttoDB {
	public static Connection con; //link database
	public static Connection get() {
		Connection conn=null;
		try {
			String id="Aaa";
			String pw="1111";
			String url="jdbc:oracle:thin:@localhost:1521/xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//jdbc 드라이버를 로딩하는 코드 > DriverManager에 등록됨
			conn=DriverManager.getConnection(url, id, pw);
			/*connection 객체를 얻음 conn은 실제로 DB와 연결하여
			 작업을 수행할 수 있는 통로로 작용하는 중요한 객체 변수로 사용됨*/
			System.out.println("success connecting");			
		} catch(Exception e) {
			System.out.println("fail");
		}
		return conn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
