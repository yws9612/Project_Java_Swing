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
				//korean break T.T success login
			}
			else {
				//check id and pw
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
				//change key or 
				//select id from Member where name=name and email=email 
			}
			else {
				//no info
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
			//print pw
		}
		else {
			//wrong id
		}
	}
}

public class login {

	public static void main(String[] args) {
		
		/* 참고용 DB에서 내용 추출 코드
		Connection conn=null; 
		PreparedStatement psmt=null; 
		ResultSet rs=null; 
		try {
			String que="";
			conn=ConnecttoDB.get(); 
			psmt=conn.prepareStatement(que); 
			rs=psmt.executeQuery();
			/select -> executeQuery()
			DML(insert, update, delete) -> executeUpdate(); /
			
			while(rs.next()) {
				String empno=rs.getString(1);
				String ename=rs.getString(2);
				String job=rs.getString(3);
				int mgr=rs.getInt(4);
				java.sql.Date hiredate=rs.getDate(5);
				int sal=rs.getInt(6);
				int comm=rs.getInt(7);
				int deptno=rs.getInt(8);
				System.out.println(empno+" "+ename+" "+hiredate);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		rs.close();
		psmt.close();
		conn.close();
		*/
		

	}

}
