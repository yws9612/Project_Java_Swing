import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.Font;

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
	
	public find_pw() {
		Container c=getContentPane();
		
		c.setLayout(null);

		title.setBackground(Color.ORANGE);
		title.setOpaque(true);
		title.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLocation(30, 25);
		title.setSize(315, 40);		
		c.add(title);

		id_label.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		id_label.setLocation(30, 80);
		id_label.setSize(60, 30);
		c.add(id_label);

		id_field.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		id_field.setLocation(90, 80);
		id_field.setSize(180, 30);
		c.add(id_field);

		name_label.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		name_label.setLocation(30, 125);
		name_label.setSize(60, 30);
		c.add(name_label);

		name_field.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		name_field.setLocation(90, 125);
		name_field.setSize(180, 30);
		c.add(name_field);

		email_label.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		email_label.setLocation(30, 170);
		email_label.setSize(60, 30);
		c.add(email_label);

		email_field.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		email_field.setLocation(90, 170);
		email_field.setSize(180, 30);
		c.add(email_field);

		find.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		find.setLocation(280, 170);
		find.setSize(65, 30);
		c.add(find);

		result.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setLocation(30, 215);
		result.setSize(315, 50);
		c.add(result);

		close.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		close.setLocation(280, 280);
		close.setSize(65, 30);
		c.add(close);
		
		
		//찾기버튼
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id=id_field.getText();
				name=name_field.getText();
				email=email_field.getText();
				if(id.equals("")||name.equals("")||email.equals("")) {
					String alert1="아이디, 이름 또는 이메일을";
					String alert2="모두 입력해 주세요.";
					result.setText
						("<html><body><center>"+alert1
								+"<br>"+alert2+"</body><html>");
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
						String alert1="아이디, 이름 또는 이메일을";
						String alert2="다시 한 번 확인해 주세요.";
						result.setText
							("<html><body><center>"+alert1
									+"<br>"+alert2+"</body><html>");
					}
					else {
						result.setText
							("<html><body><center>비밀번호 : "
									+pw+"</body><html>");
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
		
		setSize(390, 370);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new find_pw();
	}

}