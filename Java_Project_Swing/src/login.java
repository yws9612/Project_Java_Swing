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
				//�븘�씠�뵒瑜� 蹂댁뿬以띾땲�떎. -- �븘�씠�뵒 李얠쓣 諛⑸쾿�씠 �뾾�뒿�땲�떎.
			}
			else {
				//�븘�씠�뵒媛� �뾾�뒿�땲�떎.
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
			//鍮꾨쾲瑜� 蹂댁뿬以띾땲�떎.
		}
		else {
			//�븘�씠�뵒媛� �뾾�뒿�땲�떎.
		}
	}
}

public class login {

	public static void main(String[] args) {
		Connection conn=null; //DB�� �뿰寃고븯�뒗 �씤�꽣�럹�씠�뒪
		PreparedStatement psmt=null; //sql臾� 媛앹껜
		ResultSet rs=null; //sql�뿉 ���븳 諛섑솚(荑쇰━ �떎�뻾�뿉 ���븳 寃곌낵媛� ���옣)
		try {
			String que="select * from emp1";
			conn=A1.get(); //DB�뿰寃�
			psmt=conn.prepareStatement(que); //sql�떎�뻾
			rs=psmt.executeQuery();
			/*select -> executeQuery()
			DML(insert, update, delete) -> executeUpdate(); */
			
			/*
			while(rs.next()) {
				//DB�뿉 �엳�뒗 媛믪쓣 媛��졇�삩�떎.
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
		conn.close();��
		

	}

}
