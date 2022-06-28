import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
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
	
	public find_id() {
		Container c=getContentPane();
		c.setLayout(null);
		
		title.setBackground(Color.ORANGE);
		title.setOpaque(true);
		title.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLocation(30, 25);
		title.setSize(315, 40);
		c.add(title);
		
		name_label.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		name_label.setLocation(30, 80);
		name_label.setSize(60, 30);
		c.add(name_label);
		
		name_field.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		name_field.setLocation(90, 80);
		name_field.setSize(180, 30);
		c.add(name_field);
		
		email_label.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		email_label.setLocation(30, 125);
		email_label.setSize(60, 30);
		c.add(email_label);
		
		email_field.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		email_field.setSize(180, 30);
		email_field.setLocation(90, 125);
		c.add(email_field);
		
		find.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		find.setSize(65, 30);
		find.setLocation(280, 125);
		c.add(find);
		
		result.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		result.setLocation(30, 170);
		result.setSize(240, 30);
		c.add(result);
		
		close.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		close.setLocation(280, 170);
		close.setSize(65, 30);
		c.add(close);
		
		//찾기버튼
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=name_field.getText();
				email=email_field.getText();
				if(name.equals("")||email.equals("")) {
					result.setText("이름과 이메일을 모두 입력해 주세요.");
				}
				else {
					try {
						String que
							="select id from member "
								+"where name=? and email=?";
						conn=Connect.get();
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
		
		setSize(390, 275);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		
		new find_id();

	}

}
