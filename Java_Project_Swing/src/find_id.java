import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import javax.swing.*;
public class find_id extends JFrame {
	Connection conn=null; 
	PreparedStatement psmt=null;
	ResultSet rs=null; 
	
	JTextField name_field=new JTextField();
	JTextField email_field=new JTextField();
	
	String name, email, id;
	
	JLabel title=new JLabel("아이디 찾기");
	JLabel name_label=new JLabel("이름");
	JLabel email_label=new JLabel("이메일");
	JLabel result=new JLabel();
	
	JButton find=new JButton("찾기");
	JButton close=new JButton("닫기");
	
	find_id() {
		setLayout(new GridLayout(6,6));
		add(title);
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
				name=name_field.getText();
				email=email_field.getText();
				if(name.equals("")||email.equals("")) {
					result.setText("이름과 이메일을 입력해 주세요.");
				}
				else {
					try {
						String que
							="select id from member "
								+"where name=? and email=?";
						psmt.setString(1, name);
						psmt.setString(2, email);
						psmt=conn.prepareStatement(que);
						rs=psmt.executeQuery();
						id=rs.getString(1);						
					} catch(Exception exe) {
						
					}
					if(id.equals("")) {
						result.setText("아이디가 존재하지 않습니다.");
					}
					else {
						result.setText("아이디 : "+id);
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
		
		new find_id();

	}

}
