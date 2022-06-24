import java.awt.*;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.HashSet;

import javax.swing.*;

class panel extends JPanel {
	Connection conn=null; 
	PreparedStatement psmt=null; 
	ResultSet rs=null; 
	
	TextField id_field=new TextField();
	TextField pw_field=new TextField();
	TextField pw2_field=new TextField();
	TextField name_field=new TextField();
	TextField email_field=new TextField();
	String id=id_field.getText();
	String pw=pw_field.getText();
	String pw2=pw2_field.getText();
	String name=name_field.getText();
	String email=email_field.getText();
	
	JButton id_check=new JButton("중복확인");
	JButton email_chech=new JButton("중복확인");
	JButton complete=new JButton("가입완료");
	
	id_check.addMouseListener(new MouseListener() {
		public void mouseClicked() {
			try {
				String que="select id from member";
				conn=ConnecttoDB.get(); 
				psmt=conn.prepareStatement(que); 
				rs=psmt.executeQuery();
				
			} catch(Exception e) {
				
			}
		}
	});
	email_check.addMouseListener(new MouseListener() {
		public void mouseClicked() {
			
		}
	});
	complete.addMouseListener(new MouseListener() {
		public void mouseClicked() {
			
		}
	});
	
	JLabel id_label=new JLabel("아이디");
	JLabel pw_label=new JLabel("비밀번호");
	JLabel pw2_label=new JLabel("비밀번호 확인");
	JLabel name_label=new JLabel("이름");
	JLabel email_label=new JLabel("이메일");
	JLabel id_checklabel=new JLabel();
	JLabel pw_checklabel=new JLabel();
	JLabel email_checklabel=new JLabel();	
	
	panel() {
		setLayout(null);
		add(id_field);
		add(pw_field);
		add(pw2_field);
		add(name_field);
		add(email_field);
		setSize(500, 500);
		setVisible(true);
	}
}

public class sign_up {

	public static void main(String[] args) {
		
		HashSet<String> set_id=new HashSet<>(); //to oracle
		HashSet<String> set_email=new HashSet<>(); //to oracle
		
		

	}

}
