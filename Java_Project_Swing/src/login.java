import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;


class Getter{
	private String result;
	private String admin;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
}
public class login extends JFrame {
	Connection conn=null; 
	PreparedStatement psmt=null;
	ResultSet rs=null;
	static String id,pw;

	JLabel title = new JLabel("5dle,5dle");
	JLabel id_label = new JLabel("ID");
	JLabel pw_label = new JLabel("PW");
	JLabel alter = new JLabel();
	
	JTextField id_field = new JTextField();
	JPasswordField pw_field= new JPasswordField();
	
	JButton sign_up = new JButton("회원가입");
	JButton log_in = new JButton("로그인");
	JButton find_id = new JButton("아이디 찾기");
	JButton find_pw = new JButton("비밀번호 찾기");
	
	
	login() {
		setBackground(Color.WHITE);
		setLayout(null);
		title.setForeground(UIManager.getColor("Button.focus"));
		title.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBackground(Color.GRAY);
		title.setSize(331, 113);
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
		id_field.setLocation(86, 171);
		id_field.setSize(233, 40);
		
		add(id_field);
		pw_field.setLocation(86, 221);
		pw_field.setSize(233, 40);
		add(pw_field);
		sign_up.setBackground(Color.WHITE);
		sign_up.setLocation(10, 270);
		sign_up.setSize(150, 40);
		
		add(sign_up);
		log_in.setLocation(172, 271);
		log_in.setSize(150, 40);
		add(log_in);
		find_id.setLocation(10, 320);
		find_id.setSize(150, 40);
		add(find_id);
		find_pw.setLocation(172, 320);
		find_pw.setSize(150, 40);
		add(find_pw);
		
		alter.setSize(283, 40);
		alter.setLocation(36, 123);		
		add(alter);
			
		sign_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new sign_up();
			}
		});
		
		log_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = id_field.getText();
				pw = pw_field.getText();
				
				if(id.equals("")||pw.equals("")) {
					alter.setText("id 혹은 비밀번호를 확인하세요.");					
				}
				else {
					try {
						String que="select pw, admin from member where id=?";
						conn=Connect.get();
						psmt=conn.prepareStatement(que);
						psmt.setString(1, id);
						rs=psmt.executeQuery();
						Getter get = new Getter();
						while(rs.next()) {
							get.setResult(rs.getString(1));
							get.setAdmin(rs.getString(2));
						}
						
						if(pw.equals(get.getResult())) {
							if(get.getAdmin().equals("Y")) {
//								new ManagerChoice();
								dispose();
							}else {
								new Choice();
								dispose();
							}
						}else {
							alter.setText("id 혹은 비밀번호를 확인하세요.");
						}
						
					} catch(Exception e_compare) {
						System.out.println("e_compare_error");
					}
					
				}
			}
		});
		
		find_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new find_id();
			}
		});
		
		find_pw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new find_pw();
			}
		});
		
		
		setSize(400,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		
		//테스트용 임시프레임
		JFrame log_in=new login();
		

	}

}
