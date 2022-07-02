import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Container;

class FindUser {
	String id, name, email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

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
	
	JPanel background = new JPanel() {
		Image back = new ImageIcon("image/background.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(back, 0, 0, null);
		}
	};	
	
	public find_id() {
		Container c=getContentPane();
		c.setLayout(null);
		
		title.setBackground(Color.ORANGE);
		title.setOpaque(true);
		title.setFont(new Font("DungGeunMo",Font.PLAIN,16));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLocation(30, 25);
		title.setSize(315, 40);
		c.add(title);
		
		name_label.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		name_label.setLocation(30, 80);
		name_label.setSize(60, 30);
		c.add(name_label);
		
		name_field.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		name_field.setLocation(90, 80);
		name_field.setSize(180, 30);
		c.add(name_field);
		
		email_label.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		email_label.setLocation(30, 125);
		email_label.setSize(60, 30);
		c.add(email_label);
		
		email_field.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		email_field.setSize(180, 30);
		email_field.setLocation(90, 125);
		c.add(email_field);
		
		find.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		find.setSize(65, 30);
		find.setLocation(280, 125);
		c.add(find);
		
		result.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		result.setLocation(30, 170);
		result.setSize(240, 30);
		c.add(result);
		
		close.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		close.setLocation(280, 170);
		close.setSize(65, 30);
		c.add(close);
		
		//찾기버튼
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn=Connect.get();
				name=name_field.getText();
				email=email_field.getText();
				
				ArrayList<FindUser> list = new ArrayList <> ();
				
				if(name.equals("")||email.equals("")) {
					result.setText("이름과 이메일을 모두 입력해 주세요.");
				}
				else {
					try { 
//						String que
//							= "select id from member"+ 
//						" where name = ? and email = ?";
//						conn=Connect.get();
//						psmt=conn.prepareStatement(que);
//						psmt.setString(1, name);
//						psmt.setString(2, email);
//						rs=psmt.executeQuery();
//						boolean f=rs.next();
						String que = "select id, name, email from member";
						psmt=conn.prepareStatement(que);
						rs=psmt.executeQuery(que);
						
						while(rs.next()) {
							FindUser finduser = new FindUser();
							finduser.setId(rs.getString("id"));
							finduser.setName(rs.getString("name"));
							finduser.setEmail(rs.getString("email"));
							list.add(finduser);
						}
						
						for(int i=0;i<list.size();i++) {
							String getname = list.get(i).getName();
							String getemail = list.get(i).getEmail();
							String getid = list.get(i).getId();
							if(name.equals(getname) && email.equals(getemail)) {
								System.out.println(getid);
								result.setText("아이디 : "+getid);
								break;
							} else if(!name.equals(getname) || !email.equals(getemail)) {
								result.setText("아이디가 존재하지 않습니다.");
							}
						}
//						if(f) {
//							while(rs.next()) {
//								id=rs.getString("id");		
//							}
//						}
//						else {
//							result.setText("아이디가 존재하지 않습니다.");							
//						}
					} catch(Exception exe) {
						System.out.println(exe);
						exe.printStackTrace();
					}
//					if(id.equals(null)) {
//						result.setText("아이디가 존재하지 않습니다.");
//					}
//					else {
//						result.setText("아이디 : "+id);
//					}
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
		
		background.setLayout(null);
		background.setBounds(0, 0, 390, 275);
		add(background);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		
		new find_id();

	}

}
