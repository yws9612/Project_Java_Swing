import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Link {
	public static void main (String [] args) throws SQLException {
		Connection conn=null; //DB와 연결하는 인터페이스

		PreparedStatement psmt=null; //sql문 객체

        ResultSet rs=null; //sql에 대한 반환(쿼리 실행에 대한 결과값 저장)
        
        
        try {
			String sql = "select * from member";
			
			conn = Connect.get();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			//테이블에서 값 불러오기
			while(rs.next()) {
				String ID = rs.getString(2);
				System.out.println(ID);
			}
		}catch(Exception e) {
			System.out.println("select() 실행 오류 : " + e);
		}
        rs.close();
        psmt.close();
        conn.close();
	}
}
