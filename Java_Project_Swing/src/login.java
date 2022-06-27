
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;


public class login extends JPanel {

	JLabel title = new JLabel("5dle,5dle");
	JLabel id_label = new JLabel("ID");
	JLabel pw_label = new JLabel("PW");
	
	JTextField textfield1 = new JTextField();
	JTextField textfield2= new JTextField();
	
	JButton button1 = new JButton("회원가입");
	JButton button2 = new JButton("로그인");
	JButton button3 = new JButton("아이디 찾기");
	JButton button4 = new JButton("비밀번호 찾기");
	
	
	login() {
		setBackground(Color.darkGray);
		setLayout(null);
		title.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBackground(Color.GRAY);
		title.setSize(331, 163);
		title.setLocation(0, 0);
			
		add(title);
		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		id_label.setSize(64, 40);
		id_label.setLocation(10, 170);
		add(id_label);
		pw_label.setHorizontalAlignment(SwingConstants.CENTER);
		pw_label.setLocation(10, 220);
		pw_label.setSize(64, 40);
		add(pw_label);
		textfield1.setLocation(86, 171);
		textfield1.setSize(225, 40);
		
		add(textfield1);
		textfield2.setLocation(86, 221);
		textfield2.setSize(225, 40);
		add(textfield2);
		button1.setLocation(10, 270);
		button1.setSize(150, 40);
		
		add(button1);
		button2.setLocation(172, 271);
		button2.setSize(150, 40);
		add(button2);
		button3.setLocation(10, 320);
		button3.setSize(150, 40);
		add(button3);
		button4.setLocation(172, 320);
		button4.setSize(150, 40);
		add(button4);
	
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new sign_up();
			}
		});
		
		setSize(331,363);
		setVisible(true);
	}

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
		
		
		//테스트용 임시프레임
		JFrame tmp=new JFrame();
		JPanel log_in=new login();
		tmp.getContentPane().setLayout(new BorderLayout());
		tmp.getContentPane().add(log_in,BorderLayout.CENTER);
		tmp.setSize(800,800);
		tmp.setVisible(true);
		

	}

}
