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
			//jdbc ����̹��� �ε��ϴ� �ڵ� > DriverManager�� ��ϵ�
			conn=DriverManager.getConnection(url, id, pw);
			/*connection ��ü�� ���� conn�� ������ DB�� �����Ͽ�
			 �۾��� ������ �� �ִ� ��η� �ۿ��ϴ� �߿��� ��ü ������ ����*/
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
