import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

class log_in {
	HashMap<String, String> log_in=new HashMap<String, String>();
	String id, pw;
	log_in(TextField tf_id, TextField tf_pw){
		id=tf_id.getText();
		pw=tf_pw.getText();
		if(log_in.containsKey(id)) {
			if(pw.equals(log_in.get(id))) {
				//메뉴화면으로 넘어갑니다
			}
			else {
				//아이디 비번 확인하라는 라벨이 붙습니다.
			}
		}
	}
}

class search_id {
	HashMap<String, String> srch_id=new HashMap<String, String>();
	String name, email;
	search_id(TextField tf_name, TextField tf_email){
		name=tf_name.getText();
		email=tf_email.getText();
		String srch=name+email;
		if(srch_id.containsKey(name)) {
			if(email.equals(srch_id.get(name))) {
				//아이디를 보여줍니다. -- 아이디 찾을 방법이 없습니다.
			}
			else {
				//아이디가 없습니다.
			}
		}
	}
}

class search_pw {
	HashMap<String, String> srch_pw=new HashMap<String, String>();
	String id;
	search_pw(TextField tf_id){
		id=tf_id.getText();
		if(srch_pw.containsKey(id)) {
			String pw=srch_pw.get(id);
			//비번를 보여줍니다.
		}
		else {
			//아이디가 없습니다.
		}
	}
}

public class login {

	public static void main(String[] args) {
		Connection conn=null; //DB와 연결하는 인터페이스
		PreparedStatement psmt=null; //sql문 객체
		ResultSet rs=null; //sql에 대한 반환(쿼리 실행에 대한 결과값 저장)
		try {
			String que="select * from emp1";
			conn=A1.get(); //DB연결
			psmt=conn.prepareStatement(que); //sql실행
			rs=psmt.executeQuery();
			/*select -> executeQuery()
			DML(insert, update, delete) -> executeUpdate(); */
			
			/*
			while(rs.next()) {
				//DB에 있는 값을 가져온다.
				String empno=rs.getString(1);
				String ename=rs.getString(2);
				String job=rs.getString(3);
				int mgr=rs.getInt(4);
				java.sql.Date hiredate=rs.getDate(5);
				int sal=rs.getInt(6);
				int comm=rs.getInt(7);
				int deptno=rs.getInt(8);
				System.out.println(empno+" "+ename+" "+hiredate);
				*/
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		rs.close();
		psmt.close();
		conn.close();​
		

	}

}
