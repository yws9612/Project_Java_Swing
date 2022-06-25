import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class find_pw extends JFrame {
	Connection conn=null; 
	PreparedStatement psmt=null;
	ResultSet rs=null; 
	
	JTextField id_field=new JTextField();
	JTextField name_field=new JTextField();
	JTextField email_field=new JTextField();
	
	String id, name, email, pw;
	
	JLabel title=new JLabel("비밀번호 찾기");
	JLabel id_label=new JLabel("아이디");
	JLabel name_label=new JLabel("이름");
	JLabel email_label=new JLabel("이메일");
	JLabel result=new JLabel();
	
	JButton find=new JButton("찾기");
	JButton close=new JButton("닫기");
	
	find_pw() {
		setLayout(new GridLayout(6,6));
		add(title);
		add(id_label);
		add(id_field);
		add(name_label);
		add(name_field);
		add(email_label);
		add(email_field);
		add(find);
		add(result);
		add(close);
		
		//찾기버튼
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id=id_field.getText();
				name=name_field.getText();
				email=email_field.getText();
				if(id.equals("")||name.equals("")||email.equals("")) {
					result.setText("아이디, 이름 또는 이메일을 입력해 주세요.");
				}
				else {
					try {
						String que
							="select pw from member "
								+"where name=? and email=? and id=?";
						psmt.setString(1, name);
						psmt.setString(2, email);
						psmt.setString(3, id);
						psmt=conn.prepareStatement(que);
						rs=psmt.executeQuery();
						pw=rs.getString(1);						
					} catch(Exception exe) {
						
					}
					if(pw.equals("")) {
						result.setText
							("아이디, 이름 또는 이메일을 다시 한 번 확인해 주세요.");
					}
					else {
						result.setText("비밀번호 : "+pw);
					}
				}				
			}
		});
		
		//닫기버튼
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new find_pw();
	}

}
