import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Link {
	public static void main (String [] args) throws SQLException {
		Connection conn=null; //DB�� �����ϴ� �������̽�

		PreparedStatement psmt=null; //sql�� ��ü

        ResultSet rs=null; //sql�� ���� ��ȯ(���� ���࿡ ���� ����� ����)
        
        
        try {
			String sql = "select * from member";
			
			conn = Connect.get();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			//���̺��� �� �ҷ�����
			while(rs.next()) {
				String ID = rs.getString(2);
				System.out.println(ID);
			}
		}catch(Exception e) {
			System.out.println("select() ���� ���� : " + e);
		}
        rs.close();
        psmt.close();
        conn.close();
	}
}
